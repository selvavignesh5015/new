package demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET {

	@Test
	public void tes1() {
		//base URL
		RestAssured.baseURI="http://localhost:3000";
		
		
		RestAssured.given().get("/posts").then().statusCode(200).log().all();
		
		Response response = RestAssured.given().get("/posts/3").then().statusCode(200).extract().response();
		
		assertEquals(response.getStatusCode(),200);
		
		assertEquals(response.jsonPath().getString("id"), "3");
		
		assertEquals(response.jsonPath().getString("title"), "jack");
	}
}
