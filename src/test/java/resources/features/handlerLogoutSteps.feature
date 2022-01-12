Feature: Handler Logout

  Scenario: As a handler I want to be able to logout of the website
    Given the handler is already logged in
    When the handler clicks on the logout button
    Then the handler will return to the login page and have to log back in