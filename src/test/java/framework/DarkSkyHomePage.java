package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by mohammad on 3/14/18.
 */
public class DarkSkyHomePage extends BasePage {

    private By days = By.className("name");
    private By TodaysLocator = By.xpath("//*[@id=\"week\"]/a[1]/span[1]/span[2]");
    private By actualDate = By.className("date");
    private By dateVisible = By.cssSelector("#main > div.dayDetails.center > div.title > div");
    private SimpleDateFormat sdf = new SimpleDateFormat("d");
    private By timeMachine = By.cssSelector("#timeMachine > div.buttonContainer > a");
    private By eachDay = By.tagName("td");
    private By calendarWidget = By.className("calendar");

    List<String> actualDays = new ArrayList<>();//creates list of actual days

    List<String> expectedDays = new ArrayList<>();//Creates a list of expected days
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");

    public void getDaysFromDarkSky() {

        List<WebElement> listOfDays = SharedSD.getDriver().findElements(days);
        for (int i = 0; i < listOfDays.size(); i++) {
            String elementText = listOfDays.get(i).getText();
            actualDays.add(elementText);
        }
    }

    public void getDaysOfWeek() {

        //Instance of Calendar (Creates Calendar)
        Calendar cal = Calendar.getInstance();

        //adds Today to index 0
        expectedDays.add(0, "Today");


        cal.setTime(new Date());

        // count starts with 0
        int counter = 0;
        do {
            cal.add(Calendar.DAY_OF_WEEK, 1);
            expectedDays.add(simpleDateFormat.format(cal.getTime()));
            counter++;
        }
        while (counter < 7);

        System.out.println(expectedDays);
        System.out.println(actualDays);

        Assert.assertEquals(actualDays, expectedDays);


    }

    public void verifyTempClick() {
        clickOn(By.xpath("//*[@id=\"week\"]/a[1]/span[1]/span[2]"));

    }

    public void verifyTemp() {
        String lowTemp1 = SharedSD.getDriver().findElement(By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[1]")).getText();
        String lowTemp2 = SharedSD.getDriver().findElement(By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]")).getText();
        String highTemp1 = SharedSD.getDriver().findElement(By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[3]")).getText();
        String highTemp2 = SharedSD.getDriver().findElement(By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]")).getText();


        Assert.assertEquals(lowTemp1, lowTemp2);

        Assert.assertEquals(highTemp1, highTemp2);

        System.out.println(lowTemp1 + lowTemp2);

        System.out.println(highTemp1 + highTemp2);


    }

    public void clickTimeMachine() {
        clickOn(timeMachine);
    }

    //Selects current date from list
    public void selectCurrentDate() throws InterruptedException {

        Calendar calendar = Calendar.getInstance();

        // add one day to the date/calendar
        calendar.add(Calendar.DATE, 1);

        String tomorrowsDate = sdf.format(calendar.getTime());
        clickOn(timeMachine);

        WebElement dateFromCalendar = SharedSD.getDriver().findElement(calendarWidget);
        List<WebElement> dayElement = dateFromCalendar.findElements(eachDay);

        for (WebElement day : dayElement) {
            String expectedDay = day.getText();
            if (expectedDay.equals(tomorrowsDate)) {
                day.click();
                Thread.sleep(3000);
                break;

            }
        }
    }

    public void verifyDateNotClickable() {
        WebElement isItClickable = SharedSD.getDriver().findElement(dateVisible);

        Assert.assertFalse(isItClickable.isSelected());
    }

    public void verifyCorrectFormat() {
        //Instance of a Calendar
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DATE, 1);

        Assert.assertEquals(SharedSD.getDriver().findElement(actualDate).getText(), SharedSD.getDriver().findElement(dateVisible).getText());
    }

    }

