package com.crm.vtger.practice;

import org.testng.annotations.DataProvider;

public class DTPrctc {
	
	@DataProvider
	public Object[][] dt(){
		
		Object[][] data=new Object[3][3];
		data[0][0]="samsung";
		data[0][1]=12000;
		data[0][2]="5star";
		
		data[1][0]="Nokia";
		data[1][1]=12000;
		data[1][2]="5star";
		
		data[2][0]="iphone";
		data[2][1]=12000;
		data[2][2]="5star";
		
		return data;
	}

}
