package org.Prototype.files.Helper;

import io.restassured.path.json.JsonPath;

public class JsonRaw {
    public static JsonPath RawToJson(String response){
        JsonPath js= new JsonPath(response);
        return js;
    }
}
