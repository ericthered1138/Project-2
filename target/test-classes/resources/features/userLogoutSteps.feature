Feature: User logout

  Scenario: As a user I want to be able to logout of the website
    Given the User is already logged in
    When the user clicks on the logout button
    Then the user will return to the login page and have to log back in