package com.myrbshoetests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	public DefinitionPage navigateToDefinitionPage() {
		
		wait.waitForElementClickableByCssSel("a.text-right");
		
		driver.findElement(By.cssSelector("a.text-right")).click();
			
		return new DefinitionPage(driver);
	}
	
	public ShoeBrandPage selectShoeBrand(String brandName) {
		
		WebElement selectBrand = driver.findElement(By.id("brand"));
		Select dropDown = new Select(selectBrand);
		dropDown.selectByVisibleText(brandName);
		
		wait.waitForElementClickableByID("search_button");
		driver.findElement(By.id("search_button")).click();
		
		return new ShoeBrandPage(driver);
	}

}