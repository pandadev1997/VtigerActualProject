package com.crm.vtger.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"test script execution started");
		test=reports.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"test script pass");
		test.log(Status.PASS, "test script pass");
	}

	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"test script fail");
		test.log(Status.FAIL, "test script failed");
		
		
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String screenshotname = methodname+jutil.systemDate();
		
		try {
			String path = wutil.screenshot(Baseclass.sdriver, screenshotname);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"test script skipped");
		test.log(Status.SKIP, "test script skipped");
	}

	public void onStart(ITestContext context) {
	
		System.out.println("suite level execution started");
		
		ExtentSparkReporter reporter=new ExtentSparkReporter("./ExtentReport\\Report-"+new JavaUtility().systemDate()+".html");
		reporter.config().setDocumentTitle("Vtiger Application Execution Report");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Vtiger Execution Report");
		
		 reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("BaseURL", "http://localhost:8888");
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("Reporter name", "Debasish");
		
		
		
	
	
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		
		System.out.println("suite level execution completed");
	}
	
	

}
