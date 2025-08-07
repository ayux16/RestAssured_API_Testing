package org.Prototype.files;

import io.restassured.RestAssured;
import org.Prototype.files.Payload.Payload;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class DynamicJsonPayloads {
    //if we have a requirement of changing the values in the json payload for every test

    @Test
    public void testDynamicJsonPayloads() {
        RestAssured.baseURI = "http://216.10.245.166";
        String response=given().log().all()
                .header("Content-Type","application/json")
                .body(Payload.AddBook())
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(response);
    }

    /*i want to update ispn and asile dynamicly no hardcoding payload--> we want to send dynamicly */

    @Test
    public void dynamicUpdatePayload(){
        RestAssured.baseURI = "http://216.10.245.166";
        String response=given().log().all()
                .header("Content-Type","application/json")
                .body(Payload.AddBook("huhuhahahahha","he6969121269"))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(response);
    }

    @Test
    public void testDynamicJsonPayloadFile() throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        String response=given().log().all()
                .header("Content-Type","application/json")
                .body(Files.readAllBytes(Paths.get("/Users/incarnation/" +
                        "IdeaProjects/Backend Application/" +
                        "REST APIMaven PRoject/src/main/java/org/Prototype/files/Payload.json")))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(response);
    }

    @Test(dataProvider = "BookDataIA")
    public void dynamicAddValue(String isin,String aisle){
        RestAssured.baseURI = "http://216.10.245.166";
        String response=given().log().all()
                .header("Content-Type","application/json")
                .body(Payload.AddBook(isin,aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(response);
    }
    @DataProvider(name="BookDataIA")
    public Object[][] getData(){
        return new Object[][]{
                {"absd","2131"},
                {"bsde","2321"},
                {"fsas","8663"},
                {"absd","2131"},
                {"bsde","2321"},
                {"fsas","8663"},
                {"absd","2131"},
                {"bsde","2321"},
                {"fsas","8663"},
                {"absd","2131"},
                {"bsde","2321"},
                {"fsas","8663"},
                {"absd","2131"},
                {"bsde","2321"},
                {"fsas","8663"},
                {"absd","2131"},
                {"bsde","2321"},
                {"fsas","8663"},
                {"oiuhsyad","81231"}
        };
    }

}


// parameterize the API with multiple data sets-> use DataProvider with an array of objects

//Dynamicaly build Json Payload pass data as an argument and in the payload dynamicly add data ->
            // shorcut is create payload seperatly inside a methord with arguments and return the payload as a string with multiple arguments



//send static json file(payload_ directly into post method of rest assured(((json file)))

