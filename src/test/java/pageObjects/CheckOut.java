package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {

 public WebDriver driver;
 
 public CheckOut(WebDriver driver) {
	 this.driver = driver;
 }
	By cartBag = By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/a[4]/img");
	By proceedChekOut = By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/div[2]/div[2]/button");
	By productName = By.xpath("//*[@id=\"productCartTables\"]/tbody/tr/td[2]/p");
	By promoApplyButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/button");
	By placeOrder = By.xpath("//*[@id=\"root\"]/div/div/div/div/button");
	By promoCodeField = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/input");

public void clickCartBagItems() throws InterruptedException {
	Thread.sleep(1000);

	driver.findElement(cartBag).click();
	Thread.sleep(1000);
	System.out.println("********");

	driver.findElement(proceedChekOut).click();
}
public boolean verifyPromobutton() throws InterruptedException {
	Thread.sleep(1000);

	return driver.findElement(promoApplyButton).isDisplayed();
}

public boolean verifyPlaceOrder() throws InterruptedException {
	Thread.sleep(1000);

	return driver.findElement(placeOrder).isDisplayed();
}
}

