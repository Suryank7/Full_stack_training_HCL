package hcl.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final int id;
    private final String name;
    private final String email;
    private final List<LibraryItem> borrowedItems;

    public Member(int id, String name, String email) {
        this(id, name, email, new ArrayList<>());
    }

    public Member(int id, String name, String email, List<LibraryItem> borrowedItems) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }

        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>(borrowedItems);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<LibraryItem> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    @Override
    public String toString() {
        return "Member(id=" + id
                + ", name=" + name
                + ", email=" + email
                + ", borrowedItems=" + borrowedItems.size() + ")";
    }
}