for data in cora citeseer pubmed;do 
    #for tr in 100 200 300 400 500;do 
    for tr in 500; do 
	    for fold in 1 2 3 4 5;do
	        echo "--------------------- Running ${data} ${tr} ${fold}--------------------------";
        	echo "cmd: ./weight_learn.sh ${data} ${tr} ${fold}";
	        echo "----------------------------------------------------------------------";
        	./weight_learn.sh ${data} ${tr} ${fold};
	        echo "---------------------------Done---------------------------------------";
	done;
    done;
done;

