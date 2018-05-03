package util;

import io.restassured.RestAssured;

public class BaseURI {

    public static void setup(String serviceName) {
        RestAssured.baseURI = "https://admin.ci.gb.clearscore.io:83";
        RestAssured.basePath = "/mortgage-service";
    }
}
