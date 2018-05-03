package util.restutilities;

import constant.ServiceName;
import constant.URL;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static constant.StatusCode.CODE_200;
import static org.hamcrest.Matchers.lessThan;

public class ResponseBuilder {

    public static ResponseSpecification getOkJsonResponseSpec(long time) {
        ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
        responseBuilder.expectContentType(ContentType.JSON)
                .expectStatusCode(CODE_200.statusCode())
                .expectResponseTime(lessThan(time), TimeUnit.SECONDS);
        return responseBuilder.build();
    }
}
