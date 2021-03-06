package com.thomas.demo.basic.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Named //@Component
public class SomeCdiBusiness {
	
	@Inject //@Autowired
	SomeCdiDao someCdiDao;

	public SomeCdiDao getSomeCdiDao() {
		return someCdiDao;
	}

	public void setSomeCdiDao(SomeCdiDao someCdiDao) {
		this.someCdiDao = someCdiDao;
	}

	public int findTheGreatest(){
		int greatest = Integer.MIN_VALUE;
		int[] data = someCdiDao.getData();
		
		for (int i : data) {
			if(i > greatest){
				greatest = i; 
			}
		}
		return greatest;
	} //findTheGreatest
	

}
