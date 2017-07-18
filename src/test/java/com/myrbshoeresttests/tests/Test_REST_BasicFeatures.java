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
	
//	@Test
	public void testParameterAndHeaders() {
			   given().
			   param("per_page", "50").
			   param("date", "2000:2016").
			   param("format", "json").
		
		// header("Authorization","TestKey").
		 		when().
		 	   get("https://api.worldbank.org/countries/IND/indicators/NY.GDP.PCAP.PP.CD").
		 	    then().
	   statusCode(200).
	             log().all();
	}
	
	//@Test
	public void validateGET() {
		given().get("https://api.worldbank.org/countries/IND/indicators/NY.GDP.PCAP.PP.CD?per_page=50&date=2000:2016&format=json").then().statusCode(200)
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
			 	   get("https://api.worldbank.org/countries/IND/indicators/NY.GDP.PCAP.PP.CD?per_page=50&date=2000:2016&format=json").
			 	    then().
		   statusCode(200).
		             log().all()		             	  
		             	  .body("[0].total", equalTo(17))
		             	  .body("[1][0].indicator.id", equalTo("NY.GDP.PCAP.PP.CD"));
		}
		
//	@Test
	public void testWithOutRoot() {
		 given().
		  when().
		      get("https://api.worldbank.org/countries/IND/indicators/NY.GDP.PCAP.PP.CD?per_page=50&date=2000:2016&format=json").
		then().
		statusCode(200).
			  log().all().
		 	  body("[0].total", is(17)).
		 	  body("[1][0].indicator.id", is("NY.GDP.PCAP.PP.CD")).
		 	  body("[1][16].decimal", is("1"));
	}
	
	@Test
	public void testWithRoot() {
		 given().
		 param("per_page", "50").
		 param("date", "2000:2016").
		 param("format", "json").
		  when().
		      get("https://api.worldbank.org/countries/IND/indicators/NY.GDP.PCAP.PP.CD").
		then().
		statusCode(200).
			  log().all().
			  root("[0]").
		 	  body("per_page", is("50")).
		 	  body("total", is(17)).
		 	  detachRoot("[0]").
		 	  body("[1][16].decimal", is("1"));
	}
	
}
