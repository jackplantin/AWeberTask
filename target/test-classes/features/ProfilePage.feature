Feature: Test WordPress Profile Page Functionality

  Scenario: Fill out all required fields, click save, and verify its saved successfully
    Given I enter my correct login details
    When I navigate to the Profile Section of WordPress
    And I clear all fields of Profile Section
    And I enter in details for all fields of Profile Section first name "Jack", last name "Plantin", description "This is a test"
#    And Click save details button
#    Then I should verify success message is displayed


