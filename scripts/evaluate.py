from all_functions import *
from sklearn.metrics import accuracy_score
import sys

dataset = sys.argv[1]
num_training_samples = sys.argv[2]
data_folder = "../data/"
q3_n = 3
num_folds = 5
num_mets = 6

def get_len(pred):
    intersect = 0.0
    for k in pred.keys():
        intersect += len(pred[k])
    return intersect

def compute_metrics(read_fn, fold):
    sample_file = "../output/samples-pwg-" + dataset + "." + num_training_samples + "." + fold + ".tsv"
    metrics = np.zeros([6])
    num_samples = 100

    sample_preds, val_idx = read_fn(sample_file)
    order = np.arange(sample_preds.shape[0])
    np.random.shuffle(order)
    sample_preds = sample_preds[order]

    psl_truth, truth_valid_idx = read_psl_preds(data_folder + "/" + fold + "/" + dataset + "/tr" + num_training_samples + "/" + dataset + "_label.truth.test."+ fold + "." + num_training_samples+".txt")
    total_num_cat = np.int(psl_truth.max() + 1)
    valid_idx = set(truth_valid_idx)
    graph = get_graph(data_folder + "/" + fold + "/" + dataset + "/tr" + num_training_samples + "/" + dataset + "_graph.test." + fold + "." + num_training_samples + ".txt", psl_truth)
        
    truth_pairs_Q1 = computeQ1(psl_truth, total_num_cat, valid_idx, graph)
    truth_pairs_Q2 = computeQ2(psl_truth, total_num_cat, valid_idx, graph)
    truth_pairs_Q3 = computeQ3(psl_truth, total_num_cat, valid_idx, graph, n=q3_n)
    truth_pairs_Q4 = computeQ4(psl_truth, total_num_cat, valid_idx, graph)
    truth_pairs_Q5 = computeQ5(psl_truth, total_num_cat, valid_idx, graph)
        
    if not (val_idx is None):
        if not (len(np.setdiff1d(truth_valid_idx, val_idx))==0 and 
                sample_preds.shape[1] == psl_truth.shape[0]):
            print ("Dimensions mismatch or valid_idx mismatch. Please check.")

    truth_tot_Q = np.zeros(5)
    truth_tot_Q[0] = get_len(truth_pairs_Q1)
    truth_tot_Q[1] = get_len(truth_pairs_Q2)
    truth_tot_Q[2] = get_len(truth_pairs_Q3)
    truth_tot_Q[3] = get_len(truth_pairs_Q4)
    truth_tot_Q[4] = get_len(truth_pairs_Q5)

    for k in range(num_samples):
        metrics[0] += (1 - accuracy_score(psl_truth[truth_valid_idx], sample_preds[k][truth_valid_idx]))
        metrics[1] += get_len(computeQ1(sample_preds[k], total_num_cat, valid_idx, graph))
        metrics[2] += get_len(computeQ2(sample_preds[k], total_num_cat, valid_idx, graph))
        metrics[3] += get_len(computeQ3(sample_preds[k], total_num_cat, valid_idx, graph, n=q3_n))
        metrics[4] += get_len(computeQ4(sample_preds[k], total_num_cat, valid_idx, graph))
        metrics[5] += get_len(computeQ5(sample_preds[k], total_num_cat, valid_idx, graph))

    for q in range(6):
        metrics[q] /= float(num_samples)
        
        #Is not accuracy compute relative error
        if q != 0:
            metrics[q] = np.abs(metrics[q]-truth_tot_Q[q-1])/float(truth_tot_Q[q-1])
    return metrics

psl_mar_all_met = np.zeros([num_folds, num_mets])
for f in range(num_folds):
    fold = str(f+1)
    print("Computing metrics for fold :" + fold)
    psl_mar_all_met[f] = compute_metrics(read_psl_samples, fold)
agq = psl_mar_all_met.mean(0)
for q in range(6):
    print("Error for Q" + str(q) + ":" + str(agq[q]))
