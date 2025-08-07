package org.Prototype.files.JIRA_AUTOMATION;

import io.restassured.RestAssured;
import org.Prototype.files.Token.AuthorizationToken;
import org.Prototype.files.Payload.Payload;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BugTest {
    @Test
    public void testBug(){
        RestAssured.baseURI = "https://ayushvermax16asdad.atlassian.net";
        String response=given().log().all()
                .header("Content-Type","application/json")
                .header("Authorization", AuthorizationToken.AuthenticationBearerBASE64Token())
                .body(Payload.AutomatingJiraAuthentication())
                .when().post("/rest/api/3/issue")
                .then().log().all().assertThat().statusCode(201)
                .extract().response().asString();
        System.out.println(response);
    }
}

