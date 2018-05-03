package util.restutilities;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST {

    public static ValidatableResponse POST(RequestSpecification request, String endpoint) {
        return request.post(endpoint).then().log().ifError();
    }
}
