package liveProject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	//set the headers
	Map<String, String> headers = new HashMap<String, String>();
	
	//Create the contract(Pact)
	@Pact(consumer = "UserConsumer", provider = "UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		//Set the headers
		headers.put("Content-Type", "application/json");
		//Create the request and response body --> will be in same because it has same output
		DslPart requestResponseBody = new PactDslJsonBody().
				numberType("id", 555).
				stringType("firstName", "Gauri").
				stringType("lastName", "Rewatkar").
				stringType("email", "gauri@ibm.com");
		
		//create contract
		return builder.given("POST Request").
			uponReceiving("request to create user").
				method("POST").
				path("/api/users").
				headers(headers).
				body(requestResponseBody).
			willRespondWith().
				status(201).
				body(requestResponseBody).
			toPact();
		
	}
	
	//Consumer test with mock provider
	//port number anything other than 8585 because actual server runs on 8585
	@Test
	@PactTestFor(providerName = "UserProvider", port = "8282")
	public void postRequestTest() {
		//create a request body
		Map<String,Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 555);
		reqBody.put("firstName", "Gauri");
		reqBody.put("lastName", "Rewatkar");
		reqBody.put("email", "gauri@ibm.com");
		
		//send a request, get response, assert response
		given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all().
		when().post().
		then().statusCode(201).body("id", equalTo(555));
	}
	

}
