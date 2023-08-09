package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.CheckOut;
import pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String landingPageProdName;    
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericClass genericClass;

	public TestContextSetup() throws IOException, InterruptedException {
	testBase = new TestBase();	
	pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
	genericClass = new GenericClass(testBase.WebDriverManager());
	}
}
