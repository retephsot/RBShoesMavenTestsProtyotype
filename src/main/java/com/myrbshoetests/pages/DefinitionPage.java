package com.myrbshoetests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.myrbshoetests.helpers.Waits;

public class DefinitionPage extends PageBase {
	
	public DefinitionPage(WebDriver driver) {
		
		super(driver);		
	}
	
	Waits wait = new Waits(driver);
	
	public DefinitionPage scrollDownToPageBottom() {
		
		//scroll down
		WebElement element = driver.findElement(By.cssSelector(".story_3"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new DefinitionPage(driver);
	}
	
	public boolean isAcceptanceCriteriaAvailable(String acceptCriteria) {
		boolean testResult = false;
		
		String compare = driver.findElement(By.xpath("//div[@class='stories']/div[2]/div/ul/li")).getText();
		
		if (compare.contains(acceptCriteria)) {
			
			testResult = true;
		}
		
		return testResult;
		
		
	}

}
