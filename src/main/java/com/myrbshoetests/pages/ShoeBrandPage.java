package com.myrbshoetests.pages;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ShoeBrandPage extends PageBase {
	
	int totalShoeCount = 0;
	boolean testResults = false;

	public ShoeBrandPage(WebDriver driver) {
		
		super(driver);
	}
	
	public void areCorrectShoesAvailableTest(String brandName) {
		
		//totalShoeCount = driver.findElements(By.xpath("//ul[@id='shoe_list']/li")).size();
		totalShoeCount = getShoeListCount();
				
		WebElement shoeList = driver.findElement(By.id("shoe_list"));
		if(totalShoeCount == 0) {
			
			Assert.assertTrue(false, "There are no shoes available");
			
		}
		
		else {
						
			for (int i = 1; i < totalShoeCount + 1; i++ ) {
				
				String shoeListTable = "//ul[@id='shoe_list']/li[" + i + "]/div/table";
				
				WebElement element = driver.findElement(By.xpath(shoeListTable));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					
				} 
				
				String compare = driver.findElement(By.xpath(shoeListTable + "/tbody/tr/td[2]/a")).getText();
				System.out.println("The shoe brand name is " + compare);
				Assert.assertTrue(compare.contains(brandName), "The displayed brand name is incorrect. -> fail");
				System.out.println("Assertion has passed.");
				
			}			
		}
		
	}
	
	public void isShoePictureAvailable () throws InterruptedException 
	{	
		
		totalShoeCount = getShoeListCount();
		
		if (totalShoeCount == 0) {
			fail("There are no shoes available");			
		}
		else {
		System.out.println("The shoe count is " + totalShoeCount);
		for (int i = 1; i < totalShoeCount + 1; i++ ) {
					
			String shoeListTable = "//ul[@id='shoe_list']/li[" + i + "]/div/table";
			
			WebElement element = driver.findElement(By.xpath(shoeListTable));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
			
			testResults = driver.findElement(By.xpath(shoeListTable + "/tbody/tr[6]/td/img")).isDisplayed();
			System.out.println("The test result is " + testResults);
							
			Assert.assertTrue(testResults, "The shoe picture is not available. -> fail");
				
			
		}			
				
		}
	}		

}
