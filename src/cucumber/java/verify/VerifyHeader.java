package verify;

import constant.StatusCode;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifyHeader {

    /**
     *
     * @param response Response object
     * @param code Expected status code
     */
    public static void hasStatusCode(Response response, StatusCode code) {
        assertEquals(response.getStatusCode(), code.statusCode(), "Incorrect code: " + response.asString());
    }

    /**
     * Asserts whether the response's header has one of the expected values
     * @param response Response object
     * @param headerName Header to verify
     * @param values Array of possible header values
     */
    public static void hasHeaderValue(Response response, String headerName, List<String> values) {
        assertTrue(values.contains(response.getHeader(headerName)),
                headerName + " should have contained " + values.toString() + " but was " + response.getHeader(headerName));
    }

}
