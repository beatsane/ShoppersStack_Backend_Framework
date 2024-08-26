package com.ss.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.junit.After;
import org.junit.Before;
import org.testng.Assert;

import com.ss.api.util.generic.DatabaseUtility;
import com.ss.api.util.generic.FileUtility;

public class CreateShopperSteps {

	public DatabaseUtility databaseUtility = new DatabaseUtility();
	public FileUtility fileUtility = new FileUtility();
	public static RequestSpecification requestSpecification;
	public static ResponseSpecification responseSpecification;

	@Before
	public void beforeSuiteConfig() throws Throwable {
		System.out.println("Beginning Suite Execution...");
		DatabaseUtility.connectToDatabase();
		System.out.println("============DB CONNECTION SUCCESS!==========");

		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setContentType(ContentType.JSON);
		requestSpecBuilder.setBaseUri(fileUtility.getDataFromPropertiesFile("base_uri"));
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

	Response response;

	@Given(value = "I set the request body as {string}")
	public void I_set_the_request_body_as(String createShopperPayload) {
		RestAssured.given().spec(requestSpecification).body(createShopperPayload);
	}

	@When(value = "I send a POST request to the ShoppersStack API with {string} as endpont")
	public void I_send_a_POST_request_to_the_ShoppersStack_API(String endpoint) {
		response = RestAssured.when().post(endpoint);
		System.out.println(response.body().prettyPrint());
	}

	@Then(value = "the response status code should be {int}")
	public void the_response_status_code_should_be_201(int statusCode) {
		Assert.assertEquals(statusCode, 201);
	}

	@Then(value = "the response content type should be {string}")
	public void the_response_content_type_should_be(String responseContetntType) {
		Assert.assertEquals(response.getContentType(), responseContetntType);
	}

	@Then(value = "the response body should contain {string}")
	public void the_response_body_should_contain(String query) {
		Assert.assertTrue(response.body().jsonPath().get(query));
	}
}
