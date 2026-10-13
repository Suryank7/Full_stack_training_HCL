package hcl.library.model;

public class Book extends LibraryItem {
    private final String author;
    private final String isbn;

    public Book(String title, int year, String author, String isbn) {
        super(title, year);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public double lateFee(int daysLate) {
        return 20.0 * daysLate;
    }

    @Override
    public String toString() {
        return "Book(" + super.toString()
                + ", author=" + author
                + ", isbn=" + isbn + ")";
    }
}