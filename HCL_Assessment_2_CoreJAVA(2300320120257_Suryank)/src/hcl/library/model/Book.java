package hcl.library.model;

import java.util.HashSet;
import java.util.Set;

public class Book extends LibraryItem {
    private static final Set<String> ISBN_NUMBERS = new HashSet<>();

    private final String author;
    private final String isbn;

    public Book(String title, int year, String author, String isbn) {
        super(title, year);
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author must not be blank");
        }
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN must not be blank");
        }
        if (!ISBN_NUMBERS.add(isbn)) {
            throw new IllegalArgumentException("A book with this ISBN already exists");
        }
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public double lateFee(int daysLate) {
        validateDaysLate(daysLate);
        return 20.0 * daysLate;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book(" + super.toString()
                + ", author=" + author
                + ", isbn=" + isbn + ")";
    }
}