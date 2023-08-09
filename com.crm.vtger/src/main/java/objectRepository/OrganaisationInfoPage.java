package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganaisationInfoPage {
	
	@FindBy(css=".dvHeaderText") private WebElement headerText;
	
	public OrganaisationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String getCreatedOrg() {
		return headerText.getText();
	}

}
