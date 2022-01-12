Feature: Handler Deny

  Scenario: as a handler, I should be to deny claim request by ID and leave comment
    Given the handler is already logged in
    When the handler enter the claim id in the claim id input box to deny
    When the handler enter the handler comment in the handler comment input box to deny
    When the handler clicks the deny button
    Then a claim is denied and sent to the previous claims and handler clicks on previous claims button to see update