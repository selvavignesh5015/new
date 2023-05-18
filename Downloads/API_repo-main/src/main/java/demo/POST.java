package demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class POST {

	@Test
	public void tes1() {
		//base URL
		RestAssured.baseURI="http://localhost:3000";
		
		
		RestAssured.given().contentType(ContentType.JSON)
		.body("{\n"
				+ "    \"id\": 4,\n"
				+ "    \"title\": \"jack\",\n"
				+ "    \"author\": \"spider\"\n"
				+ "    \n"
				+ "}")
		.post("/posts");
			
		Response response = RestAssured.given().get("/posts/4").then().extract().response();
		
		assertEquals(response.getStatusCode(),200);
		
		assertEquals(response.jsonPath().getString("id"), "4");
		
		assertEquals(response.jsonPath().getString("title"), "jack");
	}
}
