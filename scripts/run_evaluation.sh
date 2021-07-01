for data in cora pubmed citeseer;do 
    #for tr in 100 200 300 400 500;do 
    for tr in 500;do 
        echo "--------------------- Running ${data} ${tr} --------------------------";
	echo "cmd: python3 evaluate.py ${data} ${tr}";
        echo "----------------------------------------------------------------------";
	python3 evaluate.py ${data} ${tr}
        echo "---------------------------Done---------------------------------------";
    done;
done;

