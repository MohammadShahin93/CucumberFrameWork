package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyHomePage;

/**
 * Created by mohammad on 3/14/18.
 */
public class DarkSkySDT3 {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @When("^I click on Time Machine$")
    public void clickonTimeMachine(){
        darkSkyHomePage.clickTimeMachine();


    }

    @And("^I select tomorrows date$")
    public void selectTomorrowsDate() throws InterruptedException {
        darkSkyHomePage.selectCurrentDate();

    }


    @Then("^I verify selected date is not clickable$")
    public void verifyNotClickableDate(){
        darkSkyHomePage.verifyDateNotClickable();

    }

    @And("^I verify date is displayed in correct format$")
    public void dateCorrectFormat(){
        darkSkyHomePage.verifyCorrectFormat();

    }

}
