Feature: Select a date.
  As a user i need to select a date using a pop-up calendar integrated into a form field.

  Scenario: Select a specific date in a different month than the current one
    Given the user opens the calendar in the form
    When they navigate to August 2025 and select the 15th day
    Then the selected date is displayed correctly in the field

