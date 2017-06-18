package com.myrbshoetests.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyHomeEmailFieldTest extends TestBase{
	
	@Test
	public void verifyHomeSubmitEmailField() throws InterruptedException, 
	IOException 
	
  {		    

		boolean testResults = homepage.isEmailSubmitFieldAvailable();
		
		Assert.assertTrue(testResults, "The reminder email field is not available.");	
		  						 			  						 	  						 	  						 
  }

}
