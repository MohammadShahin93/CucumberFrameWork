package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class BasePage {

	//Mouse over an element
	public static void mouseOverElement(By overLocator) throws InterruptedException {
		WebElement element = SharedSD.getDriver().findElement(overLocator);
		//Create action instance
		Actions action = new Actions(SharedSD.getDriver());
		action.moveToElement(element).build().perform();
		Thread.sleep(3000);

	}

	public void selectAutoCompleteByText(By locator, String string) {
		try {
			List<WebElement> list = SharedSD.getDriver().findElements(locator);

			for (WebElement elements : list) {

				if (elements.getText().equals(string)) {
					elements.click();
					break;
				}
			}
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void selectDropDown(By locator, int index) {
		try {
			Select dropdown = new Select(SharedSD.getDriver().findElement(locator));
			dropdown.selectByIndex(index);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}



	//Clicks on a locator
	public void clickOn(By locator) {
		webDriverFluentWait(locator).click();
	}

	//Gets text from element
	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	//Gets element and inputs value
	public void inputValue(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screen shot should be taken");
		}

	}

	//Sends texts to the textfield element
	public void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}




	//Scroll on the page
	public static void scrollOnThePage() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		//Vertical scroll down 150 pixels
		js.executeScript("window.scrollBy(0,150)");
		Thread.sleep(10000);
	}


	//Waits and clicks on radio button
	public void checkRadioButton(By locator) {
		webDriverFluentWait(locator).click();

	}

	//Gets text from an element
	public String getText(By locator) {
		return SharedSD.getDriver().findElement(locator).getText();
	}

	//Checks if radio button is selected
	public boolean isRadioButtonSelected(By locator) {
		boolean isSelectedResult = false;
		try {
			isSelectedResult = SharedSD.getDriver().findElement(locator).isSelected();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screen shot should be taken");

		}
		return isSelectedResult; /// it should be final ?

	}

	//Checks if radio button is displayed
	public boolean isRadioButtonDisplayed(By locator) {
		boolean isDisplayedResult = false;
		try {
			isDisplayedResult = SharedSD.getDriver().findElement(locator).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screen shot should be taken");

		}
		return isDisplayedResult;
	}

	//Checks if radio button is enabled
	public boolean isRadioButtonEnabled(By locator) {
		boolean isEnabledResult = false;
		try {
			isEnabledResult = SharedSD.getDriver().findElement(locator).isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screen shot should be taken");

		}
		return isEnabledResult;
	}

	//Selects value from drop down list
	public void selectDropdownListValue(Select dropDownValue, String value) {
		try {
			dropDownValue.selectByVisibleText(value);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screen shot should be taken");

		}
	}



	//Selects current date from list
	public void selectCurrentDate(List<WebElement> element) throws InterruptedException {
		//Formats the date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
		//Instance of date
		Date date = new Date();
		//Formats date to String
		String currentDate = simpleDateFormat.format(date);
		//Enhanced loop goes through list of web elements and selects current date
		for (WebElement day : element) {
			String expectedDay = day.getText();
			if (expectedDay.equals(currentDate)) {
				day.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	//Switches to windows
	public void switchToWindow(int index) {
		List<String> listOfWindows = new ArrayList<>(SharedSD.getDriver().getWindowHandles());
		SharedSD.getDriver().switchTo().window(listOfWindows.get(index));
	}

	//Switches to root window
	public void switchToRootWindow() {
		List<String> listOfWindows = new ArrayList<>(SharedSD.getDriver().getWindowHandles());

		for (int i = 1; i < listOfWindows.size(); i++) {
			SharedSD.getDriver().switchTo().window(listOfWindows.get(i));
			SharedSD.getDriver().close();
		}
		SharedSD.getDriver().switchTo().window(listOfWindows.get(0));

	}

	//Accepts the alert
	public void acceptAlert() {
		try {
			SharedSD.getDriver().switchTo().alert().accept();
			Thread.sleep(3000);
			System.out.println("Alert accepted.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("There are no alerts");

		}
	}

	//Dismisses the alert
	public void dismissAlert() {
		try {
			SharedSD.getDriver().switchTo().alert().dismiss();
			Thread.sleep(3000);
			System.out.println("Alert dismissed.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("There are no alerts");

		}
	}

	//Gets text from the alert
	public void getTextAlert() {
		try {
			String alertMessage = SharedSD.getDriver().switchTo().alert().getText();
			Thread.sleep(3000);
			System.out.println("Alert message: " + alertMessage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("There are no alerts");

		}
	}

	//Enters text to the alert
	public void sendKeysToAlert(By locator, String text) {
		try {
			SharedSD.getDriver().switchTo().alert().sendKeys(text);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("There are no alert");
	}

	//Switches to Frame by index
	public void switchToFrame(int index) {
		try {
			SharedSD.getDriver().switchTo().frame(index);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screen shot should be taken");

		}
	}

	//Switches to Frame by name
	public void switchToFrame(String name) {
		try {
			SharedSD.getDriver().switchTo().frame(name);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screen shot should be taken");

		}
	}

	//Switches to Frame by WebElement
	public void switchToFrame(WebElement webElement) {
		try {
			SharedSD.getDriver().switchTo().frame(webElement);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screen shot should be taken");

		}
	}

	//Auto complete
	public void autoComplete(List<WebElement> list, String text) {

		for (WebElement ele : list) {
			if (ele.getText().contains(text)) {
				ele.click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}


	public void clickOnBrowserBackArrow() {
		SharedSD.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		SharedSD.getDriver().navigate().refresh();
	}

	/**
	 * Import from util Maven testNG
	 */

	//Implicit wait
	public static void implicitWait(String url, By locator) {
		SharedSD.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SharedSD.getDriver().get(url);
		WebElement element = SharedSD.getDriver().findElement(locator);
	}

	//Fluent wait
	public static WebElement webDriverFluentWait(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class)
				.withMessage("Web driver waited,  element could not be found, Exception has been thrown ");

		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}

	//Wait 10 seconds until element is clickable
	public static void waitUntilElementIsClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(SharedSD.getDriver(), 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	//Wait until page is fully loaded
	public static void pageLoadingWait(long timeInSecond) {
		SharedSD.getDriver().manage().timeouts().pageLoadTimeout(timeInSecond, TimeUnit.SECONDS);
	}

	//Script Timeout
	public static void asynchronusScript(long timeInSecond) {
		SharedSD.getDriver().manage().timeouts().setScriptTimeout(timeInSecond, TimeUnit.SECONDS);
	}

	//Click on element using js executor
	public static void clickOnElemetByJs(By locator) throws InterruptedException {
		WebElement element = SharedSD.getDriver().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		js.executeScript("argument[0].click();", element);
		Thread.sleep(5000);
	}


	//Set driver browser window
	public static void setCromeBrowserWindow() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=800,480");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		//Opens browser window with new size;
		WebDriver driver = new ChromeDriver(capabilities);
	}

	//Looks for given element in the list
	public void lookForElement(List<WebElement> list, String text) {
		System.out.println(list.size());
		for (WebElement ele : list) {
			if (ele.getText().contains(text)) {
				System.out.println("Element is presented: " + text);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	//Looks for given element in the list
	public boolean isElementInTheList(List<WebElement> list, String text) {
		boolean isFound = false;
		for (WebElement ele : list) {
			if (ele.getText().contentEquals(text)) {
				isFound = true;
				break;
			} else {
			}
		}
		System.out.println("Element is on the list: " + isFound);
		return isFound;
	}




}

