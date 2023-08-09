package com.crm.vtiger.organaisationTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtger.genericUtility.Baseclass;
import com.crm.vtger.genericUtility.ExcelUtility;
import com.crm.vtger.genericUtility.FileUtility;
import com.crm.vtger.genericUtility.JavaUtility;
import com.crm.vtger.genericUtility.WebDriverUtility;

import objectRepository.CreateNewOrgPage;
import objectRepository.Homepage;
import objectRepository.Loginpage;
import objectRepository.OrganaisationInfoPage;
import objectRepository.OrganaisationsPage;

public class VerifyuserCreateOrganaisationTest extends Baseclass  {

	@Test(dataProviderClass = ExcelUtility.class,dataProvider = "getmultiple",groups = "Regression")
	public void create(String org) throws Throwable{
		
		//String ActualORgName = eutil.getTheDataIntoExcel("Sheet1", 0, 0)+jutil.getRandom();
		String ActualORgName=org+jutil.getRandom();
		
		Homepage hop=new Homepage(driver);
		hop.orgclick();
		OrganaisationsPage op=new OrganaisationsPage(driver);
		op.orgLookup();
		
		CreateNewOrgPage crnop=new CreateNewOrgPage(driver);
		crnop.createOrg(ActualORgName);
		
		OrganaisationInfoPage orgi=new OrganaisationInfoPage(driver);
		String ExpectedORgName = orgi.getCreatedOrg();
		Assert.assertTrue(ExpectedORgName.contains(ActualORgName));
		System.out.println("pass");
		
		
		//hop.logout(driver);
		
		
	}

}
