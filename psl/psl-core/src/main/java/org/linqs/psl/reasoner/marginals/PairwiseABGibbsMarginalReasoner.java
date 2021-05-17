package org.linqs.psl.reasoner.marginals;

import org.linqs.psl.config.Config;
import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.marginals.term.MarginalObjectiveTerm;
import org.linqs.psl.reasoner.marginals.term.MarginalTermStore;
import org.linqs.psl.util.RandUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * #Metropolis within Gibbs with grouped variables.
 for i in tqdm_notebook(range(num_rounds-1)):
 samples_migg[i+1] = samples_migg[i]
 for j in variables_grouping:
 prev_y = samples_migg[i+1]
 new_y = prev_y.copy()
 zoo = 0#np.random.binomial(1,0.5)
 new_y[j[zoo]] = np.random.uniform(0,1)
 if j.shape[0] == 2:
 if zoo == 0:
 #new_y[j[1]] = np.random.uniform(new_y[j[0]] - 0.0, new_y[j[0]] - 0.0)
 new_y[j[1]] = np.random.uniform(0.999 - new_y[j[0]],  1.001 - new_y[j[0]])
 #new_y[j[1]] = np.random.normal(1-new_y[j[0]], 0.001)
 if j.shape[0] >2:
 print("ERRORRRRR.....")
 log_alpha = get_energy_more_eyes(prev_y, data, j) - get_energy_more_eyes(new_y, data, j)
 should_i_reject = False
 for g in j:
 if new_y[g] < 0 or new_y[g]>1:
 should_i_reject = True
 break
 if np.log(np.random.uniform(0,1)) < log_alpha and not should_i_reject:
 alphas[i+1, j] = 1
 samples_migg[i+1][j] = new_y[j]
 energies[i+1, j] = get_energy_more_eyes(samples_migg[i+1], data, j)
 * Created by sriramsrinivasan on 6/29/19.
 * BUGBUG: Not a very well written code.
 */
public class PairwiseABGibbsMarginalReasoner extends AbstractMarginalsReasoner {
    private static final Logger log = LoggerFactory.getLogger(PairwiseABGibbsMarginalReasoner.class);
    private  static final String PREFIX_STR = "abgibbs";

    private static final String WEIGHT_THRESHHOLD = PREFIX_STR+".weight_thresh";
    private static final float DEFAULT_WEIGHT_THRESHHOLD = 100f;
    private static final String INTERVAL_THRESHHOLD = PREFIX_STR+".int_thresh";
    private static final float DEFAULT_INTERVAL_THRESHHOLD = 0.1f;
    private static float weightThreshhold;
    private static float intervalThreshhold;

    public PairwiseABGibbsMarginalReasoner(){
        weightThreshhold = Config.getFloat(WEIGHT_THRESHHOLD, DEFAULT_WEIGHT_THRESHHOLD);
        intervalThreshhold = Math.max(Config.getFloat(INTERVAL_THRESHHOLD, DEFAULT_INTERVAL_THRESHHOLD), 0.0001f);
    }

    @Override
    protected void performSampling(MarginalTermStore marginalTermStore, int numVariables, float[][] samples) {
        log.info("Getting blocks.");
        Map<Integer, List<AtomFunctionVariable>> blockIdToVar = new HashMap<>();
        Map <AtomFunctionVariable, List<Block>> varToBlock = new HashMap<>();
        getBlocks(marginalTermStore, blockIdToVar, varToBlock);
        log.info("Starting to run Gibbs sampler. num samples:{}, number of variables: {}",
                num_samples, numVariables);
        int num_accepts = 0;
        Set<AtomFunctionVariable> sampledSoFar = new HashSet<>();
        Random rand = new Random(100);
        for (int i = 1; i < num_samples; i++) {
            sampledSoFar.clear();
            for (List<AtomFunctionVariable> vars : blockIdToVar.values()) {
                float prev_energy = getEnergy(marginalTermStore, vars);
                Collections.shuffle(vars, rand);
                for (int k = 0; k < vars.size() ; k++){
                    int id = RandUtils.nextInt(varToBlock.get(vars.get(k)).size());
                    varToBlock.get(vars.get(k)).get(id).sampleUpdate(vars.get(k), sampledSoFar);
                    sampledSoFar.add(vars.get(k));
                }
                for (AtomFunctionVariable var: vars) {
                    int j = marginalTermStore.getIndex(var);
                    samples[i][j] = (float)var.getValue();
                }
                float new_energy = getEnergy(marginalTermStore, vars);
                float log_alpha = prev_energy - new_energy;
                num_accepts++;
                //if reject then replace value to previous.
                if (log_alpha <= Math.log(RandUtils.nextFloat())) {
                    for (AtomFunctionVariable var: vars) {
                        int j = marginalTermStore.getIndex(var);
                        var.setValue(samples[i-1][j]);
                        samples[i][j] = samples[i - 1][j];
                    }
                    num_accepts--;
                }
            }
        }
        log.info("Completed running marginals: acceptance ratio = {}",
                ((float)num_accepts/((float)num_samples* numVariables)));
    }

