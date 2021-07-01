# embar-mlj21
This repo contains the code and data for the paper "A Comparison of Statistical Relational Learning and
Graph Neural Networks for Aggregate Graph Queries".

To run the experiments, download the data from https://linqs-data.soe.ucsc.edu/public/embar-mlj21.zip.
Unzip the files in the data directory

Compile the PSL marginal code to generate the jar file.
To do this go to psl directory and run 
mvn clean install -DskipTests

Copy the generated jar psl-cli-2.1.0.jar to the scripts directory
cp ./psl-cli/target/psl-cli-2.1.0.jar ../scripts/

To lean the weights of the psl models run the run_all_wl.sh script
bash run_all_wl.sh
The learned models are written to the output directory

To generate the samples for the datasets run the run_all_marginal.sh script
bash run_all_marginal.sh
The generated samples are written to the output directory

To compute the accuracy and AGQs for the samples, run the run_evaluation.sh script
bash run_evaluation.sh
