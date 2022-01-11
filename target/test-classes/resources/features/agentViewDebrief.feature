Feature: Shield Agent View Debriefs
  Scenario: As a Shield Agent, I want to view my previous debriefings, so that I can make better decisions
    Given the Agent is already logged in
    When the Shield Agent clicks on the view Debrief button to display the Debriefs
    Then the Shield Agent can see previous claims
    When the Shield Agent clicks on the view Debrief button to display the Debriefs
    Then there is a table of previous Debriefings