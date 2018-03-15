package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyHomePage;

/**
 * Created by mohammad on 3/14/18.
 */
public class DarkSkySDT2 {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @When("^I click on todays bar$")
    public void clickOnTodaysBar(){
        darkSkyHomePage.verifyTempClick();

    }
    @Then("^I verify low and high temp displayed correctly on parent bar$")
    public void verifyTemp(){
        darkSkyHomePage.verifyTemp();
    }
}
