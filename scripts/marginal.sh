java -jar  psl-cli-2.1.0.jar  -i -m ../output/${1}-learned.${2}.${3}.psl -d ../cli/${3}/${1}-eval.${2}.data -e org.linqs.psl.evaluation.statistics.CategoricalEvaluator -D categoricalevaluator.defaultpredicate=hasCat -output ip-pwg-${1}-${2}-${3} -D inference.termgenerator=org.linqs.psl.reasoner.marginals.term.MarginalTermGenerator -D inference.termstore=org.linqs.psl.reasoner.marginals.term.MarginalTermStore -D inference.reasoner=org.linqs.psl.reasoner.marginals.PairwiseABGibbsMarginalReasoner -D log4j.threshold=INFO -D marginal.output=samples-pwg-${1}-${2}-${3} --postgres psl -D marginal.num_samples=1000 -D abgibbs.weight_thresh=1000
mv ip-pwg-${1}-${2}-${3}/HASCAT.txt ../output/psl-pwg-${1}.${2}.${3}.tsv
rmdir ip-pwg-${1}-${2}-${3}
mv samples-pwg-${1}-${2}-${3}/samples.tsv ../output/samples-pwg-${1}.${2}.${3}.tsv
mv samples-pwg-${1}-${2}-${3}/id_to_var.tsv ../output/id_to_var-pwg-${1}.${2}.${3}.tsv
rmdir samples-pwg-${1}-${2}-${3}
