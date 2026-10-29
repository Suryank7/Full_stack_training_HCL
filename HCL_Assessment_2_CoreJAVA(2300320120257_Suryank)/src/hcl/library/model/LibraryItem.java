package hcl.library.model;

import java.time.Year;
import java.util.Objects;

import hcl.library.Borrowable;

public abstract class LibraryItem implements Borrowable {
    private static int nextId = 1001;

    private final int id;
    private final String title;
    private final int year;
    private boolean available = true;

    protected LibraryItem(String title, int year) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank");
        }
        if (year < 1900 || year > Year.now().getValue()) {
            throw new IllegalArgumentException("Year must be between 1900 and the current year");
        }

        this.id = nextId++;
        this.title = title;
        this.year = year;
    }

    public abstract double lateFee(int daysLate);

    protected void validateDaysLate(int daysLate) {
        if (daysLate < 0) {
            throw new IllegalArgumentException("Days late cannot be negative");
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrow() {
        available = false;
    }

    @Override
    public void giveBack() {
        available = true;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id=").append(id)
                .append(", title=").append(title)
                .append(", year=").append(year)
                .append(", available=").append(available)
                .toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryItem)) {
            return false;
        }
        LibraryItem that = (LibraryItem) other;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}