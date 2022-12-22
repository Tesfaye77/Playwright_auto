@pdt
Feature: Product detail page
  As a user
  I want to be able to add and remove a product from my bag
  So that I can command something


  @pdt01
  Scenario: pdt01 - Add a product to my bag
    Given I am connected to my account "ubogni@gmail.com" and "Ulrich77"
    And I added to my bag
    Then I can see the message "Votre panier à été mis à jour"
