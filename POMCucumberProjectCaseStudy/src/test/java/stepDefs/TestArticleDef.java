package stepDefs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddUpdateArticle;
import pages.DeleteArticle;
import pages.Login;

public class TestArticleDef {
	
	 WebDriver driver;
	 Login login1;
	 AddUpdateArticle article1;
	 DeleteArticle delete1;
	
	//constructor
	 public TestArticleDef()
	 {
			driver = TestBase.getdriver();
			login1= new Login(driver);
			article1 = new AddUpdateArticle(driver);
			delete1= new DeleteArticle(driver);
	 }
	
	 //Open url for Login page 
	@Given("User is on login Page")
	public void LoginPage() throws IOException {
		
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
		login1.launchLoginPage();
	}

	// user login details
	@When("User enters {string} and {string}")
	public void userLoginDetails(String name, String pwd) {
		 login1.login(name, pwd);
		 
	}

	//verify home page
	@Then("User should be on Home page")
	public void verifyHomePage() {
		login1.verifyLoginSuccess();
		System.out.println (" Login is successful!!! ");
	}
	
	//Create Article
	@Given("User should be Article Page")
	public void verifyArticlePage() {
	    article1.launchArticle();
	}

	//create the article
	@When("User Create Article {string} and {string} and {string} and {string}")
	public void createArticle(String title, String desc, String body, String tag) {
		  System.out.println (" Landed on to Article Creation Page!!! ");
		  article1.enterArticleDetails(title,desc,body,tag);
		  article1.publishArticle();
		  
		  }

	//verifying the article created or not
	@Then("Article must be Created")
	public void verifyArticle() {
		boolean success = article1.verifyHeader();
		if(success) {
		  System.out.println("New Article Published Successfully");}
		else { System.out.println("Title Already Exists");
		}
		}
	
	//Update Article
	@When("User Update an Article")
	public void UpdateArticle(DataTable dataTable) {
		
		List<Map<String,String>> users = dataTable.asMaps(String.class, String.class);
	    String oldTitle = users.get(0).get("oldtitle");
	    String newTitle = users.get(0).get("newtitle");
	    String desc  = users.get(0).get("desc");
	    String body  = users.get(0).get("body");
	    String tag   = users.get(0).get("tag");

	    System.out.println("Updating article from " + oldTitle + " to " + newTitle);
	    
	    if(oldTitle.equalsIgnoreCase("POQ5")) {
	    article1.editArticle();
	   
	    article1.updateArticleDetails(newTitle, desc, body, tag);
	   
	    article1.publishArticle();}
	}
	//verifying update of the article
	@Then("Article Should be Updated")
	public void verifyUpdatedArticle() {

	    boolean success = article1.verifyHeader();
		if(success) {
		  System.out.println("Edit Article Published Successfully");}
		else { System.out.println("Title Already Exists");
		}
	}

	// delete the article
	@When("User Delete an Article")
	public void DeleteArticle(DataTable dataTable) {
		List<Map<String,String>> users= dataTable.asMaps();
		String title1 = users.get(0).get("title");
		if(title1.equalsIgnoreCase("SDF5")) {
			delete1.DeleteArtcile();}
		  	}
	
	// verifying article deleted or not
	@Then("Article Should be Deleted")
	public void verifyDeletedArticle() {
		
		boolean deleteCheck = delete1.isDeleted();
		System.out.println("Deleted: "+ deleteCheck);
		
	}
	
	

	}
