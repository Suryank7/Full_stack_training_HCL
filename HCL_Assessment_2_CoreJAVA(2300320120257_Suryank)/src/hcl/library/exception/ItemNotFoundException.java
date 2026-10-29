package hcl.library.exception;

public class ItemNotFoundException extends LibraryException {
    public ItemNotFoundException(int itemId) {
        super("Item not found: " + itemId);
    }
}