@sauceDemo
Feature: Test sauceDemo login

  Background: navigate to SauceDemo

    Given the user visit the sauce page

  #Escenario para hacer login

  Scenario: login successful

    When the user type username: 'standard_user' and password: 'secret_sauce'

    And the user click on login button

    Then user is logged

  #Escenario para hacer login

  Scenario Outline: login successful

    When the user type username: '<user>' and password: '<password>'

    And the user click on login button

    Then user is logged

    Examples:

      | user          | password     |
      | standard_user | secret_sauce |

  #Escenario para intentar login para ver los errores que pueden dar

  Scenario Outline: the user try to login with locked credentials
    When the user type username: '<user>' and password: '<password>'
    And the user click on login button
    Then message is displayed with the text '<errorMessage>'

    Examples:
      | user            | password     | errorMessage                          |
      | locked_out_user | secret_sauce | @PROPERTY_LOGIN_WITH_LOCKED_USER      |
      |                 |              | @PROPERTY_LOGIN_WITH_MISSING_USERNAME |
      | standard_user   |              | @PROPERTY_LOGIN_WITH_MISSING_PASSWORD |

  #Escenario para añadir un producto al carrito y borrarlo desde el homepage

  Scenario Outline: the user try to login and add to card and remove
    When the user type username: '<user>' and password: '<password>'
    And the user click on login button
    And the user add the product 'Sauce Labs Backpack' to cart button
    And the user click on the remove button from home page

    Examples:

      | user          | password     |
      | standard_user | secret_sauce |

    #Escenario para añadir un producto al carrito y borrarlo desde la pagina del carrito

  Scenario Outline: the user try to login and add to card and remove
    When the user type username: '<user>' and password: '<password>'
    And the user click on login button
    And the user add the product 'Sauce Labs Backpack' to cart button
    And the user click on the cart button
    And the user click on the remove button from card page

    Examples:

      | user          | password     |
      | standard_user | secret_sauce |

    #Escenario para añadir productos al carrito y verificar si aparecen en el pop up

    Scenario Outline: the user try to login and add to card and verify the pop up products
      When the user type username: '<user>' and password: '<password>'
      And the user click on login button
      And the user add the product 'Sauce Labs Backpack' to cart button
      And the user add the product 'Test.allTheThings() T-Shirt (Red)' to cart button
      Then the user verifies that there are '2' pop up products in the cart

      Examples:

        | user          | password     |
        | standard_user | secret_sauce |

  #Escenario para verificar que cambia el nombre del boton


  Scenario Outline: the user try to login and add to card and remove
    When the user type username: '<user>' and password: '<password>'
    And the user click on login button
    And the user add the product 'Sauce Labs Backpack' to cart button
    Then the user verifies if the button of 'Sauce Labs Backpack' have been changed to remove button

    Examples:

      | user          | password     |
      | standard_user | secret_sauce |

  #Escenario para verificar que cambia el color del boton


  Scenario Outline: the user try to login and add to card and remove
    When the user type username: '<user>' and password: '<password>'
    And the user click on login button
    And the user add the product '<product>' to cart button
    Then the user verifies if the button of '<product>' have been changed the remove button color

    Examples:

      | user          | password     | product             |
      | standard_user | secret_sauce | Sauce Labs Backpack |