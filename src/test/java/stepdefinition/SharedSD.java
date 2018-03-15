package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.ConfigReader;

public class SharedSD {

	private static WebDriver driver = null;

	@Before
	public static void before() {

		ConfigReader configReader = new ConfigReader();
		String browser = configReader.getBrowser();

		switch (browser){
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						configReader.getChromeDriverPath());
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver",
				configReader.getFireFoxDriverPath());
				driver = new FirefoxDriver();
				break;
		}


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(configReader.getUrl());
	}

	@After
	public static void after() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
