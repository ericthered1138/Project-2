Feature: User Create Account
  Scenario: As a user I want to create an account so that I can login and submit claims.
    Given The user is on login page
    When the user clicks the create account link
    When the user enters their first name into the first name box
    When the user enters their last name into the last name box
    When the user enters a username into the create username box
    When the user enters a password into the create password box
    When the user enters the password into the confirm password box
    When the user clicks the create account button
    Then there is a prompt saying the user account has been successfully created.
