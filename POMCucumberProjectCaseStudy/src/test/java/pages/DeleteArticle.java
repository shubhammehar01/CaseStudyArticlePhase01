package pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteArticle {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="(//button[contains(.,'Delete Article')])[1]") WebElement deleteBtn;
	@FindBy(xpath="//div[@class='article-preview']") List<WebElement> deleteSucc;
	
	//contructor for deleting the article
	public DeleteArticle(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		PageFactory.initElements(driver, this);
	}
	//method for deleting the article
	public void DeleteArtcile() {
		deleteBtn.click();
         Alert confirmationAlert = wait.until(ExpectedConditions.alertIsPresent());
         String actualAlertText = confirmationAlert.getText();
        String expectedAlertText = "Want to delete the article?";
        if (actualAlertText.equals(expectedAlertText)) {
            System.out.println("Alert verified: " + actualAlertText);
        } else {
            System.out.println("Alert mismatch!");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        confirmationAlert.accept();

      
    }
        
    //verify article delete or not 
	public boolean isDeleted() {
	    List<WebElement> elements = deleteSucc;
	    if (elements.isEmpty()) {
	        return false; 
	    }
	    return true;
	   
	}
	}
	
