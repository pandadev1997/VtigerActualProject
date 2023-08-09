package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class help us to do login
 * @author 3FR2
 *
 */
public class Loginpage {
	//Identify the webElement and declare the element as private
	@FindBy(name="user_name") private WebElement usernameEdt;
	
	@FindBy(name="user_password") private WebElement passwordEdt;
	
	@FindBy(css="#submitButton") private WebElement submitBtn;
	
	//create a constructor to initialize the webElement
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//create generic method for script optimization
	public void login(String un,String pw) {
		usernameEdt.sendKeys(un);
		passwordEdt.sendKeys(pw);
		submitBtn.click();
	}

}
