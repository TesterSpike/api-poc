package step_definition.mortgage_service;

import constant.StatusCode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import json.objects.mortgage_service.HabitoQuoteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import verify.VerifyHeader;

import java.util.Arrays;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static user.MortgageUser.NEW_MORTGAGE_SINGLE_INSUFFICIENT_FUNDS;
import static user.MortgageUser.NEW_MORTGAGE_SINGLE_SUFFICIENT_FUNDS;

public class HabitoQuotes {

    private static final Logger LOGGER = LoggerFactory.getLogger(HabitoQuotes.class);

    private static final String CONTENT_TYPE_JSON = "application/json";
    //TODO parametrise the root url
    private static final String ROOT_URL = "https://admin.ci.gb.clearscore.io:83/mortgage-service/v1";
    private String requestBody;
    private Response response;

    @Given("^I have the data for a user with insufficient funds$")
    public void givenIHaveTheDataForAUserWithInsufficientFunds() {
        requestBody = NEW_MORTGAGE_SINGLE_INSUFFICIENT_FUNDS.getJson();
    }

    @Given("^I have the data for a user with sufficient funds$")
    public void iHaveTheDataForAUserWithSufficientFunds() {
        requestBody = NEW_MORTGAGE_SINGLE_SUFFICIENT_FUNDS.getJson();
    }

    @When("^I POST the user data to mortgage-service \"([^\"]*)\"$")
    public void whenIiPOSTTheUserDataToMortgageService(String endpoint) {
        LOGGER.info("Posting quote request to Habito");
        response = given().contentType(CONTENT_TYPE_JSON).body(requestBody).when().post(ROOT_URL + endpoint);
    }

    @Then("^I will receive a prompt and valid response with no quote data$")
    public void thenIWillReceiveAPromptAndValidResponseWithNoQuoteData() {
        HabitoQuoteResponse responseBody = new HabitoQuoteResponse(response.getBody().asString());
        LOGGER.info("Verifying response");
        VerifyHeader.hasStatusCode(response, StatusCode.CODE_200);
        VerifyHeader.hasHeaderValue(response, "Content-Type", Arrays.asList("application/json", "application/json; charset=UTF-8"));
        VerifyHeader.hasHeaderValue(response, "Access-Control-Allow-Origin", Collections.singletonList("*"));
        responseBody.hasQuotes(0);
        responseBody.validateSchema("HabitoEmptyQuote");
    }

    @Then("^I will receive a prompt and valid response with valid quote data$")
    public void thenIWillReceiveAPromptAndValidResponseWithValidQuoteData() {
        HabitoQuoteResponse responseBody = new HabitoQuoteResponse(response.getBody().asString());
        LOGGER.info("Verifying response");
        assertEquals(response.getStatusCode(), StatusCode.CODE_200.statusCode(), "Incorrect code: " + response.asString());
        responseBody.hasQuotes(0);
        responseBody.validateSchema("HabitoQuote");
    }
}
