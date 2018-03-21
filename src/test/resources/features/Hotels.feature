@regression
  Feature: Hotels.com feature

  Background:
  Given I am on hotels.com

    @Hotels-1
  Scenario: Verifying users are able to search for hotels on the website
  When I type in Minnesota in Destination search field
  And I select Minnesota from the suggested list
  And I check in for 6 days starting tomorrow
  And I select 2 adults and 2 children
  And I select ages 2 and 4 for the children
  And I click on search for hotels
  Then I verify hotels are displayed

