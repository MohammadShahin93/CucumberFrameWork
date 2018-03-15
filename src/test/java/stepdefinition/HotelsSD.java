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
    HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I am on hotels.com$")
    public void iAmOnHoteldotCom() {

        hotelsHomePage.verifyHotelsHomePage();
    }
    @When("^I type in Minnesota in Destination search field$")
    public void enterCityToDestination() {

        hotelsHomePage.clickOnSearchAndSendInput();
    }

    @And("^I select Minnesota from the suggested list$")
    public void clickDesiredCity() {

        hotelsHomePage.selectDestinationFromList();
    }

    @And("^I check in for 6 days starting tomorrow$")
    public void selectCalendarDates() {

        hotelsHomePage.selectDateFromCalendar();
    }

    @And("^I select 2 adults and 2 children$")
    public void selectTravelers() {

        hotelsHomePage.selectAdultsFromDropDown();
    }

    @And("^I select ages 2 and 4 for the children$")
    public void selectAgesOfChildren() {

        hotelsHomePage.selectAgeOfChildren();
    }

    @Then("^I click on search for hotels$")
    public void clickSearch() {

        hotelsHomePage.clickSearchButton();
    }
}
