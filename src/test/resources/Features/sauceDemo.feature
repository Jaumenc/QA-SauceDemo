Feature: Test sauceDemo login

  Background: navigate to SauceDemo

    Given the user visit the sauce page


  Scenario: login successful

    When the user type username: 'standard_user' and password: 'secret_sauce'

    And the user click on login button

    Then user is logged


  Scenario Outline: login successful

    When the user type username: '<user>' and password: '<password>'

    And the user click on login button

    Then user is logged

    Examples:

      | user          | password     |

      | standard_user | secret_sauce |

      | standard_user | secret_sauce |

  @sauceDemo
  Scenario Outline: the user try to login with locked credentials
    When the user type username: '<user>' and password: '<password>'
    And the user click on login button
    Then message is displayed with the text '<errorMessage>'

    Examples:
      | user            | password     | errorMessage                          |
      | locked_out_user | secret_sauce | @PROPERTY_LOGIN_WITH_LOCKED_USER      |
      |                 |              | @PROPERTY_LOGIN_WITH_MISSING_USERNAME |
      | standard_user   |              | @PROPERTY_LOGIN_WITH_MISSING_PASSWORD |


  Scenario Outline: the user try to login and add to card and remove
    When the user type username: '<user>' and password: '<password>'
    And the user click on login button
    Then the user click on add to card button
    And the user click on the remove button from home page

    Examples:

      | user          | password     |

      | standard_user | secret_sauce |

      | standard_user | secret_sauce |

  @sauceDemo
  Scenario Outline: the user try to login and add to card and remove
    When the user type username: '<user>' and password: '<password>'
    And the user click on login button
    Then the user click on add to card button
    And the user click on the card button
    And the user click on the remove button from card page

    Examples:

      | user          | password     |

      | standard_user | secret_sauce |

      | standard_user | secret_sauce |