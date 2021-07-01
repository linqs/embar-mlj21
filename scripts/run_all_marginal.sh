for data in citeseer cora pubmed;do 
    #for tr in 100 200 300 400 500;do 
    for tr in 500;do 
	    for fold in 1 2 3 4 5; do
        	echo "--------------------- Running ${data} ${tr} --------------------------";
	        echo "cmd: ./marginal.sh ${data} ${tr} ${fold}";
        	echo "----------------------------------------------------------------------";
	        ./marginal.sh ${data} ${tr} ${fold};
        	echo "---------------------------Done---------------------------------------";
	done;
    done;
done
