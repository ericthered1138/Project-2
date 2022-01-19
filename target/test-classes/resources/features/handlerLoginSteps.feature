Feature: Handler Login

  Scenario: As an handler I want to login so I can manage my Insurance
    Given The handler is on login page
    When The handler enters their username in the username input box
    When The handler enters their password in the password input box
    When The handler clicks on the Sign In button
    Then The user should be logged in and redirected to the handler home page