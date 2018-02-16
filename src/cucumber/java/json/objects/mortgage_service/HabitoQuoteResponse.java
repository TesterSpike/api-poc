package json.objects.mortgage_service;

import org.json.JSONArray;
import org.json.JSONObject;
import util.JsonValidator;
import util.SchemaHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HabitoQuoteResponse {

    private JSONObject jsonObject;
    private JSONArray quote;

    public HabitoQuoteResponse(String jsonString) {
        this.jsonObject = new JSONObject(jsonString);
        quote = jsonObject.getJSONArray("quotes");
    }

    @Override
    public String toString() {
        return jsonObject.toString();
    }

    public void hasQuotes(int count) {
        assertEquals(count, quote.length(), "Expected number of quotes were not returned");
    }

    public void validateSchema(String schemaName) {
        JsonValidator validator = new JsonValidator();
        validator.validate(jsonObject, new SchemaHandler().getStringFromFile("mortgages", schemaName));
        assertTrue(validator.getValidationResult(), "Schema is invalid ==> " + validator.getErrors());
    }

}
