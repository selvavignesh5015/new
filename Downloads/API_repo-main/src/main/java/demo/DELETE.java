package demo;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DELETE {

	@Test
	public void tes1() {
		//base URL
		RestAssured.baseURI="http://localhost:3000";
		String title = getrandomstring();

		Response resp =RestAssured.given().contentType(ContentType.JSON)
		.body("{\n"
				+ "    \"title\": \""+ title +"\",\n"
				+ "    \"author\": \"spider\"\n"
				+ "}")
		.post("/posts");
		assertEquals(resp.getStatusCode(), 201);
		RestAssured.get("/posts").then().log().all();
		
		String newlyaddedid=resp.jsonPath().getString("id");
		
		Response respdel= RestAssured.given().delete("/posts/" + newlyaddedid+"");
		
			
		
//		RestAssured.given().get("/posts").then().statusCode(200).log().all();
//		
//		Response response = RestAssured.given().get("/posts/3").then().statusCode(200).extract().response();
//		
		assertEquals(respdel.getStatusCode(),200);
		System.out.println(respdel.getStatusCode());
//		
//		assertEquals(response.jsonPath().getString("id"), "3");
//		
//		assertEquals(response.jsonPath().getString("title"), "jack");
	}
	public static String getrandomstring() {
		Random random= new Random();
		String Newtitle="New_" +random.nextInt();
		return Newtitle;
		System.out.println("heloo");
	}
}
