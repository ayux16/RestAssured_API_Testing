package org.Prototype.files.Serialization_Of_Payload1;

import com.sun.net.httpserver.Request;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        ad.setTypes(Arrays.asList("shoe park", "shop"));
        ad.setLocation(new Location(-38.383494, 33.427362));
        //or
        //Location loc=new Location("-38.383494", "33.427362");
        //ad.setLocation(loc);
        //or
        Location loc=new Location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        ad.setLocation(loc);

        //generalized common request for all
        RequestSpecification request= new RequestSpecBuilder().setBaseUri("https://rahulShettyacademy.com/").addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON)
                .addHeader("Content-Type","application/json").build();


        //break it here
        RequestSpecification res = given().spec(request).body(ad);


        //used it here
        Response response= res.when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).extract().response();


        String resnseString=response.toString();
        System.out.println("Response :: " + resnseString);
    }
}
