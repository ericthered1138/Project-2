Feature: Employee Login

  Scenario: As an employee I want to login so I can manage my Insurance
    Given The employee is on login page
    When The employee enters their username in the username input box
    When The employee enters their password in the password input box
    When The employee clicks on the Sign In button
    Then The employee should be logged in and redirected to the employee home page