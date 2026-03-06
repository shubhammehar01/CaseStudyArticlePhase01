package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
	
	@FindBy(xpath="//a[contains(.,'Login')]") WebElement login;
	@FindBy(xpath="//input[@name='email']") WebElement email;
	@FindBy(xpath="//input[@name='password']") WebElement pwd;
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary pull-xs-right']") WebElement loginBtn;
	@FindBy(xpath="//button[@class='nav-link active']") WebElement login10;


	// constructor for login
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	// launch login page
	public void launchLoginPage()
	{
		login.click();
	}
	//login through user name and passs
	public void login(String username, String pass)
	{
		email.sendKeys(username);
		pwd.sendKeys(pass);
		loginBtn.click();
	}

	//verifing login 
	public boolean verifyLoginSuccess()
	{
			return login10.isDisplayed();
	}
}
