@search
#noinspection GherkinBrokenTableInspection
Feature: Search
  As a user
  I want to search for products
  So that I can quickly find what I am looking for

  Background: pre-requisites
    Given I am connected to my account with "ubogni@gmail.com" and "Ulrich77"

  @srch01
  Scenario Outline: srch01-valid search
    When I do a multiple keyword search for "<multiple_keyword>"
    Then I see a multiple keyword search result page
    Examples:
      | multiple_keyword |
      | t-         |
      | Amp        |
      | polo        |



  @srch02
  Scenario Outline: srch02-fail search
    When I do a multiple keyword search for "<multiple_keyword>"
    Then I see a message "Aucun produit trouvé"
    Examples:
      |multiple_keyword|
      |mw|


