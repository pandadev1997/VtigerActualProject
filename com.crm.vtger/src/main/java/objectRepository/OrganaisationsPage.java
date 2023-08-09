package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganaisationsPage {
	
	@FindBy(xpath="//img[contains(@title,'Cr')]")
	private WebElement OrgLookupIcon;

	public OrganaisationsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	
	public void orgLookup() {
		OrgLookupIcon.click();
	}
	

	
	
	

}
