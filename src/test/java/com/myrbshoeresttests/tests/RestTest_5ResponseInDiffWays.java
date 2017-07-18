package com.myrbshoeresttests.tests;

import org.testng.annotations.Test;
import com.myrbshoeresttests.tests.common.EndPoint;
import com.myrbshoes.restframework.RestAssuredConfig;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static io.restassured.RestAssured.given;

public class RestTest_5ResponseInDiffWays {
	
	/*
	 * to get all response as String
	 */
//	@Test
	public void testGetResponseAsString() {
		String responseAsString = get("https://api.worldbank.org/countries/IND/indicators/NY.GDP.PCAP.PP.CD?per_page=50&date=2000:2016&format=json").asString();
		System.out.println("My Response:\n\n"+responseAsString);
	}
	
	/*
	 * to get response as InputStream
	 */
	//@Test
	public void testGetResponseAsInputStream() throws IOException {
		InputStream stream = given().
				 param("per_page", "50").
				 param("date", "2000:2016").
				 param("format", "json").
//	no header    header("Authorization","TestKey").
				 when().get("https://api.worldbank.org/countries/IND/indicators/NY.GDP.PCAP.PP.CD").
				 				 
				 asInputStream();
		
		System.out.println("Stream Length:" + stream.toString().length());	
			stream.close();
		
	}
	
	@Test
	public void postJSONBody() {
		File file = new File("/Users/Rastamon/workspace/ui-automation-tests/src/main/resources/Post.json");
	    String content = null;

	    given().header("Authorization","MapAnythingTestKey").body(file).with().contentType("application/json").then().expect().
	            statusCode(200).
	            body("success", equalTo(true)).
	            body("data[0].City", equalTo("ATLANTA")).
	            when().post("http://api-staging.mapanything.io/data/c2c/1/");
	}

}
