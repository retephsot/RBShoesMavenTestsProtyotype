package com.myrbshoetests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MonthPage extends PageBase{
	
	int shoecount;
	
	public MonthPage (WebDriver driver)
	{
		super(driver);
	}
	
	public boolean isEmailSubmitFieldAvailable () 
	{	
		boolean testresults = driver.findElement(By.id("remind_email_input")).isDisplayed();
				
		System.out.println("The test result is " + testresults);		
		
		return testresults;
			
	}
	
	public boolean isEmailSubmissionSuccessful (String email, String message) throws InterruptedException 
	{	
		driver.findElement(By.id("remind_email_input")).sendKeys(email);
		Thread.sleep(500);
		driver.findElement(By.id("remind_email_submit")).click();
		waitForElementByCssSel(".flash.flash_success");
		
		boolean testresults = driver.findElement(By.cssSelector(".flash.flash_success")).getText().contains(message + " " + email);
				
		System.out.println("The test result is " + testresults);		
		
		return testresults;		
	}
	
	public int getShoeListCount()
	{
		return driver.findElements(By.xpath("//ul[@id='shoe_list']/li")).size();	
	}
	
	public boolean isShoeBlurbAvailable () throws InterruptedException 
	{	
		boolean testresults = false;
		shoecount = getShoeListCount();
		
		if (shoecount == 0) {
			System.out.println("There are not shoes available, the test has failed.");
			
			return testresults;
		}
		else {
		System.out.println("The shoe count is " + shoecount);
		for (int i = 1; i < shoecount + 1; i++ ) {
					
			String shoeListTable = "//ul[@id='shoe_list']/li[" + i + "]/div/table";
			
			WebElement element = driver.findElement(By.xpath(shoeListTable));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
			
			testresults = driver.findElement(By.xpath(shoeListTable + "/tbody/tr[4]")).isDisplayed();			
			System.out.println("The test result is " + testresults);
			
			if (testresults) {
				
				testresults = true;				
			}
		}			
		
		return testresults;
		}
	}
	
	public boolean isShoePriceAvailable () throws InterruptedException 
	{	
		boolean testresults = false;
		shoecount = getShoeListCount();
		
		if (shoecount == 0) {
			System.out.println("There are not shoes available, the test has failed.");
			
			return testresults;
		}
		else {
		System.out.println("The shoe count is " + shoecount);
		for (int i = 1; i < shoecount + 1; i++ ) {
					
			String shoeListTable = "//ul[@id='shoe_list']/li[" + i + "]/div/table";
			
			WebElement element = driver.findElement(By.xpath(shoeListTable));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
			
			testresults = driver.findElement(By.xpath(shoeListTable + "/tbody/tr[3]")).isDisplayed();
			System.out.println(driver.findElement(By.xpath(shoeListTable + "/tbody/tr[3]")).getText());
			System.out.println("The test result is " + testresults);
			
			if (testresults) {
				
				testresults = true;				
			}
		}			
		
		return testresults;
		}
	}
	
	public boolean isShoePictureAvailable () throws InterruptedException 
	{	
		boolean testresults = false;
		shoecount = getShoeListCount();
		
		if (shoecount == 0) {
			System.out.println("There are not shoes available, the test has failed.");
			
			return testresults;
		}
		else {
		System.out.println("The shoe count is " + shoecount);
		for (int i = 1; i < shoecount + 1; i++ ) {
					
			String shoeListTable = "//ul[@id='shoe_list']/li[" + i + "]/div/table";
			
			WebElement element = driver.findElement(By.xpath(shoeListTable));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
			
			testresults = driver.findElement(By.xpath(shoeListTable + "/tbody/tr[6]/td/img")).isDisplayed();
			System.out.println(driver.findElement(By.xpath(shoeListTable + "/tbody/tr[6]/td/img")).getText());
			System.out.println("The test result is " + testresults);
			
			if (testresults) {
				
				testresults = true;
				
			}
		}			
		
		return testresults;			
		}
	}		
}

