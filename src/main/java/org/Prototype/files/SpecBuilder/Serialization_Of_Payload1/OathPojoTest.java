package org.Prototype.files.SpecBuilder.Serialization_Of_Payload1;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OathPojoTest {

    @Test
    public void test(){
        RestAssured.baseURI="https://rahulShettyacademy.com/";
        AddPlace ad=new AddPlace();
        ad.setAccuracy(50);
        ad.setAddress("29, side layout, cohen 09");
        ad.setLanguage("French-IN");
        ad.setName("Frontline house");
        ad.setPhone_number("(+91) 983 893 3937");
        ad.setWebsite("http://google.com");
        List<String> li=new ArrayList<String>();
        li.add("London");
        li.add("Paris");
        ad.setTypes(li);
        //or
        //
        ad.setTypes(java.util.Arrays.asList("shoe park", "shop"));
        ad.setLocation(new Location(-38.383494, 33.427362));
        //or
        //Location loc=new Location("-38.383494", "33.427362");
        //ad.setLocation(loc);
        //or
        Location loc=new Location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        ad.setLocation(loc);

        String response= given().log().all().queryParam("Key","qaclick123")
                .header("Content-Type","application/json")
                .body(ad)
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println("Response :: " + response);
    }
}
