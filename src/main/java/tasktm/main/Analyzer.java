package tasktm.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tasktm.bean.TasktmBase;

public class Analyzer extends Processer {

	public void analyze(){

		//1. filter
		filter(beanMap);

	}


	/**
	 * filter List<TasktmBase>(in beanMap) by transaction typep user defined
	 *
	 * */
	public void filter(Map<String, List<TasktmBase>> beanMap) {

		List<String> filterList =
				Arrays.asList( properties.getProperty(TRANSACTION_TYPE).split(COMMA) );
		//keeping the order of configuration

		for (String filterType : filterList){

			//reduce beanMap for faster procedure
			Set<String> compoSet = beanMap.keySet();
			Iterator<String> ite = compoSet.iterator();
			String compo = null;
			/** previous tasktm list */
			List<TasktmBase> list;
			/** List for swaping after filtering */
			List<TasktmBase> tmpList;
			// loop for each compo
			while (ite.hasNext()){
				compo = ite.next();
				list = beanMap.get(compo);
				tmpList = new ArrayList<>();
				int i;
				for (i = 0 ; i < list.size() ; i++){
					// if matched to filter type
					if (list.get(i).getTransactiontype().equals(filterType) ){
						tmpList.add(list.get(i));
					};
				}
				// filter List
				list = tmpList;
				tmpList = null;
			}
		}
	}

	//TODO remove this when it will be unneeded
	public Integer add(int a1, int a2) {

		return a1+a2;

	}


}
