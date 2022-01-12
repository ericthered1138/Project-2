Feature: Handler Approve

  Scenario: as a handler, I should be to approve claim request by ID and leave comment
    Given The handler is in the handler page
    When the handler enter the claim id in the claim id input box
    When the handler enter the handler comment in the handler comment input box
    When the handler clicks the approve button
    Then a claim  is approved and sent to the previous claims and handler clicks on previous claims button to see update