    private void getBlocks(MarginalTermStore marginalTermStore, Map<Integer,
            List<AtomFunctionVariable>> blockIdToVar,
                                Map <AtomFunctionVariable, List<Block>> varToBlock){
        Map<AtomFunctionVariable, Set<AtomFunctionVariable>> varToBlockId = new HashMap<>();
        Map<String, List<MarginalObjectiveTerm>> pairToVars = new HashMap<>();
        for (AtomFunctionVariable var : marginalTermStore.getAllVariables()) {
            Set<AtomFunctionVariable> set = new HashSet<>();
            set.add(var);
            varToBlockId.put(var, set);
        }

        for (MarginalObjectiveTerm term: marginalTermStore){
            if (term.getWeight() < weightThreshhold) {
                continue;
            }
            if (term.getVariables().size() > 2) {
                throw new RuntimeException("Only pairwise cliques with weight greater than " +
                        weightThreshhold + " allowed. Term violating this: " + term.toString());
            }
            if (term.getVariables().size() == 1) {
                continue;
            }
            String str = term.getVariables().get(0).toString() + term.getVariables().get(1).toString();
            List<MarginalObjectiveTerm> terms = pairToVars.get(str);
            if (terms == null) {
                terms = new ArrayList<>();
            }
            terms.add(term);
            pairToVars.put(str, terms);
        }
        Set<AtomFunctionVariable> allVars = new HashSet<>();
        allVars.addAll(marginalTermStore.getAllVariables());

        for (List<MarginalObjectiveTerm> terms: pairToVars.values()) {
            AtomFunctionVariable var1 = terms.get(0).getVariables().get(0);
            AtomFunctionVariable var2= terms.get(0).getVariables().get(1);
            Block blk = new PairwiseBlock(var1, var2, terms);
            List<Block> blocks1 = varToBlock.get(var1);
            List<Block> blocks2 = varToBlock.get(var1);
            if (blocks1 == null) {
                blocks1 = new ArrayList<>();
            }
            if (blocks2 == null) {
                blocks2 = new ArrayList<>();
            }
            blocks1.add(blk);
            blocks2.add(blk);
            varToBlock.put(var1, blocks1);
            varToBlock.put(var2, blocks2);
            Set b1 = varToBlockId.get(var1);
            Set b2 = varToBlockId.get(var2);
            b1.addAll(b2);
            if (b1 != b2) {
                b2.clear();
            }
            varToBlockId.put(var2, b1);

            allVars.remove(var1);
            allVars.remove(var2);

        }
        for (AtomFunctionVariable var : allVars) {
            List<Block> block = new ArrayList<>();
            block.add(new SingleVariableBlock());
            varToBlock.put(var, block);
        }
        Set<Set<AtomFunctionVariable>> blocks = new HashSet<>();
        blocks.addAll(varToBlockId.values());
        int i = 0;
        for (Set<AtomFunctionVariable> block : blocks) {
            List listBlock = new ArrayList<>();
            listBlock.addAll(block);
            blockIdToVar.put(i, listBlock);
            i++;
        }


    }


    interface Block {
        void sampleUpdate(AtomFunctionVariable var, Set<AtomFunctionVariable> sampledSet);
        AtomFunctionVariable getNeighbor(AtomFunctionVariable var);
    }

    class SingleVariableBlock implements Block {
        @Override
        public void sampleUpdate(AtomFunctionVariable var, Set<AtomFunctionVariable> sampledSet){
            if (sampledSet.contains(var)) {
                return;
            }
            var.setValue(RandUtils.nextFloat());
            sampledSet.add(var);
        }

        @Override
        public AtomFunctionVariable getNeighbor(AtomFunctionVariable var) {
            return null;
        }

    }

    class PairwiseBlock implements Block {
        private final AtomFunctionVariable var1;
        private final AtomFunctionVariable var2;
        private final List<MarginalObjectiveTerm> commonTerms;
        private float rPlusLowerLim;
        private float rPlusUpperLim;
        private float plusWeight;
        private boolean plusActive;

        private float rMinusLowerLim;
        private float rMinusUpperLim;
        private float minusWeight;
        private boolean minusActive;

        PairwiseBlock(AtomFunctionVariable var1, AtomFunctionVariable var2,
                      List<MarginalObjectiveTerm> commonTerms){
            this.var1 = var1;
            this.var2 = var2;
            this.commonTerms = commonTerms;
            rMinusLowerLim = 0;
            rMinusUpperLim = 1;
            rPlusLowerLim = 0;
            rPlusUpperLim = 1;
            plusWeight = weightThreshhold;
            minusWeight = weightThreshhold;
            plusActive = false;
            minusActive = false;
            computeUpperLowerLim();
        }

