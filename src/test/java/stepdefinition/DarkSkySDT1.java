package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.DarkSkyHomePage;
import org.testng.Assert;

/**
 * Created by mohammad on 3/13/18.
 */
public class DarkSkySDT1 {

    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on homepage of Dark Sky$")
    public void iAmOnHomePageOfDarkSky(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky - 260 Broadway, New York City, NY");
    }

    @Then("I verify days of the week is displayed in correct order$")
    public void getDaysInDarkSky(){
        darkSkyHomePage.getDaysFromDarkSky();
        darkSkyHomePage.getDaysOfWeek();
    }

}
