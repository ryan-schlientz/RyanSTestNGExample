package com.revature.app;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.WikiMain;

public class PomPlayground {

	public static void main(String[] args) {

		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		WebDriver driver = new ChromeDriver();
		WikiMain wikimain = new WikiMain(driver);

//		driver.get("http://www.wikipedia.org/");
//		wikimain.getEnglish().click();
//		
//		driver.get("http://www.wikipedia.org/");
//		wikimain.getSpanish().click();

		for (int i = 0; i < 5; i++) {
			driver.get("http://www.wikipedia.org/");
			switch (i) {
			case 0: {
				wikimain.getEnglish().click();
				if(driver.getTitle().equals("Wikipedia, the free encyclopedia")) {
					System.out.println("Success");
				} else {
					System.out.println("Failure");
				}
				break;
			}
			case 1: {
				wikimain.getSpanish().click();
				break;
			}
			case 2: {
				wikimain.getGerman().click();
				break;
			}
			case 3: {
				wikimain.getFrench().click();
				break;
			} 
			case 4: {
				wikimain.getItalian().click();
				break;
			}
			default: {
				break;
			}

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		driver.quit();
	}

}
