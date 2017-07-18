package com.myrbshoetests.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoeBlurbAvailableTest extends TestBase{
	
		@Test (dataProvider = "dataProvider")
		public void isShoeBlurbAvailable(String month) throws InterruptedException, 
		IOException
		
	  {		    
			boolean testResults = homepage.clickMonthLink(month)
									      .isShoeBlurbAvailable();
			
			Assert.assertTrue(testResults, "The shoe information blurb is not available.");		  						 			  						 	  						 	  						 
	  }
		
		
}
