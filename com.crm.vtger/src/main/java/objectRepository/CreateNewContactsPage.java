package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage {
	
@FindBy(name="lastname") private WebElement contactnameText;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void createContact(String contactnm) {
		contactnameText.sendKeys(contactnm);
		saveBtn.click();
	}

}
