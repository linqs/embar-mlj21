java -jar psl-cli-2.1.0.jar -l -m ../cli/model.psl -d ../cli/${3}/${1}-learn.${2}.data -e org.linqs.psl.evaluation.statistics.CategoricalEvaluator -D categoricalevaluator.defaultpredicate=hasCat -output wl-ip-${1}.${2}.${3} -D log4j.threshold=INFO -D votedperceptron.stepsize=10 -D votedperceptron.numsteps=50 -D votedperceptron.avgsteps=false --postgres psl

if [ ! -d "../output" ]; then
	mkdir ../output
fi
mv ../cli/model-learned.psl ../output/${1}-learned.${2}.${3}.psl
