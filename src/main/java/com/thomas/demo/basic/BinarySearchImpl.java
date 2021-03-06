package com.thomas.demo.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service //you can click command +1 to import the Component 
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	/*{
	// CONSTRUCTOR INJECTION
		public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
			super();
			this.sortAlgorithm = sortAlgorithm;
		}
		
	// SETTER INJECTION
		public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
			this.sortAlgorithm = sortAlgorithm;
		}
	
//	@Autowired // looks like this is equal to private SortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
//	private SortAlgorithm bubbleSortAlgorithm; 
	}*/
		
	@Autowired
	@Qualifier("quick")
	private SortAlgorithm sortAlgorithm; 
	
	/*This is just a fake search just for the purpose of the demo*/
	public int binarySearch(int[] numbers, int numberToSerchFor){
		int index;
		
		//logic to sort the array
		//BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		logger.info("in BinarySearchImpl: sortAlgorithm is: "+ sortAlgorithm);
		
		//logic to search in the array
		index = 3;
		//return the result
		return index;	
	}
	
	@PostConstruct /*will be called as soon as the bean has been created.
		The name of the method doesnt matter. 
		But it is important that you have to have the right annotation */
	public void PostConstruct(){
		logger.info("in BinarySearchImpl: ********** PostConstruct **********");
	}
	
	@PreDestroy
	public void PreDestroy() {
		logger.info("in BinarySearchImpl: ********** PreDestroy **********");
	}

}