        void computeUpperLowerLim(){
            for (MarginalObjectiveTerm term: commonTerms){
                float c = term.getConstant();
                List<Float> coeffs = term.getCoeffs();
                float a = coeffs.get(0);
                float b = coeffs.get(1);
                if (a > 0 && b > 0 && c < rPlusUpperLim) {
                    //a+b <= c
                    rPlusUpperLim = c;
                    plusWeight = term.getWeight();
                    plusActive = true;
                } else if (a < 0 && b < 0 && -c > rPlusLowerLim ) {
                    //a+b >= -c
                    rPlusLowerLim = -c;
                    plusWeight = term.getWeight();
                    plusActive = true;
                } else if (a < 0 && b > 0 && -c > rMinusLowerLim) {
                    //a-b >= -c
                    rMinusLowerLim = -c;
                    minusWeight = term.getWeight();
                    minusActive = true;
                } else if (a > 0 && b < 0 && c < rMinusUpperLim) {
                    //a-b <= c
                    rMinusUpperLim = c;
                    minusWeight = term.getWeight();
                    minusActive = true;
                } else if (a == 0 || b == 0) {
                    throw new RuntimeException("There was a zero in the term : " + term.toString());
                }
            }
            if (rMinusLowerLim > rMinusUpperLim || rPlusLowerLim > rPlusUpperLim) {
                log.warn("Feasibility range is does not exist for this block. Might generate bad samples. ");
            } else if ((rMinusLowerLim > rPlusUpperLim && rMinusLowerLim > rMinusUpperLim) ||
                    (rPlusLowerLim > rMinusUpperLim && rPlusLowerLim > rMinusLowerLim)) {
                log.warn("Feasibility range is does not exist for this block due to " +
                        "non-overlapping plus and minus range. Might generate bad samples. ");
            }
        }

        //TODO: need to add comments explaining what is happening. The code sort of looks like a mess.
        public void sampleUpdate(AtomFunctionVariable var, Set<AtomFunctionVariable> sampledSet){
            if (!var.equals(this.var1) && !var.equals(this.var2)) {
                throw new RuntimeException("Asking for a variable that does not exist in the block.");
            }
            if (sampledSet.contains(var)){
                return;
            }
            if ((!sampledSet.contains(this.var1) && this.var2.equals(var)) || (!sampledSet.contains(this.var2) && this.var1.equals(var))) {
                var.setValue(RandUtils.nextFloat());
                sampledSet.add(var);
                return;
            }
            AtomFunctionVariable obsVar = (var.equals(this.var1)) ? this.var2 : this.var1;
            float obsVarVal = (float)obsVar.getValue();
            //TODO: For future, need to ensure we can have multiple active zones.
            if (plusActive && minusActive) {
                throw new UnsupportedOperationException("Cant have 2 active intervals yet.");
            }
            if (plusActive) {
                if (RandUtils.nextFloat() > 1/plusWeight &&
                        (Math.abs(rPlusUpperLim - rPlusLowerLim) < intervalThreshhold)) {
                    float ulim = 1;
                    float llim = 0;
                    if (rPlusLowerLim <= rPlusUpperLim) {
                        llim = rPlusLowerLim - obsVarVal;
                        ulim = rPlusUpperLim - obsVarVal;
                    } else {
                        llim = rPlusUpperLim - obsVarVal;
                        ulim = rPlusLowerLim - obsVarVal;
                    }
                    verifyRange(ulim, llim);
                    var.setValue(RandUtils.nextFloat(llim, ulim));
                } else {
                    var.setValue(RandUtils.nextFloat());
                }
            } else if (minusActive) {
                if (RandUtils.nextFloat() > 1/minusWeight &&
                        (Math.abs(rMinusUpperLim - rMinusLowerLim) < intervalThreshhold)) {
                    float ulim = 1;
                    float llim = 0;
                    if (obsVar.equals(this.var1)) {
                        if (rMinusLowerLim <= rMinusUpperLim) {
                            llim = obsVarVal - rMinusUpperLim;
                            ulim = obsVarVal - rMinusLowerLim;
                        } else {
                            llim = obsVarVal - rMinusLowerLim;
                            ulim = obsVarVal - rMinusUpperLim;
                        }
                    } else {
                        if (rMinusLowerLim <= rMinusUpperLim) {
                            llim = obsVarVal + rMinusLowerLim;
                            ulim = obsVarVal + rMinusUpperLim;
                        } else {
                            llim = obsVarVal + rMinusUpperLim;
                            ulim = obsVarVal + rMinusLowerLim;
                        }
                    }
                    verifyRange(ulim, llim);
                    var.setValue(RandUtils.nextFloat(llim, ulim));
                } else {
                    var.setValue(RandUtils.nextFloat());
                }
            } else {
                log.debug("No active range. This is same as doing Gibbs.");
                var.setValue(RandUtils.nextFloat());
            }
            sampledSet.add(var);
        }

        @Override
        public AtomFunctionVariable getNeighbor(AtomFunctionVariable var) {
            if (var.equals(this.var1)) {
                return var2;
            } else if (var.equals(this.var2)) {
                return var1;
            }
            return null;
        }

        private void verifyRange(float ulim, float llim) {
            if (llim < 0 || llim > 1 || ulim < 0 || ulim >1){
                throw new RuntimeException("Updated range not between zero and one.");
            }
        }


    }
}
