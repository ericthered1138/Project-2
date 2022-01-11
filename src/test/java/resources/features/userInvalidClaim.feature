Feature: User Create Negative Claim

  Scenario: As the system I should reject negative values for claim requests.

    Given the User is already logged in
    When the user clicks on the submit new claim button
    When the user selects the employee dropdown menu
    When the user clicks on the employee in the dropdown menu
    When the user inputs a negative amount into the amount input
    When the user inputs a description into the description input
    When the user inputs a location into the location input
    When the user inputs a date from the date input
    When the user clicks on the submit button
    Then the user is given an alert that his claim was invalid
