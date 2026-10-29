package hcl.library.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import hcl.library.model.Book;
import hcl.library.model.LibraryItem;

public final class SearchUtil {
    private SearchUtil() {
    }

    public static List<LibraryItem> searchItems(List<LibraryItem> items, String query) {
        String search = query.toLowerCase(Locale.ROOT);
        List<LibraryItem> matches = new ArrayList<>();
        for (LibraryItem item : items) {
            boolean matchesTitle = item.getTitle().toLowerCase(Locale.ROOT).contains(search);
            boolean matchesBookDetails = item instanceof Book
                    && (((Book) item).getAuthor().toLowerCase(Locale.ROOT).contains(search)
                    || ((Book) item).getIsbn().toLowerCase(Locale.ROOT).contains(search));
            if (matchesTitle || matchesBookDetails) {
                matches.add(item);
            }
        }
        return matches;
    }
}