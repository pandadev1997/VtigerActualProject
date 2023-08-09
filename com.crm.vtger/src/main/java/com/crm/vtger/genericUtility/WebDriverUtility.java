package com.crm.vtger.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the webpage window
	 * @param driver
	 */
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait the webpage for specific period of time
	 * @param driver
	 */
	public void wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Ipathconstant.implicitwaitDuration));
	}
	/**
	 * This method will wait the webpage for a specific period of time
	 * @param driver
	 * @param element
	 */
	public void visibilityofElement(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.ExlicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.ExlicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void alertPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.ExlicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void titleContains(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.ExlicitwaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method will help us handel dropdown
	 * @param elemnt
	 * @param index
	 */
	public void selectDropdown(WebElement elemnt,int index) {
		Select se=new Select(elemnt);
		se.selectByIndex(index);
	}
	public void selectDropdown(WebElement element,String value) {
		Select se=new Select(element);
		se.selectByValue(value);
	}
	
	public void selectDropdown(String text,WebElement element) {
		Select se=new Select(element);
		se.selectByVisibleText(text);
	}
	/**
	 * This method will handel mouse event action
	 * @param driver
	 * @param elemnt
	 */
	public void mouseHover(WebDriver driver,WebElement elemnt) {
		Actions act=new Actions(driver);
		act.moveToElement(elemnt).perform();
	}
	
	public void rightclick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void doubleclick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will help us to scroll the page 
	 * @param driver
	 * @param elemnt
	 */
	public void scrollThePageToElement(WebDriver driver,WebElement elemnt) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = elemnt.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", elemnt);
	}
	/**
	 * By using this method we can handel frame 
	 * @param driver
	 * @param index
	 */
	public void frame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void frame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void frame(WebDriver driver,String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	/**
	 * This method will help us to return back to parent frame
	 * @param driver
	 */
	public void parentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * By using this method we handel alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public String screenshot(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime local = LocalDateTime.now();
		String dt = local.toString().replace("-", "_").replace(":", "_");
		File dest=new File("./Screenshot/"+screenshotName+dt+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();//Extent report
		
	}

}
