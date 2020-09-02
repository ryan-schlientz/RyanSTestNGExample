package com.revature.behaviortests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.revature.pages.WikiMain2;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WikiLangStepImpl {

	static {
		File file = new File("C:/Users/Revature/Documents/TrainingBatches/2007-july13-wvu/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getPath());
	}

	static WebDriver driver = new ChromeDriver();
	static WikiMain2 wikimain = new WikiMain2(driver);

	@Given("^I am on the Wikipedia Home Page$")
	public void i_am_on_the_Wikipedia_Home_Page() {
		driver.get("https://www.wikipedia.org/");
	}

	@When("^I click on English$")
	public void i_click_on_English() {
		wikimain.getEnglish().click();
	}

	@Then("^I should be on the English Wiki$")
	public void i_should_be_on_the_English_Wiki() {
		Assert.assertEquals(driver.getTitle(), "Wikipedia, the free encyclopedia");
	}

	@When("^I click on French$")
	public void i_click_on_French() {
		wikimain.getFrench().click();
	}

	@Then("^I should be on the French Wiki$")
	public void i_should_be_on_the_French_Wiki() {
		Assert.assertEquals(driver.getTitle(), "Wikipédia, l'encyclopédie libre");
	}

	//After each Scenario
	@After
	public void stall() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
