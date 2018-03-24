@regression @Hotels-All
  Feature: Hotels feature

  Background:
  Given I am on hotels home page

    @Hotels-1
  Scenario: Verifying users are able to search for hotels on the website
  When I type in Minnesota in Destination search field
  And I select Minnesota from the suggested list
  And I check in for 6 days starting tomorrow
  And I select option 2 for more option
  And I select option 1 for 1 room
  And I select  option 1 for 2 adults and option 2 for 2 children
  And I select ages 2 and 4 for the children
  And I click on search for hotels
  Then I verify hotels are displayed

    @Hotels-2
  Scenario: Verify when user selects 9 rooms and clicks on Search button they will be taken to groupshotelscom page

      When I type in Minnesota in Destination search field
      And I select Minnesota from the suggested list
      And I check in for 6 days starting tomorrow
      And I select option 2 for more option
      And I select option 8 for nine rooms
      And I click on search for hotels
      Then I verify I am on groups.hotels.com




