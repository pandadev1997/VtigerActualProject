package com.crm.vtger.practice;

import org.testng.annotations.Test;

public class FetchData {
	
	@Test(dataProviderClass = DTPrctc.class,dataProvider = "dt" )
	public void get(String phone,int price,String rating) {
		System.out.println(phone+"--->"+price+"-->"+rating);
		
	}

}
