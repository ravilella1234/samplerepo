Feature: Feature to test login functionality

  @regression
  Scenario: Check login is successful with valid cridientials
    Given user is on login page
    When user enters username and password
    And Clicks on login buton
    Then user should navigated to the home page
