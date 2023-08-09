#Author: Priyanka Pandey
@OffersPage
Feature: Search and Place order for the products
Scenario Outline: Search expereince for product in both search and offers page 

Given User is on GreenCart landing Page
When User serched with short name <Name> and extracted actual name of the product
Then User searched for <Name> shortname in offers page to check if product exist with same name
Then User validates the product name in offer and in landing page

Examples: 
|Name|
|tom |
|pot|
|Bro |