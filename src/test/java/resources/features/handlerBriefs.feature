Feature: Handler Briefs

  Scenario: as a handler, I should be to search for briefs
    Given the handler is already logged in
    When the user selects the employee dropdown menu on handler page
    When the user clicks on the employee in the dropdown menu on handler page
    Then the handler clicks the view briefs button to see the briefs for that employee

