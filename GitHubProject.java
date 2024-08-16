package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProject {
    // SSH Key to test with
    String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCBq3lRKrfjFnnkZ6+m4ODC7xhzJfl4yGkpnelbKPA6ZoH66+uLE/eKaOAyhvqh68YqakWDLmnp7YaS7jhT0InBmg9STW28NGuWmq+k6VS+ERhcWpG2FdFavTATdldG274NEEGvfuR1PBeAgwmdK5hU7JYGdvZPWAYpnY1xuTZb1OeekMqgsLhaZ3mmnvXzSgyP5hFYnh57jOEewbgDWbhdBHmBIr12AaYtw2CwNKsxRLTTAjbMq71OKYLEOrgbqqDFIc+odYdcmzXS2yQ/QBRmeQXgZ/Pfiyf+LA6CZurQZy/7tLhxWJS1KiJieYMZ+PXwIjHYFqFpVkgHhcjglki1";
    int sshKeyId;

    // Request specification
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").
            addHeader("Authorization", "token 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").
            addHeader("Content-Type", "application/json").
            build();

    // Response Specification
    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(4000L)).
            expectBody("key", equalTo(sshKey)).
            expectBody("title", equalTo("TestAPIKey")).
            build();

    @Test(priority = 1)
    public void postRequestTest() {
        // Path: https://api.github.com/user/keys
        // Request body
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);

        // Generate response
        Response response = given().spec(requestSpec).body(reqBody).when().post();

        // Extract the id
        sshKeyId = response.then().extract().path("id");

        // Assertions
        response.then().statusCode(201).spec(responseSpec);
    }

    @Test(priority = 2)
    public void getRequestTest() {
        // Path: https://api.github.com/user/keys/{keyId}
        // Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().get("/{keyId}").
        then().statusCode(200).spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteRequestTest() {
        // Path: https://api.github.com/user/keys/{keyId}
        // Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().delete("/{keyId}").
        then().statusCode(204).time(lessThan(3000L));
    }

}
