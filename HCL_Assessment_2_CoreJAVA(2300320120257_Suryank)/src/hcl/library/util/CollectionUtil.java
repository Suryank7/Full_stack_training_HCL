package hcl.library.util;

import java.util.ArrayList;
import java.util.List;

import hcl.library.model.LibraryItem;

public final class CollectionUtil {
    private CollectionUtil() {
    }

    public static List<LibraryItem> availableItems(List<LibraryItem> items) {
        List<LibraryItem> available = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.isAvailable()) {
                available.add(item);
            }
        }
        return available;
    }
}