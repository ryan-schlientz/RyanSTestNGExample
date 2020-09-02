package com.revature.behaviortests;

import java.io.File;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.revature.pages.WikiMain2;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WikiSearchStepImpl {

	static {
		File file = new File("C:/Users/Revature/Documents/TrainingBatches/2007-july13-wvu/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getPath());
	}

	static WebDriver driver = new ChromeDriver();
	static WikiMain2 wikimain = new WikiMain2(driver);
	
	
	@Given("^The user is on the Wikipedia Home Page$")
	public void the_user_is_on_the_Wikipedia_Home_Page() {
		driver.get("https://www.wikipedia.org/");
	}

	@Given("^The user types in \"([^\"]*)\"$")
	public void the_user_types_in(String character) {
		wikimain.getSearchbar().sendKeys(character);
	}

	@When("^The user presses Enter$")
	public void the_user_presses_Enter() {
		wikimain.getSearchbar().sendKeys(Keys.ENTER);
	}

	@Then("^The title of the article should be \"([^\"]*)\"$")
	public void the_title_of_the_article_should_be(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
}
