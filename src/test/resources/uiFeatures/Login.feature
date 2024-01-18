@Login
Feature: This feature file validates Login Functionality

  @smoke
  Scenario: User should be able to login to HRM with valid credentials
    Given user navigates to HRM Orange page
    When user enters "Admin" username and "admin123" password and clicks on login button
    And user should be able to verify dashboard name header "Dashboard" on HRM Homepage

  @negative
  Scenario Outline: User should not be able to login to HRM Orange with invalid credentials
    When user enters "<username>" username and "<password>" password and clicks on login button
    And user validates "<errorMessage>" error message
    Examples:
      | username | password | errorMessage        |
      | xyz      | abc      | Invalid credentials |
      | xyz      |          | Required            |
      |          | abc      | Required            |
      |          |          | Required            |
