package resources;

public class ItemQuantityError extends Exception{

    public ItemQuantityError() {
        super("the shopping cart's item count does not match the quantity of items added");
    }

    public ItemQuantityError(String message) {
        super(message);

    }
}
