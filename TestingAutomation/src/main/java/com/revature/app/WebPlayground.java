package com.revature.app;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPlayground {

	public static void main(String[] args) {
		
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com/");
		
		WebElement searchbar = driver.findElement(By.name("q"));
		
		searchbar.sendKeys("Super Smash Characters");
//		searchbar.sendKeys(Keys.ENTER);
		
		//Might need to add a Thread.sleep here
		
		WebElement googlesearch = driver.findElement(By.name("btnK"));
		googlesearch.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.get("http://www.wikipedia.org/");
		
//		WebElement wikiEnglish = driver.findElement(By.cssSelector("div[lang='en']"));
//		wikiEnglish.click();
		
		WebElement wikiSpanish = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[1]/div[2]"));
		wikiSpanish.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * Waits:
		 * 
		 * Bad Way: (Use if only necessary) just use: 
		 * Thread.sleep(time);
		 * 
		 * 
		 * 
		 * Better Way: Implicit Waits
		 * Will tell Selenium to wait (up to) a standard amount of time
		 * to find an element if it cannot find it immediately
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * 
		 * 
		 * 
		 * Even Better Way: Explicit Waits
		 * Will tell Selenium to wait for a certain element to become visible
		 * before interacting with it.
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver,30);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementID")));
		 * 
		 * 
		 * Best Way: Fluent Waits
		 * Will check for the element in specified intervals
		 * until a determined timeout before throwing the
		 * exception.
		 * 
		 * Wait wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(50, TimeUnit.SECONDS)
		 * .pollingEvery(3, TimeUnit.SECONDS)
		 * .ignoring(NoSuchElementException.class);
		 * 
		 */
		
		
		
		
		
		
		//closes all browsers and stops the ChromeDriver
		driver.quit();
		
		//driver.close(); //closes the current browser
	}

}
