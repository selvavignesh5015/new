package PBL;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class pbl5 {

	@Test
	public void test_patchUser() {
		RestAssured.useRelaxedHTTPSValidation();
		JSONObject request = new JSONObject();
		request.put("name", "kamal");
		request.put("job", "Tester");
		System.out.println(request.toString());
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.given().
		// header("Content-Type","application/json").
				body(request.toString()).when().patch("/api/users/2").then().statusCode(200).log().all();
	}
}