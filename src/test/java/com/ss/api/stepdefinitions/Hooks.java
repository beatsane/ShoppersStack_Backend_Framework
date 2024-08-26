package com.ss.api.stepdefinitions;

import org.junit.After;
import org.junit.Before;
import com.ss.api.util.generic.DatabaseUtility;
import com.ss.api.util.generic.FileUtility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Hooks {
	
	public DatabaseUtility databaseUtility = new DatabaseUtility();
	public FileUtility FileUtility = new FileUtility();
	public static RequestSpecification requestSpecification;
	public static ResponseSpecification responseSpecification;
	
	@Before
	public void beforeSuiteConfig() throws Throwable {
		System.out.println("Beginning Suite Execution...");
		DatabaseUtility.connectToDatabase();
		System.out.println("============DB CONNECTION SUCCESS!==========");
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setContentType(ContentType.JSON);
		requestSpecBuilder.setBaseUri(FileUtility.getDataFromPropertiesFile("base_uri"));
		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		responseSpecBuilder.expectContentType(ContentType.JSON);
		responseSpecification = responseSpecBuilder.build();
	}
	
	@After
	public void afterSuiteConfig() throws Throwable {
		DatabaseUtility.closeDatabaseConnection();
		System.out.println("============DB DISCONNECTED==========");
	}

}
