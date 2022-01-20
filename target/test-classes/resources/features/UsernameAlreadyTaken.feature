Feature: Username already taken
  Scenario: As the system, I should reject usernames that are already in the database
    Given The user is on login page
    When the user clicks the create account link
    When the user enters their first name into the first name box
    When the user enters their last name into the last name box
    When the user enters a username that already exists into the create username box
    When the user enters a password into the create password box
    When the user enters the password into the confirm password box
    When the user clicks the create account button
    Then the user is given an alert that the username is taken