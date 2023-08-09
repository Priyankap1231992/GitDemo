package stepDefinitions;


import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckOut;
import utils.TestContextSetup;

public class CheckOutPageDefinition {
	TestContextSetup testContextSetup;
	public CheckOut checkOut;
	
	
	public CheckOutPageDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		 this.checkOut =  testContextSetup.pageObjectManager.getCheckOutPage();

	}
	
	@Then("^User proceeded to checkout page and validated the (.+) items in checkout page$")
	public void user_proceeded_to_checkout_page_and_validated_the_items_in_checkout_page(String name) throws InterruptedException {

		checkOut.clickCartBagItems();
		Thread.sleep(1000);
		
		
	}
	@Then("verify user and abilty to enter promocode and place the order")
	public void verify_user_and_abilty_to_enter_promocode_and_place_the_order() throws InterruptedException {
		
		 Assert.assertTrue(checkOut.verifyPromobutton());
		 Assert.assertTrue(checkOut.verifyPlaceOrder());

	}
	
	
}