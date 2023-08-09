package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.netty.util.Timeout;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;}

	By search = By.xpath("//*[@id=\"root\"]/div/header/div/div[2]/form/input");
	By productName = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/h4");
	By topDeals = By.linkText("Top Deals");
	By addQuantityText = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/input");
	By addToCartButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[3]/button");
	By increment = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/a[2]");
	public void SearchItems(String name) {
		
		driver.findElement(search).sendKeys(name);

	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();	
	}
	public void clickLink() {
		driver.findElement(topDeals).click();;
	}
	
	public String getTitleLandingPage() {
		return driver.getCurrentUrl();
	}
	//manual entry of quantity
	public void enterQuantityText(String quantity) {
		driver.findElement(addQuantityText).clear();
		driver.findElement(addQuantityText).sendKeys(quantity);
	}
	public void clickAddToCart() {
		driver.findElement(addToCartButton).click();

	}
	//using + operator
	public void incrementNTimes(int quantity) throws InterruptedException {
		int i = quantity-1;
		while(i>0) {
			i--;
			driver.findElement(increment).click();
			Thread.sleep(1000);

		}
	}
}
