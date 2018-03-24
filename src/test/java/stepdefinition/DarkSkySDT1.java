package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyHomePage;
import org.testng.Assert;

/**
 * Created by mohammad on 3/13/18.
 */
public class DarkSkySDT1 {
    /**
     * @Task-1
    Scenario: Verify list of days are in correct order on Dark Sky Website
    Then I verify days of the week is displayed in correct order

     */

    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on homepage of Dark Sky$")
    public void iAmOnHomePageOfDarkSky() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - 260 Broadway, New York City, NY");
    }

    @Then("I verify days of the week is displayed in correct order$")
    public void getDaysInDarkSky() {
        darkSkyHomePage.getDaysFromDarkSky();
        darkSkyHomePage.getDaysOfWeek();
    }



    public class DarkSkySDT2 {

        DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

        @When("^I click on todays bar$")
        public void clickOnTodaysBar() {
            darkSkyHomePage.verifyTempClick();

        }

        @Then("^I verify low and high temp displayed correctly on parent bar$")
        public void verifyTemp() {
            darkSkyHomePage.verifyTemp();
        }
    }

    public class DarkSkySDT3 {

        DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

        @When("^I click on Time Machine$")
        public void clickonTimeMachine() {
            darkSkyHomePage.clickTimeMachine();


        }

        @And("^I select tomorrows date$")
        public void selectTomorrowsDate() throws InterruptedException {
            darkSkyHomePage.selectCurrentDate();

        }


        @Then("^I verify selected date is not clickable$")
        public void verifyNotClickableDate() {
            darkSkyHomePage.verifyDateNotClickable();

        }

        @And("^I verify date is displayed in correct format$")
        public void dateCorrectFormat() {
            darkSkyHomePage.verifyCorrectFormat();

        }
    }
}