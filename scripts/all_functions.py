import pandas as pd
import numpy as np
from functools import reduce
import csv
from tqdm import tqdm as tn
import re
from sklearn.datasets import load_svmlight_file
import sys
csv.field_size_limit(sys.maxsize)

def read_psl_preds(file_name):
    max_so_far = 0
    max_len = 100000
    preds = np.zeros(max_len) - 1
    valid_index = set()
    preds_val = np.zeros(max_len)
    with open(file_name) as f:
        for line in f:
            line = line.strip()
            line = line.replace("'", "")
            src, cat, val = line.split("\t")
            src = int(src)
            cat = int(cat)
            val = float(val)
            if max_len <= src:
                max_len += 10000
                preds = np.append([preds, np.zeros(10000)-1])
                preds_val = np.append([preds_val, np.zeros(10000)])
            if val >= preds_val[src]:
                preds[src] = cat
                valid_index.add(src)
                preds_val[src] = val
            max_so_far = src if src > max_so_far else max_so_far
    valid_index = np.sort(np.array([i for i in valid_index]))
    return preds[:max_so_far+1], valid_index

def read_psl_samples(file_name):
    max_so_far = 0
    max_len = 100000
    preds = np.array([])
    preds_val = np.array([])
    valid_index = set()
    id_to_src_cat = dict()
    with open(file_name) as f:
        cf = csv.reader(f, delimiter="\t")
        line_num = 0
        count = 0
        for row in cf:
            count+=1
            col_num = 0
            if line_num == 0:
                for ele in row:
                    src, cat = ele.split(",")
                    src = int(re.sub("[^0-9]", "", src))
                    cat = int(re.sub("[^0-9]", "", cat))
                    max_so_far = src if src > max_so_far else max_so_far
                    id_to_src_cat[col_num] = [src, cat]
                    valid_index.add(src)
                    col_num += 1
                preds = np.zeros([1, max_so_far+1]) - 1
                preds_val = np.zeros([1, max_so_far+1])
            else :
                if count < 500:
                    continue
                if count >= 1100:
                    break
                for ele in row:
                    val = float(ele)
                    src, cat = id_to_src_cat[col_num]
                    if val >= preds_val[line_num-1, src]:
                        preds[line_num-1, src] = cat
                        preds_val[line_num-1, src] = val
                    col_num += 1
                preds = np.vstack([preds, np.zeros([1, max_so_far+1]) - 1])
                preds_val =  np.vstack([preds_val, np.zeros([1, max_so_far+1])])
            line_num += 1
    valid_index = np.sort(np.array([i for i in valid_index]))
    return preds[:-1], valid_index


def read_features(file_name):
    data = load_svmlight_file(file_name)
    return data[0], data[1].astype(np.int)

def get_graph(file_name, psl_truth):
    graph = np.zeros((psl_truth.shape[0], psl_truth.shape[0]))
    with open(file_name) as f:
        cf = csv.reader(f, delimiter="\t")
        for row in cf:
            src = int(row[0])
            dest = int(row[1])
            graph[src, dest] = 1
    return graph.astype(np.int)

def compute_mse(truth, pred):
    intersect = 0.0
    truth_tot = 0.0
    for k in truth.keys():
        intersect += len(pred[k])
        truth_tot += len(truth[k])
    return np.abs(intersect-truth_tot)/truth_tot


def computeQ1(preds, total_num_cat, valid_idx, graph):
    pairs = {}
    for i in range(total_num_cat):
        pairs[i] = set()
    x,y = np.where(graph==1)
    for i in range(x.shape[0]):
        if x[i] not in valid_idx or y[i] not in valid_idx:
            continue
        p1 = preds[x[i]]
        p2 = preds[y[i]]
        if p1 == p2 and p1 >= 0 and p2 >= 0:
            a,b = (x[i],y[i]) if x[i] < y[i] else (y[i],x[i])
            pairs[p1].add("{} {}".format(a,b))
    return pairs


def computeQ2(preds, total_num_cat, valid_idx, graph):
    pairs = {}
    for i in range(total_num_cat):
        pairs[i] = set()
    x,y = np.where(graph==1)
    for i in range(x.shape[0]):
        if x[i] not in valid_idx or y[i] not in valid_idx:
            continue
        p1 = preds[x[i]]
        p2 = preds[y[i]]
        if p1 != p2 and p1 >= 0 and p2 >= 0:
            a,b = (x[i],y[i]) if x[i] < y[i] else (y[i],x[i])
            pairs[p1].add("{} {}".format(a,b))
    return pairs


def Q3(pred, graph, src, start, pairs, m, valid_idx, path=set()):
    if len(path) == 0:
        path.add(src)
    if (m==0):
        return
    ids = np.where(graph[start] != 0)[0]
    for i in ids:
        if i in path:
            continue
        if i in valid_idx:
            pairs.add(pred[i])
        path.add(i)
        Q3(pred, graph, src, i, pairs, m-1, valid_idx, path)
        path.remove(i)


def computeQ3(pred, total_num_cat, valid_idx, graph, m=1, n=3):
    pairs = dict()
    set_of_papers = set()
    for j in valid_idx:
        p = set()
        Q3(pred, graph, j, j, p, m, valid_idx)
        if len(p) >= n:
            set_of_papers.add(j)
        p.clear()
    pairs[0] = set_of_papers
    return pairs


def computeQ4(preds, total_num_cat, valid_idx, graph):
    pairs = set()
    for i in valid_idx:
        out_e = preds[np.where(graph[i]==1)[0]]
        if (len(out_e) < 5):
            continue
        same = len(out_e[out_e==preds[i]])
        if same < (len(out_e)-same):
            pairs.add(i)
    return {0:pairs}

def computeQ5(preds, total_num_cat, valid_idx, graph):
    pairs = set()
    for i in valid_idx:
        out_e = preds[np.where(graph[i]==1)[0]]
        if (len(out_e) < 5):
            continue
        same = len(out_e[out_e==preds[i]])
        if same > (len(out_e)-same):
            pairs.add(i)
    return {0:pairs}
