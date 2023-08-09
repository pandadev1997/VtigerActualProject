package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
@FindBy(css=".dvHeaderText") private WebElement headerText;
	
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String getCreatedContact() {
		return headerText.getText();
	}

}
