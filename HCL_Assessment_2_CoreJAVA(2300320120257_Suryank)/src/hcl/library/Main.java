package hcl.library;

import hcl.library.model.Book;
import hcl.library.model.DVD;
import hcl.library.model.LibraryItem;
import hcl.library.model.Magazine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("Clean Code", 2008, "Robert Martin", "9780132350884"));
        items.add(new Magazine("Science Monthly", 2024, 12));
        items.add(new DVD("Java Basics", 2022, 90));

        StringBuilder report = new StringBuilder();
        for (LibraryItem item : items) {
            report.append(item)
                    .append(" | late fee for 3 days: ")
                    .append(item.lateFee(3))
                    .append(System.lineSeparator());
        }

        System.out.print(report);
    }
}