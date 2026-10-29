package hcl.library.exception;

public class BorrowerLimitExceededException extends LibraryException {
    public BorrowerLimitExceededException(int limit) {
        super("A member cannot borrow more than " + limit + " items");
    }
}