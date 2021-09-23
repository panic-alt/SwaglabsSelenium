package resources;

public class ItemValidationError extends Exception{

    public ItemValidationError() {
        super("Item's page does not match item selected in the inventory page");
    }

    public ItemValidationError(String message) {
        super(message);

    }
}
