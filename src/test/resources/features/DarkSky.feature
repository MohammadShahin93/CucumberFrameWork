@regression @Task-All
Feature: Dark Sky feature

    Background:
      Given: Given I am on homepage of Dark Sky

    @Task-1
    Scenario: Verify list of days are in correct order on Dark Sky Website
      Then I verify days of the week is displayed in correct order

    @Task-2
    Scenario: Verify low to high value is displayed correctly on weekly forecast section
      When I click on todays bar
      Then I verify low and high temp displayed correctly on parent bar

      @Task-3
      Scenario: Verify tomorrow date is not clickable
      When I click on Time Machine
      And I select tomorrows date
      Then I verify selected date is not clickable
      And I verify date is displayed in correct format

