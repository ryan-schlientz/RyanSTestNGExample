package com.revature.charactertesting;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.revature.pages.WikiMain;

public class CharacterSearchFirefoxTest {
	public static WebDriver driver;
	public static WikiMain wikimain;

	@BeforeSuite
	public void setUp() {
		File file = new File("C:/Users/Revature/Documents/TrainingBatches/2007-july13-wvu/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getPath());

		driver = new FirefoxDriver();
		wikimain = new WikiMain(driver);
	}

	@BeforeMethod
	public void before() {
		// WebDriver to navigate to some web page
		driver.get("https://www.wikipedia.org/");
	}

	@Test(dataProvider = "characters")
	public void characterExists(String name, String title) {

		wikimain.search(name);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(driver.getTitle(), title + " - Wikipedia");

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "characters")
	public static Object[][] character() {
		return new Object[][] { { "Mario", "Mario" }, { "Luigi", "Luigi" }, { "Kirby", "Kirby" },
				{ "Ganondorf", "Ganon" } };
	}
}
