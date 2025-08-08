package org.Prototype.files.Deserialization_Of_Request_Response;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class OATHTEST  {
    private String accessToken;
    @Test
    public void oauthTest() {
        String response= RestAssured.given()
                .formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .when().log().all()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
         accessToken = jsonPath.getString("access_token");
    }
    @Test
    public void checkResponseTest(){
        GetCourses jc=given()
                .queryParam("accessToken",accessToken)
                .when().log().all()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails?access_token=9KFmr6SAuLA26FKpCahKuw==")
                .as(GetCourses.class);

        System.out.println("Linkedin "+jc.getLinkedIn());
    }



}
