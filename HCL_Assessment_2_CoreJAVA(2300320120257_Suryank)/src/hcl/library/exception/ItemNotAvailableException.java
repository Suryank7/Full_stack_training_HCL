package hcl.library.exception;

public class ItemNotAvailableException extends LibraryException {
    public ItemNotAvailableException(int itemId) {
        super("Item is not available: " + itemId);
    }
}