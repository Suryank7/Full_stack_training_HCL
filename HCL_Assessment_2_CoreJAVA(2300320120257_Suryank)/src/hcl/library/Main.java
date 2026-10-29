package hcl.library;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import hcl.library.model.Book;
import hcl.library.model.DVD;
import hcl.library.model.LibraryItem;
import hcl.library.model.Magazine;
import hcl.library.model.Member;
import hcl.library.service.LibraryService;
import hcl.library.util.CollectionUtil;
import hcl.library.util.ReportUtil;
import hcl.library.util.SearchUtil;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final LibraryService library = new LibraryService();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            printMenu();
            try {
                int choice = readInt("Choice: ");
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        registerMember();
                        break;
                    case 3:
                        borrowItem();
                        break;
                    case 4:
                        returnItem();
                        break;
                    case 5:
                        addToWaitlist();
                        break;
                    case 6:
                        listItems(library.getAllItems());
                        break;
                    case 7:
                        searchItems();
                        break;
                    case 8:
                        exportReport();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Choose a number from 0 to 8.");
                }
            } catch (RuntimeException | IOException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        System.out.println("Goodbye.");
    }

    private void printMenu() {
        System.out.println("\n1. Add item  2. Register member  3. Borrow  4. Return");
        System.out.println("5. Waitlist  6. List items  7. Search  8. Export report  0. Exit");
    }

    private void addItem() {
        System.out.print("Type (B=Book, M=Magazine, D=DVD): ");
        String type = scanner.nextLine().trim().toUpperCase();
        String title = readLine("Title: ");
        int year = readInt("Year: ");
        LibraryItem item;

        if ("B".equals(type)) {
            String author = readLine("Author: ");
            String isbn = readLine("ISBN: ");
            item = new Book(title, year, author, isbn);
        } else if ("M".equals(type)) {
            item = new Magazine(title, year, readInt("Issue number: "));
        } else if ("D".equals(type)) {
            item = new DVD(title, year, readInt("Duration in minutes: "));
        } else {
            throw new IllegalArgumentException("Unknown item type");
        }

        library.addItem(item);
        System.out.println("Added: " + item);
    }

    private void registerMember() {
        int id = readInt("Member id: ");
        String name = readLine("Name: ");
        String email = readLine("Email: ");
        Member member = new Member(id, name, email);
        library.registerMember(member);
        System.out.println("Registered: " + member);
    }

    private void borrowItem() {
        int memberId = readInt("Member id: ");
        int itemId = readInt("Item id: ");
        library.borrowItem(memberId, itemId);
        System.out.println("Issued: " + library.getItem(itemId));
    }

    private void returnItem() {
        int memberId = readInt("Member id: ");
        int itemId = readInt("Item id: ");
        int daysLate = readInt("Days late: ");
        double fee = library.returnItem(memberId, itemId, daysLate);
        System.out.println("Returned. Late fee: " + fee);
        if (!library.getItem(itemId).isAvailable()) {
            System.out.println("The next waitlisted member has been issued the item.");
        }
    }

    private void addToWaitlist() {
        int memberId = readInt("Member id: ");
        int itemId = readInt("Item id: ");
        library.addToWaitlist(memberId, itemId);
        System.out.println("Added to waitlist: " + library.getWaitlist(itemId));
    }

    private void searchItems() {
        String query = readLine("Search title, author, or ISBN: ");
        listItems(SearchUtil.searchItems(library.getAllItems(), query));
    }

    private void listItems(List<LibraryItem> items) {
        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        for (LibraryItem item : items) {
            System.out.println(item);
        }
        System.out.println("Available: " + CollectionUtil.availableItems(items).size());
    }

    private void exportReport() throws IOException {
        String fileName = "library-report.txt";
        ReportUtil.export(fileName, library.getAllItems(), library.getAllMembers());
        System.out.println("Report exported to " + fileName);
    }

    private int readInt(String prompt) {
        try {
            return Integer.parseInt(readLine(prompt));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Enter a whole number", exception);
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}