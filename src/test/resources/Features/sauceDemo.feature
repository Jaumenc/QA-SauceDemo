Feature: Test sauceDemo login

  Background: navigate to SauceDemo

    Given the user visit the sauce page


  Scenario: login successful

    When the user type username: 'standard_user' and password: 'secret_sauce'

    And the user click on login button

    Then user is logged


  @sauceDemo

  Scenario Outline: login successful

    When the user type username: '<user>' and password: '<password>'

    And the user click on login button

    Then user is logged

    Examples:

      | user | password |

      | standard_user | secret_sauce |

      | standard_user | secret_sauce |