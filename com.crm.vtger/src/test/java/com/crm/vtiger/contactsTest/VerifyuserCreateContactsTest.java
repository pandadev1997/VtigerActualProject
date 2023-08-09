package com.crm.vtiger.contactsTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtger.genericUtility.Baseclass;
import com.crm.vtger.genericUtility.ExcelUtility;
import com.crm.vtger.genericUtility.FileUtility;
import com.crm.vtger.genericUtility.JavaUtility;
import com.crm.vtger.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.Homepage;
import objectRepository.Loginpage;
@Listeners(com.crm.vtger.genericUtility.ListnerImplementation.class)
public class VerifyuserCreateContactsTest extends Baseclass {
	@Test(groups = "smoke",retryAnalyzer = com.crm.vtger.genericUtility.RetryAnalyser.class)
	public void contactTest() throws Throwable {
		
		
		Homepage hp=new Homepage(driver);
	
		ContactsPage cop=new ContactsPage(driver);
		Reporter.log("contact link click");
		
		String ActualContactName=eutil.getTheDataIntoExcel("Sheet2", 0, 0)+jutil.getRandom();
		hp.contactclick();
		cop.clickcontactlookup();
		Reporter.log("lookup image click",true);
		CreateNewContactsPage crnc=new CreateNewContactsPage(driver);
		crnc.createContact(ActualContactName);
		// Assert.fail();
		//wutil.screenshot(driver, "verify");
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String ExpConName = cip.getCreatedContact();
		Assert.assertTrue(ExpConName.contains(ActualContactName));
		System.out.println("pass");
		
		
	}
	
	@Test(groups = {"smoke","Regression"})
	public void demo() {
		System.out.println("regional");
		//Assert.fail();
		
	}
	
	}


