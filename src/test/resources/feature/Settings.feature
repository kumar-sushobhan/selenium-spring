Feature: Personal account page

  @Settings
  Scenario: Navigate to Billings and Plan page
    Given I am logged in and on the personalized page
    And I navigate to Settings page from username section
    Then I click on Billings and Plans section
    Then I am on the personal billing page

  Scenario: Navigate to Email page
    Given I am logged in and on the personalized page
    And I navigate to Settings page from username section
    Then I click on Emails section
    Then I am on the Email Settings page
