Feature: Handler Leaderboard

  Scenario: As a Handler I want to view my leaderboard so I can see the information
    Given the handler is already logged in
    When the handler clicks on the leaderboard button they will see the information
    When the handler chooses an agent
    Then the information will be displayed on the handler page