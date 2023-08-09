package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtger.genericUtility.WebDriverUtility;

public class Homepage extends WebDriverUtility {
	
	@FindBy(linkText = "Organizations") private WebElement orgLink;
	
	@FindBy(linkText = "Contacts") private WebElement contactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Admistrator;
	
	@FindBy(xpath="//a[.='Sign Out']") private WebElement signoutBtn;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void orgclick() {
		orgLink.click();
	}
	
	public void contactclick() {
		contactLink.click();
	}
	
	public void logout(WebDriver driver) {
		mouseHover(driver, Admistrator);
		signoutBtn.click();
	}
	

}
