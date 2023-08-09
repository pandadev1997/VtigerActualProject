package com.crm.vtger.practice;

import com.crm.vtger.genericUtility.ExcelUtility;
import com.crm.vtger.genericUtility.FileUtility;
import com.crm.vtger.genericUtility.JavaUtility;

public class Genericutilitypractice {
public static void main(String[] args) throws Throwable {
	FileUtility futil=new FileUtility();
	String URL = futil.getDataFromProperty("url");
	System.out.println(URL);
	
	ExcelUtility eutil=new ExcelUtility();
	String orgname = eutil.getTheDataIntoExcel("Sheet1", 0, 0);
	System.out.println(orgname);
	
	JavaUtility jutil=new JavaUtility();
	jutil.currentDate();
	jutil.systemDate();
}
}
