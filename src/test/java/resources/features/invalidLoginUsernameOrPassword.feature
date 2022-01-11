Feature: Login Attempt Failure

  Scenario Outline: As the system, I should reject failed login attempts.
    Given The user is on login page
    When The user enters their "<username>" in the username input box
    When The user enters their "<password>" in the password input box
    When The user clicks on the Sign In button
    Then There is an alert telling the user that the login information is incorrect
    Examples:
      | username | password |
      |abc       | david    |
      |david     | abc      |
