package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[contains(@title,'Cr')]")
	private WebElement contactlookUp;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickcontactlookup() {
		contactlookUp.click();
	}

}
