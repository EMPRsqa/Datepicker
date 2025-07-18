Feature: Select a date.
  As a user i need to select a date using a pop-up calendar integrated into a form field.

  Scenario: Select a specific date in a different month than the current one
    Given the user opens the calendar in the form
    When the user selects the date "08/15/2025"
    Then the selected date is displayed correctly in the field

