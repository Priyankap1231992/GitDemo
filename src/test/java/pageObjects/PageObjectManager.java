package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public LandingPage landingPage;
	public OffersPage offersPage;
	public WebDriver driver;
	public CheckOut checkOut;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	public OffersPage getOfferPage() {
	offersPage = new OffersPage(driver);
	return offersPage;
	}
	public CheckOut getCheckOutPage() {
		checkOut = new CheckOut(driver);
		return checkOut;
	}
}
