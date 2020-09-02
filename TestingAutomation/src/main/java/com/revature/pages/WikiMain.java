package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikiMain {
	
	public WebDriver driver;
	
	public WikiMain(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEnglish() {
		return driver.findElement(By.cssSelector("div[lang='en']"));
	}
	
	public WebElement getSpanish() {
		return driver.findElement(By.cssSelector("div[lang='es']"));
	}
	
	public WebElement getGerman() {
		return driver.findElement(By.id("js-link-box-de"));
	}
	
	public WebElement getFrench() {
		return driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[1]/div[6]"));
	}
	
	public WebElement getItalian() {
		return driver.findElement(By.xpath("/html/body/div[1]/div[7]"));
	}

}
