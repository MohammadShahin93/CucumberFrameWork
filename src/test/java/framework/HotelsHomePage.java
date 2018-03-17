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


    public void clickOnSearchAndSendInput() throws InterruptedException {
        //clickOn(overLayButton);
        sendText(destinationSearchField,"minnesota");
        Thread.sleep(2000);
    }
    public void selectDestinationFromList() throws InterruptedException {
        selectAutoCompleteByText(By.xpath("//div[@class='autosuggest-category-result']"),"Minnesota City, Minnesota, United States of America");

    }

    public void selectDateFromCalendar() throws StaleElementReferenceException {
        try {
            // creating an object sdf of SimpleDateFormat with the pattern "d" which displays days in the calendar by Day
            SimpleDateFormat sdf = new SimpleDateFormat("d");
            // Creating instance of Calendar
            Calendar cal = Calendar.getInstance();
            //Date returns todays date
            //Adding 1 day to the object "cal" to get tomorrows date
            cal.add(Calendar.DATE, 1);
            // Formatting cal object by sdf format "d" and storing it in tomorrowsDate variable
            String tomorrowsDate = sdf.format(cal.getTime());

            clickOn(By.id("qf-0q-localised-check-in"));

            clickOn(By.linkText(tomorrowsDate));

            clickOn(By.id("qf-0q-localised-check-out"));

            cal.add(Calendar.DATE, 6);
            clickOn(By.linkText(sdf.format(cal.getTime())));
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    public void selectPeopleFromDropDown(){

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
