package com.myrbshoetests.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RTest extends TestBase{
	
	@Test (priority =1, dataProvider = "dataProvider")
	public void isEmailSubmissionSuccessful(String month, String email, String message) throws InterruptedException, 
	IOException 
	
  {		    
		boolean testResults = homepage.clickMonthLink(month)
								      .isEmailSubmissionSuccessful(email, message);
		
		Assert.assertTrue(testResults, "The email has not been successfully submitted.");		  						 			  						 	  						 	  						 
  }
	
	@Test (priority =2, dataProvider = "dataProvider")
	public void isHomeEmailSubmissionSuccessful(String email, String message) throws InterruptedException, 
	IOException 
	
  {		    
		boolean testResults = homepage.isEmailSubmissionSuccessful(email, message);
		
		Assert.assertTrue(testResults, "The email has not been successfully submitted.");		  						 			  						 	  						 	  						 
  }
	

	
	@Test (priority =3)
	public void testWithRoot() {
		 given().
		  when().
		      get("https://api-staging.mapanything.io/live/lastposition?deviceid=calamp-4642102691").
		then().
		statusCode(200).
			  log().all().
			  root("positions[0]").
		 	  body("deviceMessage.deviceId", is(9082)).
		 	  body("vendor", is("calamp")).
		 	  body("messageType", is("CalAmp-AVL"));
	}
	

}
