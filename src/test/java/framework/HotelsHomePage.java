package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mohammad on 3/15/18.
 */
public class HotelsHomePage extends BasePage{

    private By overLayButton = By.xpath("//*[@id=\"managed-overlay\"]/button");
    private By destinationSearchField = By.cssSelector("#qf-0q-destination");

    public void verifyHotelsHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals");
    }


    public void clickOnSearchAndSendInput(){
        //clickOn(overLayButton);
        sendText(destinationSearchField,"minnesota");
    }
    public void selectDestinationFromList(){
        selectAutoCompleteByText(By.className("autosuggest-category-result"),"Minnesota City, Minnesota, United States of America");

    }

    public void selectDateFromCalendar(){
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,1);
        String tomorrowsDate = sdf.format(cal.getTime());
        clickOn(By.cssSelector("#qf-0q-localised-check-in"));

        clickOn(By.linkText(tomorrowsDate));

        clickOn(By.cssSelector("#qf-0q-localised-check-out"));

        cal.add(Calendar.DATE, 6);
        clickOn(By.linkText(sdf.format(cal.getTime())));
    }

    public void selectAdultsFromDropDown(){

        selectDropDown(By.cssSelector("#qf-0q-compact-occupancy"),2);
        selectDropDown(By.cssSelector("#qf-0q-room-0-adults"),1);
        selectDropDown(By.cssSelector("#qf-0q-room-0-children"),2);

    }

    public void selectAgeOfChildren() {

        selectDropDown(By.cssSelector("#qf-0q-room-0-child-0-age"), 2);

        selectDropDown(By.cssSelector("#qf-0q-room-0-child-1-age"), 4);
    }

    public void clickSearchButton() {

        clickOn(By.xpath("//*[@id=\"main-content\"]/main/div[2]/div/div[1]/div/div[1]/div[1]/div/div/form/div[5]/button"));
    }



}
