package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage {
	
	@FindBy(name="accountname") private WebElement orgnameText;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewOrgPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void createOrg(String orgnm) {
		orgnameText.sendKeys(orgnm);
		saveBtn.click();
	}

}
