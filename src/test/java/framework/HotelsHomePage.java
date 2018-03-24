package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mohammad on 3/15/18.
 */
public class HotelsHomePage extends BasePage{

    private String hotelTitle = "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals";
    private String stateName = "minnesota";
    private By listOfCity = By.xpath("//div[@class='autosuggest-category-result']");
    private String chooseCity = "Minnesota City, Minnesota, United States of America";
    private By overLayButton = By.xpath("//*[@id=\"managed-overlay\"]/button");
    private By destinationSearchField = By.cssSelector("#qf-0q-destination");
    private By clickonCheckIn = By.id("qf-0q-localised-check-in");
    private By clickOnCheckOut = By.id("qf-0q-localised-check-out");
    private By roomDropDown = By.cssSelector("#qf-0q-compact-occupancy");
    private By actualRoomsSelect = By.id("qf-0q-rooms");
    private By selectNumberOfAdults = By.cssSelector("#qf-0q-room-0-adults");
    private By selectNumberOfChildren = By.cssSelector("#qf-0q-room-0-children");
    private By firstChildsAge = By.id("qf-0q-room-0-child-0-age");
    private By secondChildsAge = By.id("qf-0q-room-0-child-1-age");
    private By clickSearchButton = By.xpath("//*[@id=\"main-content\"]/main/div[2]/div/div[1]/div/div[1]/div[1]/div/div/form/div[5]/button");
    private By hotelsDisplayed = By.id("listings");




    public void verifyHotelsHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),hotelTitle);
    }


    public void SendStateInput() throws InterruptedException {
        //clickOn(overLayButton);
        sendText(destinationSearchField,stateName);
        Thread.sleep(2000);
    }
    public void selectDestinationFromList() throws InterruptedException {
        selectAutoCompleteByText(listOfCity,chooseCity);

    }

    public void selectDateFromCalendar(int amount) throws StaleElementReferenceException, InterruptedException {
        try {
            // creating an object sdf of SimpleDateFormat with the pattern "d" which displays days in the calendar by Day
            SimpleDateFormat sdf = new SimpleDateFormat("d");
            // Creating instance of Calendar
            Calendar cal = Calendar.getInstance();

            //Adding 1 day to the object "cal" to get tomorrows date
            cal.add(Calendar.DATE, 1);
            // Formatting cal object by sdf format "d" and storing it in tomorrowsDate variable
            String tomorrowsDate = sdf.format(cal.getTime());

            clickOn(clickonCheckIn);

            clickOn(By.linkText(tomorrowsDate));

            clickOn(clickOnCheckOut);

            cal.add(Calendar.DATE, amount);
            clickOn(By.linkText(sdf.format(cal.getTime())));
            Thread.sleep(2000);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    public void selectIndexOption(int index){
        selectDropDown(roomDropDown,index);
    }

    public void selectNumOfRooms(int index1){
        selectDropDown(actualRoomsSelect,index1);

    }

    public void selectPeopleFromDropDown(int index, int index2) throws InterruptedException {

        selectDropDown(selectNumberOfAdults,index);
        selectDropDown(selectNumberOfChildren,index2);
        Thread.sleep(2000);

    }

    public void selectAgeOfChildren(int index, int index2) {

        selectDropDown(firstChildsAge, index);

        selectDropDown(secondChildsAge, index2);
    }

    public void clickSearchButton() {

        clickOn(clickSearchButton);
    }

    public void verifyHotelsDisplayed(){
        List<String> listOfHotels = new ArrayList<>();
        List<WebElement> hotelNames = SharedSD.getDriver().findElements(hotelsDisplayed);
        for (int i = 0; i < hotelNames.size(); i++) {
            String namesOfHotels = hotelNames.get(i).getText();
            listOfHotels.add(namesOfHotels);
            System.out.println(namesOfHotels);
            break;
        }

    }

    public void verifyHotelsGroup(){
//       String title = SharedSD.getDriver().getTitle();
//        System.out.println(title);

        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Group Hotel Quote Request");
    }
}


