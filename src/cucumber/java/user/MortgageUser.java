package user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import step_definition.mortgage_service.HabitoQuotes;
import util.FileHandler;

import java.io.IOException;

public enum MortgageUser {
    NEW_MORTGAGE_SINGLE_INSUFFICIENT_FUNDS("new_mortgage_single_insufficient_funds"),
    NEW_MORTGAGE_SINGLE_SUFFICIENT_FUNDS("new_mortgage_single_sufficient_funds");

    private final String fileName;
    private static final Logger LOGGER = LoggerFactory.getLogger(HabitoQuotes.class);

    MortgageUser(String fileName) {
        this.fileName = fileName;
    }

    public String getJson() {
        try {
            LOGGER.info("Attempting to load file " + fileName);
            return new FileHandler().getStringFromJSONFile("mortgages", fileName);
        } catch(IOException e) {
            e.printStackTrace();
            LOGGER.error(fileName + " was not loaded so empty json object was returned");
            return "{}";
        }
    }
}
