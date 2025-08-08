package org.Prototype.files.CRUD_TESTING;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.Prototype.files.Payload.Payload;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetPutPostApis {
    public static void main(String[] args) {
        //add place api is working as expected or not
        //Given

        //post api
        RestAssured.baseURI="https://rahulShettyacademy.com/";
        String response=given().log().all().queryParam("Key","qaclick123")
       .header("Content-Type","application/json")
                .body(Payload.addPlace())
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server", equalTo("Apache/2.4.52 (Ubuntu)"))
                .header("Access-Control-Max-Age",equalTo("3600")).extract().response().asString();
        System.out.println("Response :: " + response);

        JsonPath jp = new JsonPath(response);
        String placeId=jp.getString("place_id");
        System.out.println("Place Id :: " + placeId);
    //add place and update place with new address-> get place to validate
       // new add is present in response or not
        //update place with new place id

        //put api
        String newAddress="Summer walk, Africa";
        given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put(" /maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
        System.out.println("Place Id :: " + placeId+"For this place id address is successfully updated");

        String address=jp.getString("address");

        System.out.println("Put methord is working as expected");


        //get place api
        //get api
        String getPlaceResponse=given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).body("address",equalTo("Summer walk, Africa"))
                .extract().response().asString();
        JsonPath jp2=new JsonPath(getPlaceResponse);
        String actualAddress=jp2.getString("address");
        System.out.println("Actual Address :: " + actualAddress);

        Assert.assertEquals(actualAddress,newAddress);

    }

}