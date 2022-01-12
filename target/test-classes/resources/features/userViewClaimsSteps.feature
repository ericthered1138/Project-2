Feature: User View Claims
  Scenario: As a user, I want to view how much I have recovered so that I can keep track.
    Given the User is already logged in
    When the user clicks on the review claims button
    Then the user can see previous claims
    When the user clicks on the review claims button
    Then the claims will be hidden
