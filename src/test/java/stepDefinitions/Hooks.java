package stepDefinitions;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	@After

	public void AfterSceanrio() throws IOException, InterruptedException {
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException, InterruptedException {
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed()) {
			// take screenshots for failed cases
			//cast your driver with Takesscreenshot inetrface then cal teh method
			
			
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// now attch this sceanrio to extent report then etxent report will read and capture
			//io will help use to covert the file in byte format
			// two keay values in externt propertied where to store the screemtot
			byte[] filecontent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(filecontent,"image/png", "image");
		}
		
	}
}
