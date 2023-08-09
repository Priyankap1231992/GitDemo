package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinitions {
	TestContextSetup testContextSetUp;
	String offerPageProductName;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;
	OffersPage offersPage;
	public OfferPageStepDefinitions(TestContextSetup testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
	}
	@Then("^User searched for (.+) shortname in offers page to check if product exist with same name$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String name) throws InterruptedException {
		
		switchToOffersPage();
		Thread.sleep(1000);

		offersPage = testContextSetUp.pageObjectManager.getOfferPage();
		offersPage.searchItem(name);
		Thread.sleep(1000);
		offerPageProductName = offersPage.getProductName();
		System.out.println(offerPageProductName);
	}
	@Then("User validates the product name in offer and in landing page")
	public void validationCode() {
	Assert.assertEquals(testContextSetUp.landingPageProdName, offerPageProductName);
	
}
public void switchToOffersPage() throws InterruptedException {
	//landingPage = new testContextSetUp.pageObjectManager.getLandingPage();
	//pageObjectManager = new PageObjectManager(testContextSetUp.driver);
	landingPage = testContextSetUp.pageObjectManager.getLandingPage();
	landingPage.clickLink();
	Thread.sleep(1000);
	testContextSetUp.genericClass.switchWindowToChild();
	
}

}
