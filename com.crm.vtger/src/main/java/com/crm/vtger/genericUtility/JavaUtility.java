package com.crm.vtger.genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method will create random number
	 * @return
	 */
	
	public  int getRandom() {
		Random r=new Random();
		int random = r.nextInt(1000);
				return random;
	}
	/**
	 * By using this method we get current system date
	 * @return
	 */
	public String currentDate() {
		Date d=new Date();
		String dat = d.toString();
		System.out.println(dat);
		return dat;
	}
	/**
	 * By using this method we modify the current date
	 * @return
	 */
	public String systemDate() {
		Date d=new Date();
		String dt[]=d.toString().split(" ");
		
		String month=dt[1];
		String day=dt[0];
		String date=dt[2];
		String year=dt[5];
		String currentdt=day+" "+month+" "+date+" "+year;
		System.out.println(currentdt);
		return currentdt;
	}

}
