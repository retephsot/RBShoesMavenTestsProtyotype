package com.myrbshoetests.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RTest2 extends TestBase{

	@Test (priority =1, dataProvider = "dataProvider")
	public void isEmailSubmissionSuccessful(String month, String email, String message) throws InterruptedException, 
	IOException 
	
  {		    
		boolean testResults = homepage.clickMonthLink(month)
								      .isEmailSubmissionSuccessful(email, message);
		
		Assert.assertTrue(testResults, "The email has not been successfully submitted.");		  						 			  						 	  						 	  						 
  }
	
	@Test (priority = 2, dataProvider = "dataProvider")
	public void isHomeEmailSubmissionSuccessful(String email, String message) throws InterruptedException, 
	IOException 
	
  {		    
		boolean testResults = homepage.isEmailSubmissionSuccessful(email, message);
		
		Assert.assertTrue(testResults, "The email has not been successfully submitted.");		  						 			  						 	  						 	  						 
  }
	
	@Test (priority = 3, dataProvider = "dataProvider")
	public void verifySubmitEmailField(String month) throws InterruptedException, 
	IOException 
	
  {		    

		boolean testResults = homepage.clickMonthLink(month)
			      					  .isEmailSubmitFieldAvailable();
		
		Assert.assertTrue(testResults, "The reminder email field is not available.");	
		  						 			  						 	  						 	  						 
  }
	
	@Test (priority = 4 )
	public void verifyHomeSubmitEmailField() throws InterruptedException, 
	IOException 
	
  {		    

		boolean testResults = homepage.isEmailSubmitFieldAvailable();
		
		Assert.assertTrue(testResults, "The reminder email field is not available.");	
		  						 			  						 	  						 	  						 
  }
	
	@Test (priority = 5, dataProvider = "dataProvider")
	public void isShoeBlurbAvailable(String month) throws InterruptedException, 
	IOException
	
  {		    
		boolean testResults = homepage.clickMonthLink(month)
								      .isShoeBlurbAvailable();
		
		Assert.assertTrue(testResults, "The shoe information blurb is not available.");		  						 			  						 	  						 	  						 
  }
	
	@Test (priority = 6, dataProvider = "dataProvider")
	public void isShoePriceAvailable(String month) throws InterruptedException, 
	IOException
	
  {		    
		boolean testResults = homepage.clickMonthLink(month)
								      .isShoePriceAvailable();
		
		Assert.assertTrue(testResults, "The shoe price is not available.");		  						 			  						 	  						 	  						 
  }
	
	@Test (priority = 7, dataProvider = "dataProvider")
	public void isShoePictureAvailable(String month) throws InterruptedException, 
	IOException
	
  {		    
		boolean testResults = homepage.clickMonthLink(month)
								      .isShoePictureAvailable();
		
		Assert.assertTrue(testResults, "The shoe picture is not available.");		  						 			  						 	  						 	  						 
  }
	
}
