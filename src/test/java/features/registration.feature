@Registration
Feature: User Registration Process Functionality



  @reg01
  Scenario Outline: Registration
    Given i'm Ztrain login page
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then The user is connected "Z-Train"


    Examples:
      |      Email     | Mot de passe |Confirmer votre mot de passe|
      |uri@gmail.com|   Ulrich10   |          Ulrich10          |


  @reg02
  Scenario Outline: Registration fail
    Given i'm Ztrain login page
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then Access is denied  "Les deux mots de passe ne sont pas identiques"

    Examples:
      |      Email     | Mot de passe |Confirmer votre mot de passe|
      |urih@gmail.com|   Ulrich1   |          Ulri          |