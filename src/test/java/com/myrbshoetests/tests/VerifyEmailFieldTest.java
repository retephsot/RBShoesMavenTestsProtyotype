package com.myrbshoetests.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyEmailFieldTest extends TestBase{
	
	@Test (dataProvider = "dataProvider")
	public void verifySubmitEmailField(String month) throws InterruptedException, 
	IOException 
	
  {		    

		boolean testResults = homepage.clickMonthLink(month)
			      					  .isEmailSubmitFieldAvailable();
		
		Assert.assertTrue(testResults, "The reminder email field is not available.");	
		  						 			  						 	  						 	  						 
  }

}
