package com.myrbshoeresttests.tests;

import org.testng.annotations.Test;

import com.myrbshoeresttests.tests.common.EndPoint;
import com.myrbshoes.restframework.RestAssuredConfig;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static io.restassured.RestAssured.given;

public class Test_REST_BasicFeatures extends RestAssuredConfig{

	//@Test
	public void testStatusCode() {
		given().get("https://jsonplaceholder.typicode.com/posts/1/comments").then().statusCode(200)
		.log().all();
	}
	
	//@Test
	public void testParameterAndHeaders() {
			   given().
		 param("deviceid", "calamp-4642102691").
		
		 header("Authorization","MapAnythingTestKey").
		 		when().
		 	   get("https://api-staging.mapanything.io/live/lastposition").
		 	    then().
	   statusCode(200).
	             log().all();
	}
	
	//@Test
	public void validateGET() {
		given().get("https://api-staging.mapanything.io/live/lastposition?deviceid=calamp-4642102691").then().statusCode(200)
		.log().all();
		
	}
	
	//@Test
	public void validatePost1() {
		given().get(EndPoint.GET_POST1).then().statusCode(200).log().all().body("userId", equalTo(1));
		
	}
	
	//@Test
		public void testParamAndHeaders() {
				   given().
			 		when().
			 	   get("https://api-staging.mapanything.io/live/lastposition?deviceid=calamp-4642102691").
			 	    then().
		   statusCode(200).
		             log().all()		             	  
		             	  .body("positions[0].success", equalTo(true))
		             	  .body("positions[0].deviceId", equalTo("4642102691"));
		}
		
	//@Test
	public void testWithOutRoot() {
		 given().
		  when().
		      get("https://api-staging.mapanything.io/live/lastposition?deviceid=calamp-4642102691").
		then().
		statusCode(200).
			  log().all().
		 	  body("positions[0].deviceMessage.deviceId", is(9082)).
		 	  body("positions[0].vendor", is("calamp")).
		 	  body("positions[0].messageType", is("CalAmp-AVL"));
	}
	
	@Test
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
