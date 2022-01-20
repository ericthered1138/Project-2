Feature: Shield Agent Submitting Debrief

  Scenario: As a agent I want to be able to submit debrief
    Given the Agent is already logged in
    When the agent clicks on the button to start debrief form
    When the agent enters text into the Debrief text box
    When the agent enters the date into the Date box
    When the agent enters a location into the location box
    When the agent clicks on the submit button
    Then the agent will receive an alert that the debrief was submitted