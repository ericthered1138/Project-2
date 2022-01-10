Feature: Agent Login

  Scenario: As an agent I want to login so I can manage my Insurance
    Given The agent is on login page
    When The agent enters their username in the username input box
    When The agent enters their password in the password input box
    When The agent clicks on the Sign In button
    Then The agent should be logged in and redirected to the agent home page