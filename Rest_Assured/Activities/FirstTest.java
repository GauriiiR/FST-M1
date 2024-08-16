package examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {
	// GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
	//response for this is a list of pets (if present)
	@Test
	public void getRequestWithQueryParam() {
		//send request, save response
		Response response = 
				given().
					baseUri("https://petstore.swagger.io/v2/pet").
					header("Content-Type", "application/json").
					queryParam("status", "alive").
				when().
					get("/findByStatus");
		
		//Print headers
		System.out.println(response.getHeaders());
		
		//print body
		System.out.println(response.getBody().asString());
		System.out.println("...................................");
		System.out.println(response.getBody().asPrettyString());
		
		//Extract individual values
		String petStatus = response.then().extract().path("[0].status");
		//assertions
		Assert.assertEquals(petStatus, "alive");
		
		//Using RESTAssured in line 37 to work for both lines 32 and 34
		response.then().statusCode(200).body("[0].status", equalTo("alive"));
	}
	
	
	// GET https://petstore.swagger.io/v2/pet/{petId}
	// response for this is one exact match
	@Test
	public void getRequestWithPathParam() {
		//send request, get response, and assert with logging
		//proper restassured syntax
		// 'petId' in line 50 should exactly match petId in line 49 alphabetically. exact match
		given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type", "application/json").
			pathParam("petId", 77232).
			log().all().
		when().
			get("/{petId}").
		then().
			statusCode(200).
			body("status", equalTo("alive")).
			body("name", equalTo("Riley")).
			log().all();	
		
		
	}
}
