package demo;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PUT {

	@Test
	public void tes1() {
		//base URL
		RestAssured.baseURI="http://localhost:3000";
		String title = randomtitle();
		
		Response resp = RestAssured.given().contentType(ContentType.JSON)
		.body("{\n"
				+ "   \n"
				+ "    \"title\": \""+title+"\"\n"
				+ "    \n"
				+ "}").when().put("/posts/3");
		assertEquals(resp.getStatusCode(), 200);
		assertEquals(resp.jsonPath().getString("title"), title);
	
		
	}
	public static String randomtitle() {
		Random random = new Random();
		String Newtitle= "new_"+random.nextInt();
		return Newtitle;
	}
}
