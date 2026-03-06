package testScript;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = "src//test//resources//featuresFile//Article.feature",
glue = {"stepDefs"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty",
				"html:test-output/report/HTMLReport.html",
				"json:test-output/report/JsonReport.json",
				"rerun:test-output/report/failedScenarios.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		}
)

public class TestScript extends AbstractTestNGCucumberTests {
	

}



