Feature: Create Account Failure
  Scenario: As a system, I should reject account creations that do not have matching passwords in the password inputs
    Given The user is on login page
    When the user clicks the create account link
    When the user enters their first name into the first name box
    When the user enters their last name into the last name box
    When the user enters a username into the create username box
    When the user enters a password into the create password box
    When the user enters a mismatching password into the confirm password box
    When the user clicks the create account button
    Then the user is given an alert that the passwords do not match
