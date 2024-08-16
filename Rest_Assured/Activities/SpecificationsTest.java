package examples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

public class SpecificationsTest {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId;
	
	//POST https://petstore.swagger.io/v2/pet
	//GET https://petstore.swagger.io/v2/pet/{petId}
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
	
	@BeforeClass
	public void setUp() {
		//Request Specification
		requestSpec = new RequestSpecBuilder().
			setBaseUri("https://petstore.swagger.io/v2/pet").
			addHeader("Content-Type", "application/json").
			build();
		//	addHeader("Authorization", "token_token number") --> will be used for github project to pass access token
		//Response Specification
		responseSpec = new ResponseSpecBuilder().
			expectStatusCode(200).
			expectResponseTime(lessThanOrEqualTo(3000L)).
			build();
		    //3000 is milisecond. Long value is expected so 3000L
	}
	
	//POST https://petstore.swagger.io/v2/pet
	@Test(priority = 1)
	public void postRequest() {
		//create request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 99223);
		reqBody.put("name", "Pluto");
		reqBody.put("status", "alive");
		//send request, save response
		Response response = given().spec(requestSpec).body(reqBody).when().post();
		//extract the pet id
		petId = response.then().extract().path("id");
		
		//assertion
		response.then().spec(responseSpec).body("status", equalTo("alive")).log().all();
		
	}
	
	//GET https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 2)
	public void getRequest() {
		//send request, get response, assert response
		given().spec(requestSpec).pathParam("petId", petId).log().uri().
		when().get("/{petId}").
		then().spec(responseSpec).body("status", equalTo("alive")).log().all();
	}
	
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
		@Test(priority = 3)
		public void deleteRequest() {
			//send request, get response, assert response
			given().spec(requestSpec).pathParam("petId", petId).log().uri().
			when().delete("/{petId}").
			then().spec(responseSpec).body("message", equalTo(""+petId)).log().all();
		}

}
