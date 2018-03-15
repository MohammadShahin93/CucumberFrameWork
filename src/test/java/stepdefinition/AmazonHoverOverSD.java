package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AmazonHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;


/**
 * Created by mohammad on 2/10/18.
 */
public class AmazonHoverOverSD {

    private AmazonHomePage amazonHomePage = new AmazonHomePage();


    @Given("^I am on home page of Amazon$")
    public void imOnHomepage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }

    @When("^I Hover over to Accounts & List$")
    public void hoverOver() throws InterruptedException {
        amazonHomePage.hoverOverToAccountList();

    }

    @And("^I click on (Account & Lists|Sign in|Next Sign in|continue) button$")
    public void clickOnSignInButton(String button) {
        switch (button) {
            case "Sign in":
                amazonHomePage.clickOnSignInButton();
                break;
            case "continue":
                //Implement Create account object
                amazonHomePage.clickOnContinueButton();
                break;
            case "Default Sign in":
                //Implement Create account object
                amazonHomePage.clickOnOriginalSignInButton();
                break;
            case "Account & Lists":
                //Implement Create account object
                amazonHomePage.clickOnAccountsList();
                break;
        }
    }

    @And("^I enter invalid (.+) into (email) address")
    public void inputDataToTextFields(String anyText, String textFields) {

        switch (textFields) {
            case "email":
                amazonHomePage.enterEmail(anyText);
                break;
        }
    }


    @Then("^I verify for (error) message$")
    public void verifyErrorMessage(String error) throws InterruptedException {
        String actualMessage = SharedSD.getDriver().findElement(By.xpath(".//div[@class=\"a-alert-content\"]/descendant::span[@class='a-list-item']")).getText();
        Assert.assertEquals(actualMessage, "We cannot find an account with that email address");
    }

    @Then("^I verify password field appears$")
    public void verifyPasswordFieldAppears(){
        String actualField = SharedSD.getDriver().findElement(By.xpath("//label[@for='ap_password']")).getText();
        Assert.assertEquals(actualField,"Password");
    }

}
