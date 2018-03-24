package stepdefinition;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsHomePage;

/**
 * Created by mohammad on 3/15/18.
 */
public class HotelsSD {

    /**
     *   @Hotels-1
    Scenario: Verifying users are able to search for hotels on the website
    When I type in Minnesota in Destination search field
    And I select Minnesota from the suggested list
    And I check in for 6 days starting tomorrow
    And I select option 2 for more option
    And I select option 0 for 1 room
    And I select 2 adults and 2 children
    And I select ages 2 and 4 for the children
    And I click on search for hotels
    Then I verify hotels are displayed
     */
    HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I am on hotels home page$")
    public void iAmOnHoteldotCom() {

        hotelsHomePage.verifyHotelsHomePage();
    }
    @When("^I type in Minnesota in Destination search field$")
    public void enterCityToDestination() throws InterruptedException{

        hotelsHomePage.SendStateInput();
    }

    @And("^I select Minnesota from the suggested list$")
    public void clickDesiredCity() throws InterruptedException {

        hotelsHomePage.selectDestinationFromList();
    }

    @And("^I check in for (\\d+) days starting tomorrow$")
    public void selectCalendarDates(int amount) throws InterruptedException{

        hotelsHomePage.selectDateFromCalendar(amount);
    }
    @And("^I select option (\\d+) for more option$")
    public void selectMoreOption(int index){
        hotelsHomePage.selectIndexOption(index);
    }

    @And("^I select option (\\d+) for 1 room$")
    public void selectNumOfRooms(int index){
        hotelsHomePage.selectNumOfRooms(index);
    }

    @And("^I select  option (\\d+) for 2 adults and option (\\d+) for 2 children$")
    public void selectTravelers(int index, int index2) throws InterruptedException{

        hotelsHomePage.selectPeopleFromDropDown(index,index2);
    }

    @And("^I select ages (\\d+) and (\\d+) for the children$")
    public void selectAgesOfChildren(int index, int index2) throws InterruptedException{

        hotelsHomePage.selectAgeOfChildren(index,index2);
    }

    @And("^I click on search for hotels$")
    public void clickSearch() throws InterruptedException{

        hotelsHomePage.clickSearchButton();
    }
    @Then("^I verify hotels are displayed$")
    public void verifyHotelsDisplayed()throws InterruptedException{
        hotelsHomePage.verifyHotelsDisplayed();
    }

    /**
     *   @Hotels-2
    Scenario: Verify when user selects 9+ rooms and clicks on Search button, they will be taken to groups.hotels.com page

    And I select 9+ rooms from room drop down
    And I click on search for hotels
    Then I verify I am on groups.hotels.com
     */


     @And("^I select option (\\d+) for nine rooms$")
        public void selectNineRooms(int index1){
            hotelsHomePage.selectNumOfRooms(index1);

        }


     @Then("^I verify I am on groups\\.hotels\\.com$")
        public void verifyGroupsHotelPage(){
        hotelsHomePage.verifyHotelsGroup();
     }

}




