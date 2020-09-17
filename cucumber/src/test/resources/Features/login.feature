Feature: Feature to test login functionality

  Scenario: Check login is successful with valid cridientials
    Given user is on login page
    When user enters username and password
    And Clicks on login buton
    Then user should navigated to the home page

  Scenario Outline: Check login is successful with valid cridientials
    Given user is on login page
    When user enters <username> and <password>
    And Clicks on login buton
    Then user should navigated to the home page

    Examples: 
      | username  | password |
      | ravilella | test1234 |
      | sai       | test1234 |
