@login
Feature: Login
  As a visitor of the ecommerce website
  I want to be able to login

  Background: pre-requisites
    Given i open Ztrain login page

  @log01
  Scenario Outline: log01 - Login successfully
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then The user is connected with  "Z-Train"
    Examples:
      |          email      |     password    |
      |  ubogni@gmail.com   |   Ulrich77      |
      |  ubogni@gmail.co    |   Ulrich77      |


  @log02
  Scenario Outline: log02 - Login failed
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then Access is denied with the message "Email ou mot de passe incorrect"
    Examples:
      |          email      |     password   |
      |  ubogni@gmail.com   |   Ulrich7      |
      |  ubogni@gmail.com   |   Ulrich77      |

  @log03
  Scenario Outline: log03 - Login fail mail
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then Access is denied with "Le format de l'email est invalid"
    Examples:
      |          email      |     password    |
      |         ulrich      |   Ulrich77      |
      |  ubogni@gmail.com   |   Ulrich77      |

  @log04
  Scenario Outline: log04 - Logout
    When I'm in the login page with "<email>" and password "<password>"
    And I clicks to the logout button
    Then I'm logout
    Examples:
      |          email      |     password    |
      |  ubogni@gmail.com   |   Ulrich77      |