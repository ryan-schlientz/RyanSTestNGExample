package com.revature.charactertesting;

import java.io.File;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.revature.pages.WikiMain2;

public class CharacterSearchTest {
	
	public static WebDriver driver;
	public static WikiMain2 wikimain;
	
	@BeforeSuite
	public void setUp() {
		File file = new File("C:/Users/Revature/Documents/TrainingBatches/2007-july13-wvu/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getPath());
		
		driver = new ChromeDriver();
		wikimain = new WikiMain2(driver);
	}
	
	@BeforeMethod
	public void before() {
		driver.get("https://www.wikipedia.org/");
	}
	
	@Test(dataProvider="characters")
	public void characterExists(String name, String title) {
		
		wikimain.getSearchbar().sendKeys(name + Keys.ENTER);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), title + " - Wikipedia");
	}
	
//	@AfterMethod
//	public void stall() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="characters")
	public static Object[][] character() {
		return new Object [][] {{"Luigi", "Luigi"},{"Wario", "Wario"},{"Waluigi", "Waluigi"},{"Ganondorf", "Ganon"}};
	}
	
}
