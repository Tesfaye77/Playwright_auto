@Registration
Feature: User Registration Process Functionality

  Background: pre-requisites
    Given i'm Ztrain login page

 @reg01
  Scenario Outline: Registration
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then The user is connected "Z-Train"


    Examples:
      |      Email     | Mot de passe |Confirmer votre mot de passe|
      |greg1@gmail.com|   Ulrich10   |          Ulrich10          |
      |greg2@gmail.com|   Ulrich10   |          Ulrich10          |
      |greg3@gmail.com|   Ulrich10   |          Ulrich10          |


  @reg02
  Scenario Outline: Registration fail
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then Access is denied  "Les deux mots de passe ne sont pas identiques"

    Examples:
      |      Email     | Mot de passe |Confirmer votre mot de passe|
      |urih@gmail.com|   Ulrich1   |          Ulri          |

  @reg03
  Scenario Outline: Registration existing
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then the user is existing  "Cet utilisateur existe déjà"

    Examples:
      |      Email     | Mot de passe |Confirmer votre mot de passe|
      | u@gmail.com|   Ulrich10   |          Ulrich10          |