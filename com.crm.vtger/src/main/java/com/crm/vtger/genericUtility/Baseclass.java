package com.crm.vtger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.Homepage;
import objectRepository.Loginpage;

public class Baseclass {
	public ExcelUtility eutil=new ExcelUtility();
	public FileUtility futil=new FileUtility();
	public JavaUtility jutil=new JavaUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public static WebDriver sdriver;  //listner
	public WebDriver driver;
	
	@BeforeSuite(groups = {"smoke","Regression"})
	public void bsconfig() {
		System.out.println("data base conn");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"smoke","Regression"})
	public void bcConfig(/*String BROWSER*/) throws Throwable {
		String BROWSER = futil.getDataFromProperty("browser");
		//String BROWSER=System.getProperty("browser");
		String URL = futil.getDataFromProperty("url");
		
		//run time polymorphism
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			System.out.println(BROWSER+"launched");
		}
		
		else if(BROWSER.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
			System.out.println(BROWSER+"launch");
		
			}
		else
			System.out.println("invalid browser");
		sdriver=driver;//listner
		wutil.maximize(driver);
		wutil.wait(driver);
		driver.get(URL);
		}
	
	@BeforeMethod(groups = {"smoke","Regression"})
	public void bmConfig() throws Throwable {
		String UN = futil.getDataFromProperty("username");
		String PW = futil.getDataFromProperty("password");
	Loginpage lp=new Loginpage(driver);
	lp.login(UN, PW);
	Reporter.log("login happen succesfully");
	System.out.println("log into the app");
	Thread.sleep(2000);
	}
	
	@AfterMethod(groups = {"smoke","Regression"})
	public void amConfig() {
		Homepage hp=new Homepage(driver);
		hp.logout(driver);
		System.out.println("log from app");
		Reporter.log("logout happen succesfully");
	}
	//@AfterTest
	@AfterClass(groups = {"smoke","Regression"})
	public void acConfig() {
		driver.quit();
		System.out.println("close the browser");
		Reporter.log("browser close");
	}
	
	@AfterSuite(groups = {"smoke","Regression"})
	public void asConfig() {
		System.out.println("clse DB conn");
	}
	
	}

