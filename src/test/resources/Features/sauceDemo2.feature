Feature: Test sauceDemo page
  Background: login to SauceDemo
    Given the user visit the sauce page
    When the user type username: 'standard_user' and password: 'secret_sauce'
    And the user click on login button
    Then user is logged

  #Escenario para rellenar los campos del Checkout


  Scenario: the user try to add to card and go to checkout and fill the fields
    When the user add the product 'Sauce Labs Backpack' to cart button
    And the user click on the cart button
    And the user click on the checkout button
    And user fill the fields

      | field       | user1   |
      | first-name  | alfonso |
      | last-name   | suarez  |
      | postal-code | 07620   |

    And the user click on continue button
    Then the user click on finish button

  #Escenario para intentar checkout para ver los errores que pueden dar


  Scenario Outline: the user try to add to card and go to checkout and try to advance with empty fields
    When the user add the product 'Sauce Labs Backpack' to cart button
    And the user click on the cart button
    And the user click on the checkout button
    And the user type firstname: '<firstname>' lastname: '<lastname>' and postal code: '<postalcode>'
    And the user click on continue button
    Then checkout message is displayed with the text '<errorMessage>'

    Examples:
      | firstname | lastname | postalcode | errorMessage                           |
      |           | Suarez   | 07620      | @PROPERTY_CHECKOUT_MISSING_FIRST_NAME  |
      | Alfonso   |          | 07620      | @PROPERTY_CHECKOUT_MISSING_LAST_NAME   |
      | Alfonso   | Suarez   |            | @PROPERTY_CHECKOUT_MISSING_POSTAL_CODE |

  #Escenario para comprobar que el producto que esta en el pedido es correcto antes de finalizar el pedido

  @sauceDemo1
  Scenario: the user try to add to card and go to checkout and fill the fields
    When the user add the product 'Sauce Labs Backpack' to cart button
    And the user click on the cart button
    And the user click on the checkout button
    And user fill the fields
    #  | firstname | lastname | postalcode |
    #  | adolfo | suarez | 07620 |
      | field       | user1   |
      | first-name  | alfonso |
      | last-name   | suarez  |
      | postal-code | 07620   |
    And the user click on continue button
    Then the user verifies that the product name of 'Sauce Labs Backpack' is correct
