package com.crm.vtger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int count=0;
	int retyrycount=3;
	public boolean retry(ITestResult result) {
		while(count<retyrycount) {
			count++;
			return true;
		}
		return false;
	}

}
