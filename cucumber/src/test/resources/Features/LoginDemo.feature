Feature: Test the login functionality

	@regression
  Scenario Outline: Check login is successful with valid credientials
    Given Open the Browser
    And USer is on login page
    When User enters <username> and <password>
    Then User is navigated to the login homepage

    Examples: 
      | username  | password |
      | ravikanth |    12345 |
      | sai       |    12345 |
      | kiran     |    12345 |

  @smoke
  Scenario: Dummy scenario1
  Given hi
  
  
  @smoke @regression
  Scenario: Dummy scenario2
  Given  hello
  
  
  @sanity
  Scenario: Dummy scenario3
  Given  GM
