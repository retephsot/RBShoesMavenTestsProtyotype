package com.myrbshoetests.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CorrectBrandNameAvailableTest extends TestBase {

	
	@Test (dataProvider = "dataProvider")
	public void areCorrectBrandNameAvailable(String brandName) throws InterruptedException, 
	IOException
	
  {		    
						homepage.selectShoeBrand(brandName)
								.areCorrectShoesAvailableTest(brandName);
								
		
			  						 			  						 	  						 	  						 
  }

}
