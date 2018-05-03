package json.objects.mortgage_service;

import org.json.JSONArray;
import org.json.JSONObject;
import util.SchemaHandler;

public class HabitoQuoteResponse {

    //TODO remove this and add validation to response builder methods for JSON responses
    private JSONObject jsonObject;
    private JSONArray quote;

    public void validateSchema(String schemaName) {
        new SchemaHandler().getStringFromFile("mortgages", schemaName);
    }

}
