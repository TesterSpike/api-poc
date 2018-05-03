package step_definition.mortgage_service;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.SchemaHandler;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static user.MortgageUser.NEW_MORTGAGE_SINGLE_INSUFFICIENT_FUNDS;
import static user.MortgageUser.NEW_MORTGAGE_SINGLE_SUFFICIENT_FUNDS;
import static util.restutilities.POST.POST;
import static util.restutilities.RequestBuilder.getJSONRequestSpec;
import static util.restutilities.ResponseBuilder.getOkJsonResponseSpec;

public class HabitoQuotes {

    private static final Logger LOGGER = LoggerFactory.getLogger(HabitoQuotes.class);

    private RequestSpecification request;
    private ValidatableResponse response;

    @Given("^I am using the \"([^\"]*)\"$")
    public void givenIAmUsingThe(String serviceName) {
        request = given().spec(getJSONRequestSpec(serviceName));
    }

    @Given("^I have the data for a user with insufficient funds$")
    public void givenIHaveTheDataForAUserWithInsufficientFunds() {
        request.body(NEW_MORTGAGE_SINGLE_INSUFFICIENT_FUNDS.getJson());
    }

    @Given("^I have the data for a user with sufficient funds$")
    public void givenIHaveTheDataForAUserWithSufficientFunds() {
        request.contentType(ContentType.JSON)
                .body(NEW_MORTGAGE_SINGLE_SUFFICIENT_FUNDS.getJson());
    }

    @When("^I POST the user data to mortgage-service \"([^\"]*)\"$")
    public void whenIPOSTTheUserDataToMortgageService(String endpoint) {
        response = POST(request, endpoint);
    }

    @Then("^I will receive a prompt and valid response with no quote data$")
    public void thenIWillReceiveAPromptAndValidResponseWithNoQuoteData() {
        //TODO add schema validation to response spec for JSON
        response.spec(getOkJsonResponseSpec(2L))
                .body("quotes.size()", equalTo(0));
    }

    @Then("^I will receive a prompt and valid response with valid quote data$")
    public void thenIWillReceiveAPromptAndValidResponseWithValidQuoteData() {

        response.spec(getOkJsonResponseSpec(2L))
                .body("quotes.size()", equalTo(1));
    }
}
