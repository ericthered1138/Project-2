Feature: Agent logout

  Scenario: As a agent I want to be able to logout of the website
    Given the Agent is already logged in
    When the agent clicks on the logout button
    Then the agent will return to the login page and have to log back in