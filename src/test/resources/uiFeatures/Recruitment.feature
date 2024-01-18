@Recruitment
Feature: This feature file validates Recruitment Page Functionality

  Background:
    Given user navigates to HRM Orange page
    When user enters "Admin" username and "admin123" password and clicks on login button
    And user should be able to verify dashboard name header "Dashboard" on HRM Homepage

  @smoke @wic
  Scenario Outline: User should be able to add a new candidate on Recruitment Page on HRM
    Given user clicks "<an option>" on the Dashboard Menu on HRM page
    Then user click on AddButton on Recruitment Page
    And user fill out the first name "<firstName>", middle name "<middleName>" and last Name "<lastName>"
    Then user should be able to choose Vacancy dropdown "<vacancyOption>"
    And user should be able to add gmail "<email>" and contact number "<contactNumber>"
    Then user should be able to upload resume
    And user should be able to write keywords "<Keywords>", date of application yyyy-mm-dd "<date>" and notes "<notes>"
    Then user checks the consent to keep data and click on save button
    Then user verifies that the name is listed after saved
    Examples:
      |an option   | firstName | middleName | lastName| vacancyOption |email              | contactNumber | Keywords| date     | notes|
      |Recruitment | Dani      |            | Romo    | QA Engineer   | dani@gmail.com    |0123456789     | abcd    |17-01-2024| notes|

  @smoke
  Scenario Outline: User should be able to navigate to recruitment section and verify the details for added candidate
    Given user clicks "<an option>" on the Dashboard Menu on HRM page
    Then user verifies that the details for the added user "<fulName>" or candidate match the data provided
    Examples:
      |an option   | fulName       |
      |Recruitment | Dani Romo     |