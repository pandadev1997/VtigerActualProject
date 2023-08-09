package com.crm.vtger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;



public class FileUtility {
	/**
	 * This method help us to fetch the data from property file
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromProperty(String data) throws Throwable {
		FileInputStream fis=new FileInputStream(Ipathconstant.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(data);
		return value;
	}

}
