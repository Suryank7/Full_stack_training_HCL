package hcl.library;

public interface Borrowable {
    boolean isAvailable();

    void borrow();

    void giveBack();
}