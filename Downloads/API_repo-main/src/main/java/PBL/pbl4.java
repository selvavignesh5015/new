package PBL;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class pbl4 {

	@Test
	public void test_updateUser() {
		RestAssured.useRelaxedHTTPSValidation();
		JSONObject request = new JSONObject();
		request.put("name", "kamal");
		request.put("job", "TestEngineer");
		System.out.println(request.toString());
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.given().
		// header("Content-Type","application/json").
				body(request.toString()).when().put("/api/users/2").then().statusCode(200).log().all();
	}
}