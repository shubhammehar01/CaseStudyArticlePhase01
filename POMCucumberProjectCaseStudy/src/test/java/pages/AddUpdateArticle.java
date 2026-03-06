package pages;


import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUpdateArticle {
	
	@FindBy (xpath="//a[contains(.,'New Article')]") WebElement newArt;
	@FindBy(xpath="//input[@name='title']") WebElement titleElement;
	@FindBy(xpath ="//input[@name='description']") WebElement descElement;
	@FindBy(xpath="//textarea[@name='body']") WebElement bodyElement;
	@FindBy(xpath="//input[@name='tags']") WebElement tagElement;
	@FindBy(xpath="//button[@type='submit']") Webment publish;
	@FindBy(xpath="//span[@class='error-messages']") List<Webment> errormsg;
	
	@FindBy(xpath="//h1") WebElement header;
	
	@FindBy(xpath="//a[contains(.,'Edit Article')]") WebElement editArticle;
	@FindBy(xpath="//button[contains(.,'Update Article')]") WebElement updatetArticle;

	// Constructor 
	public AddUpdateArticle(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	//launch the article
	public void launchArticle()
	{
		newArt.click();
	}

	//verify article publish or not
	public boolean isArticlePageDisp() {	
		return newArt.isDisplayed();
	}
	
	//adding articles details
	public void enterArticleDetails(String title, String desc,String body, String tag) {
		titleElement.clear();
		titleElement.sendKeys(title);
		descElement.clear();
		descElement.sendKeys(desc);
		bodyElement.clear();
		bodyElement.sendKeys(body);
		tagElement.clear();
		tagEle.sendKeys(tag);
			}
	//Update Article Details
	public void updateArticleDetails(String title, String desc,String body, String tag) {
		titleElement.clear();
		titleElement.sendKeys(title);
		descElement.clear();
		descElement.sendKeys(desc);
		bodyElement.clear();
		bodyElement.sendKeys(body);
		tagElement.clear();
		tagElement.sendKeys(tag);
			}
	//public article
	public void publishArticle() {
		publish.submit();
		
	}

		//verify header
		public boolean verifyHeader() {
			try {
		        return header.isDisplayed();
		    } catch (org.openqa.selenium.NoSuchElementException e) {
		        return false;
		    }
		}
	// Check err if
	public boolean checkErr() 
	{

		List<WebElement> errors = errormsg;
		if (!errors.isEmpty()) {
		    System.out.println("Error message: " + errors.get(0).getText());
		    return true;
		} else {
		    System.out.println("No error message displayed.");
		    return false;
		}
		
		}

	//edit article method
	public void editArticle() {
		editArticle.click();
			}
	//update article method
	public void updatetArticle() {
		updatetArticle.click();
	}
	
}
