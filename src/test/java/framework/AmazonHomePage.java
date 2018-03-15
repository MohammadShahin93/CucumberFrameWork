package framework;

import org.openqa.selenium.By;

/**
 * Created by mohammad on 2/24/18.
 */
public class AmazonHomePage extends BasePage {

    private By accountsList = By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]");
    private By signInButton = By.xpath("//*[@id=\"nav-flyout-ya-signin\"]");
    private By originalSignInButton = By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span");
    private By emailTextField = By.xpath("//*[@id=\"ap_email\"]");
    private  By continueButton = By.id("continue");

    //Hovers over Accounts & List
    public void hoverOverToAccountList() throws InterruptedException {
        mouseOverElement(accountsList);
    }

    //Clicks on accounts and list link
    public void clickOnAccountsList(){
        clickOn(accountsList);
    }
    //Clicks on First sign in button
    public void clickOnOriginalSignInButton(){
        clickOn(originalSignInButton);
    }
    //Clicks on second sign in button
    public void clickOnSignInButton(){
        clickOn(signInButton);
    }

    //Clicks on continue button
    public  void clickOnContinueButton(){
        clickOn(continueButton);
    }

    public void enterEmail(String enterEmail) {
        inputValue(emailTextField, enterEmail);
    }



}

