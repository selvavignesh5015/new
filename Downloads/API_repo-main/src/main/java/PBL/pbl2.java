package PBL;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class pbl2 {

	@Test
	public void test_getUser() {
		
		RestAssured.useRelaxedHTTPSValidation();
		baseURI = "https://reqres.in";
		given().get("/api/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8))
				.body("data[4].first_name", equalTo("George")).body("data.first_name", hasItems("George", "Rachel"));
	}
}