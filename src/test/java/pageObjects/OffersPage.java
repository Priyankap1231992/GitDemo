package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	public WebDriver driver;
	
	public OffersPage(WebDriver driver){
		this.driver = driver;
	}
	
	By Search = By.xpath("//*[@id=\"search-field\"]");
	By ProdName = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/table/tbody/tr/td[1]");
	
	public void searchItem(String item) {
		driver.findElement(Search).sendKeys(item);
	}
	public String getProductName() {
		return driver.findElement(ProdName).getText();
	}

}
