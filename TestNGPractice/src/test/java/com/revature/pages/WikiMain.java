package com.revature.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page Object Model - Selenium
public class WikiMain {
	
	public WebDriver driver;
	
	@FindBy(id = "searchInput")
	WebElement searchbar;
	
	public WikiMain(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void search(String keys) {
		searchbar.sendKeys(keys);
		searchbar.sendKeys(Keys.ENTER);
	}

}
