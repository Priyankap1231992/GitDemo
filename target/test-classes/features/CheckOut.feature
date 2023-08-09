#Author: priyankap1231992@gmail.com

@PlaceOrderPage
Feature: Place an order for Products
  place an order

Scenario Outline: Place an order from landing page
    Given User is on GreenCart landing Page
		When User serched with short name <Name> and extracted actual name of the product
    And Added 3 items of the selected product to Cart
    Then User proceeded to checkout page and validated the <Name> items in checkout page
    And verify user and abilty to enter promocode and place the order
    
 Examples:
    |Name|
    |tom |
  

