package constant;

public enum StatusCode {
    CODE_200("OK", 200), CODE_201("Created", 201), CODE_204("No Content", 204),
    CODE_400("Bad Request", 400), CODE_401("Unauthorized", 401), CODE_403("Forbidden", 403), CODE_404("Not Found", 404);

    private final int statusCode;
    private final String statusName;

    StatusCode(String statusName, int statusCode) {
        this.statusName = statusName;
        this.statusCode = statusCode;
    }

    public int statusCode() {
        return statusCode;
    }

    public String statusName() {
        return statusName;
    }
}
