package constant;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Arrays;

public enum ServiceName {
    MORTGAGE_SERVICE("/mortgage-service");

    private final String url;
    private static ImmutableMap<String, ServiceName> lookUp =
            Maps.uniqueIndex(Arrays.asList(ServiceName.values()), ServiceName::getUrl);

    ServiceName(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static ServiceName getServiceFromName(String name) {
        return lookUp.getOrDefault(name, MORTGAGE_SERVICE);
    }

    public static String getUrlFromName(String name) {
        return getServiceFromName(name).url;
    }

}
