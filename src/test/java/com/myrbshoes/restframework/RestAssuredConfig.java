package com.myrbshoes.restframework;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class RestAssuredConfig {
	
	@BeforeSuite(alwaysRun = true)
	public void configuration() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.port = 8080;
		RestAssured.basePath = "";
	}

}
