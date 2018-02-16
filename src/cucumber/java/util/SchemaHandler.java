package util;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SchemaHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonValidator.class);

    public JSONObject getStringFromFile(String path, String schemaName) {
        try {
            return new JSONObject(new FileHandler().getStringFromSchemaFile(path, schemaName));
        } catch(IOException e) {
            e.printStackTrace();
            LOGGER.error("File was not loaded so empty json object was returned");
            return new JSONObject("{}");
        }
    }
}
