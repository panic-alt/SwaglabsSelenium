package resources;

public class PageValidationError extends Exception {
    public PageValidationError() {
        super("Page validation error. Could not find element it was looking for.");
    }
    public PageValidationError(String message) {
        super(message);
    }
}
