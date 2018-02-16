package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {

    public String getStringFromJSONFile(String path, String name) throws IOException {
        String file = "src/cucumber/resources/data/" + path + "/json/" + name + ".json";
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public String getStringFromSchemaFile(String path, String name) throws IOException {
        String file = "src/cucumber/resources/data/" + path + "/schema/" + name + ".schema";
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
