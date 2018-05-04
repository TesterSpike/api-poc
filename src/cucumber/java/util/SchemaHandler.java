package util;

import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class SchemaHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchemaHandler.class);

    public static String getJsonStringFromFile(String path, String schemaName) {
        try {
            return new JSONObject(new FileHandler().getStringFromSchemaFile(path, schemaName)).toString(3);
        } catch(IOException e) {
            e.printStackTrace();
            LOGGER.error("File was not loaded so empty json object was returned");
            return new JSONObject("{}").toString(3);
        }
    }

    public static Matcher<?> validateSchema(String location, String fileName) {
        return matchesJsonSchema(SchemaHandler.getJsonStringFromFile(location, fileName));
    }
}
