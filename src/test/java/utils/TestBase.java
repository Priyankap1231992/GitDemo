package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException, InterruptedException {
		
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//global.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String URL = properties.getProperty("QAUrl");
		String browser_properties = properties.getProperty("Browser");
		// the below code will frst check in maven then in proepties and code java ternanry operator
		String browser_maven =System.getProperty("Browser");
		
		//result = test condition ? valus 1 ? value 2
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		if(driver == null) {
		
			if(browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(URL);}
		
			else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
            // You can add additional options here if needed
			driver = new FirefoxDriver(firefoxOptions);
			driver.get(URL);}
		
		}
		return driver;
	}

}
