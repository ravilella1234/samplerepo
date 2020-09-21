Feature: feature to test google search functionality

  Scenario: Validate google search is working or not
    Given Browser to open
    And user is on google search page
    When user enters a textin search box
    And Hits enter button
    Then User is navigated to search results page