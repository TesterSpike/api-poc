package util.restutilities;

import constant.ServiceName;
import constant.URL;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    public static RequestSpecBuilder getBasicRequestSpec(String serviceName) {
        return new RequestSpecBuilder()
                .setBaseUri(URL.getAdminUrl())
                .setBasePath(ServiceName.getUrlFromName(serviceName));
    }

    public static RequestSpecification getJSONRequestSpec(String serviceName) {
        return getBasicRequestSpec(serviceName)
                .setContentType(ContentType.JSON)
                .build();
    }

}
