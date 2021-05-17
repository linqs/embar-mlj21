package org.linqs.psl.reasoner.marginals;

import org.linqs.psl.application.groundrulestore.GroundRuleStore;
import org.linqs.psl.config.Config;
import org.linqs.psl.reasoner.Reasoner;
import org.linqs.psl.reasoner.admm.ADMMReasoner;
import org.linqs.psl.reasoner.admm.term.ADMMTermGenerator;
import org.linqs.psl.reasoner.admm.term.ADMMTermStore;
import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.marginals.term.MarginalObjectiveTerm;
import org.linqs.psl.reasoner.marginals.term.MarginalTermStore;
import org.linqs.psl.reasoner.term.TermStore;
import org.linqs.psl.util.RandUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sriramsrinivasan on 6/20/19.
 */
public abstract class AbstractMarginalsReasoner implements Reasoner {
    private static final Logger log = LoggerFactory.getLogger(AbstractMarginalsReasoner.class);

    private  static final String MARGINAL_PREFIX_STR = "marginal";
    private static final String NUM_SAMPLES = MARGINAL_PREFIX_STR + ".num_samples";
    private static final String MAP_INIT = MARGINAL_PREFIX_STR + ".map_init";
    private static final String OUTPUT_FOLDER = MARGINAL_PREFIX_STR + ".output";
    private static final int DEFAULT_NUM_SAMPLES = 5000;
    private static final String DEFAULT_OUTPUT_FOLDER = "marginals";

    protected int num_samples;
    protected String outupt_folder;
    protected String fname_map;
    protected String fname_samples;
    protected boolean map_init;
    public AbstractMarginalsReasoner(){
        num_samples = Config.getInt(NUM_SAMPLES, DEFAULT_NUM_SAMPLES);
        map_init = Config.getBoolean(MAP_INIT, true);
        outupt_folder = Config.getString(OUTPUT_FOLDER, DEFAULT_OUTPUT_FOLDER);
        fname_map = outupt_folder + "/id_to_var.tsv";
        fname_samples = outupt_folder + "/samples.tsv";
        File directory = new File(outupt_folder);
        if (! directory.exists()){
            directory.mkdirs();
        }
    }

    private float computeEnergy(Iterable<MarginalObjectiveTerm> terms) {
        float sum = 0;
        for (MarginalObjectiveTerm term : terms) {
            sum += term.evaluate();
        }
        return sum;
    }

    protected float getEnergy(MarginalTermStore marginalTermStore, AtomFunctionVariable var){
        final List<MarginalObjectiveTerm> terms = marginalTermStore.getTermsUsingVar(var);
        return computeEnergy(terms);
    }


    protected float getEnergy(MarginalTermStore marginalTermStore, Iterable<AtomFunctionVariable> vars){
        Set<MarginalObjectiveTerm> terms = new HashSet<MarginalObjectiveTerm>();
        for(AtomFunctionVariable var: vars){
            terms.addAll(marginalTermStore.getTermsUsingVar(var));
        }
        return computeEnergy(terms);
    }

    protected float[] getAverages(int numVariables, float[][] samples) {
        //compute average and update variables
        float[] expectation = new float[numVariables];
        for (int i = 0; i < num_samples; i++) {
            for (int j = 0; j < numVariables; j++) {
                expectation[j] += samples[i][j]/num_samples;
            }
        }
        return expectation;
    }


    protected void writeSamples(float[][] samples, MarginalTermStore marginalTermStore) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fname_samples));
            for (int i= 0 ; i < marginalTermStore.getNumVariables(); i++) {
                writer.append(marginalTermStore.getVariable(i).toString());
                if (i == marginalTermStore.getNumVariables()-1){
                    writer.append("\n");
                } else {
                    writer.append("\t");
                }
            }
            for (int i = 0; i < samples.length; i++) {
                for (int j = 0; j < samples[i].length; j++) {
                    writer.append(Float.toString(samples[i][j]));
                    if (j == samples[i].length - 1) {
                        writer.append("\n");
                    } else {
                        writer.append("\t");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeVariableIdAndName(MarginalTermStore marginalTermStore) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fname_map));
            for (int i= 0 ; i < marginalTermStore.getNumVariables(); i++) {
                String toBeWritten = i + "\t" + marginalTermStore.getVariable(i).toString() + "\n";
                writer.append(toBeWritten);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void computeMapState(GroundRuleStore groundRuleStore) {
        ADMMReasoner admmReasoner = new ADMMReasoner();
        ADMMTermStore admmTermStore = new ADMMTermStore();
        ADMMTermGenerator admmTermGenerator = new ADMMTermGenerator();
        final int admmTermsGenerated = admmTermGenerator.generateTerms(groundRuleStore,
                admmTermStore);
        admmReasoner.optimize(admmTermStore);
        admmReasoner.close();
        admmTermStore.close();
    }

    @Override
    public void close() {
    }

    @Override
    public void optimize(TermStore termStore) {
        MarginalTermStore marginalTermStore = (MarginalTermStore) termStore;
        final int numVariables = marginalTermStore.getNumVariables();
        final float approx_size_in_mem = numVariables * num_samples * 4/(1024*1024*1024);
        final float RAM_size = Runtime.getRuntime().maxMemory()/(1024*1024*1024);
        if (approx_size_in_mem > 0.5 * RAM_size && approx_size_in_mem < 0.95 * RAM_size ){
            log.warn("The array size required to store data is {}GB which is more than half RAM size {}GB",
                    approx_size_in_mem, RAM_size);
        }
        if (approx_size_in_mem >= 0.95*RAM_size) {
            log.error("Array to be created is larger than RAM size. Killing task. " +
                    "Memory required {}GB and RAM size {}GB", approx_size_in_mem, RAM_size);
            throw new RuntimeException(String.format("Array size in memory {}GB and RAM size {}GB",
                    approx_size_in_mem, RAM_size));
        }
        writeVariableIdAndName(marginalTermStore);
        float[][] samples = new float[num_samples][numVariables];
        if(map_init) {
            computeMapState(marginalTermStore.getRuleStore());
            for (int i = 0; i < numVariables; i++) {
                samples[0][i] = (float)marginalTermStore.getVariable(i).getValue();
            }
        } else {
            for (int i = 0; i < numVariables; i++) {
                samples[0][i] = RandUtils.nextFloat();
            }
            marginalTermStore.updateVariables(samples[0]);
        }
        performSampling(marginalTermStore, numVariables, samples);
        writeSamples(samples, marginalTermStore);
        float[] expectation = getAverages(numVariables, samples);
        marginalTermStore.updateVariables(expectation);

    }

    protected abstract void performSampling(MarginalTermStore marginalTermStore, int numVariables, float[][] samples);

}
