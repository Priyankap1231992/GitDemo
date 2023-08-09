package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	TestContextSetup testContextSetUp;
	LandingPage landingPage;
	//WebDriver driver;
	//String landingPageProdName;  
	
	public LandingPageStepDefinitions(TestContextSetup testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
		this.landingPage = testContextSetUp.pageObjectManager.getLandingPage();

	}
	//WebDriver driver;
	String landingPageProdName,offerPageProductName ;
	@Given("User is on GreenCart landing Page")
	public void user_is_on_green_cart_landing_page() throws IOException, Throwable {
		//Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));	
		Thread.sleep(7000);

		System.out.println(landingPage.getTitleLandingPage());
	}
	@When("^User serched with short name (.+) and extracted actual name of the product$")
	public void user_serched_with_short_name_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
	landingPage.SearchItems(shortName);
	Thread.sleep(1000);

	testContextSetUp.landingPageProdName= landingPage.getProductName().split("-")[0].trim();
	  System.out.println(testContextSetUp.landingPageProdName);
	}
//    And Added "3" items of the selected product to Cart.

	@When("^Added (.+) items of the selected product to Cart$")
	public void added_items_of_the_selected_product_to_cart(String quantity) throws InterruptedException {
		// just by entering the value
		//landingPage.enterQuantityText(quantity);
		//by adding the increment method
		landingPage.incrementNTimes(Integer.parseInt(quantity));
		Thread.sleep(1000);
		landingPage.clickAddToCart();
}
}