Feature: User Login

  Scenario: As an user I want to login so I can manage my Insurance
    Given The user is on login page
    When The user enters their username in the username input box
    When The user enters their password in the password input box
    When The user clicks on the Sign In button
    Then The user should be logged in and redirected to the user home page