package com.myrbshoetests.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AcceptanceCriteria2Test extends TestBase {
	
	@Test (dataProvider = "dataProvider")
	public void isAcceptCriteriaAvailable(String acceptCriteria) throws InterruptedException, 
	IOException 
	
  {		    
		boolean testResults = homepage.navigateToDefinitionPage()
									  .scrollDownToPageBottom()
									  .isAcceptanceCriteriaAvailable(acceptCriteria);
		
		Assert.assertTrue(testResults, "The acceptance criteria is not available.");		  						 			  						 	  						 	  						 
  }

}
