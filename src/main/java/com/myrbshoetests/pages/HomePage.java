package com.myrbshoetests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.myrbshoetests.helpers.Waits;

public class HomePage extends PageBase{
	
	public HomePage (WebDriver driver)
	{
		super(driver);
	}
	
	Waits wait = new Waits(driver);
	
	public MonthPage clickMonthLink(String month) throws InterruptedException
	{
		wait.waitForElementByLinkText(month);
		
		try {
			driver.findElement(By.linkText(month)).click();
		} catch(Exception e) {
			driver.findElement(By.xpath("//a[contains(text(),'" + month + "')]")).click();
		}
		
		wait.waitForElementByClass("title");
		
		return new MonthPage(driver);
			
	}

}