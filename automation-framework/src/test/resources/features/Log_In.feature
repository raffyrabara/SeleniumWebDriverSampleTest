@Login @regression

Feature: WebDriver University Log-in Portal

  Background:
    Given I access the webdriver university login page
@login1
  Scenario: Log-in using correct credentials
    When I enter a username webdriver
    And I enter a password webdriver123
    And I click on the Login button
    Then I should be presented with a validation successful login message
@login2
  Scenario: Log-in using incorrect credentials
    When I enter a username webdriver
    And I enter a password webdriver123!
    And I click on the Login button
    Then I should be presented with a validation failed login message

  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click on the Login button
    Then I should be presented with the following validation login message <loginValidationMessage>

    Examples:
      | username   | password     | loginValidationMessage |
      | webdriver  | webdriver123 | validation succeeded   |
      | webdriver  | webdriver1   | validation failed      |
      | webdriver1 | webdriver123 | validation failed      |