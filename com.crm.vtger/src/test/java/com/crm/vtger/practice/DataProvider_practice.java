package com.crm.vtger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_practice {
	
	@DataProvider(name = "dt")
	public Object[][] data(){
		Object[][] data=new Object[3][2];
		data[0][0]="samsung";
		data[0][1]=10000;
		data[1][0]="Nokia";
		data[1][1]=20000;
		data[2][0]="iphone";
		data[2][1]=60000;
		return data;
	}
	
	@Test(dataProvider = "dt")
	public void getdata(String phone,int price) {
		System.out.println(phone+"-->"+price);
	}

}
