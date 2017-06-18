package com.myrbshoetests.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoePictureAvailableTest extends TestBase{
	
	@Test (dataProvider = "dataProvider")
	public void isShoePictureAvailable(String month) throws InterruptedException, 
	IOException
	
  {		    
		boolean testResults = homepage.clickMonthLink(month)
								      .isShoePictureAvailable();
		
		Assert.assertTrue(testResults, "The shoe picture is not available.");		  						 			  						 	  						 	  						 
  }
}
