package util;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonValidator {

    private boolean result = false;
    private ValidationException errors;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonValidator.class);

    public void validate(JSONObject json, JSONObject jsonSchema) {
        LOGGER.info("Validating Schema");
        Schema schema = SchemaLoader.builder().schemaJson(jsonSchema).build().load().build();
        try {
            schema.validate(json);
            result = true;
        } catch(ValidationException e) {
            errors = e;
        }
    }

    public boolean getValidationResult() {
        return result;
    }

    public String getErrors() {
        if(errors != null) {
            return errors.getErrorMessage();
        } else {
            return "No errors logged";
        }
    }
}
