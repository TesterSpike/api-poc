package constant;

public class URL {

    public static String getAdminUrl() {
        return "https://admin." + getEnvironment() + "." + getCountry() + ".clearscore.io:83";
    }

    public static String getApiUrl() {
        return "https://api." + getEnvironment() + "." + getCountry() + ".clearscore.io";
    }

    //TODO get from properties file
    private static String getEnvironment() {
        return "ci";
    }

    private static String getCountry() {
        return "gb";
    }
}
