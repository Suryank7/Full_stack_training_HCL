package hcl.library.model;

public class Magazine extends LibraryItem {
    private final int issueNumber;

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public double lateFee(int daysLate) {
        return 1.90 * daysLate;
    }

    @Override
    public String toString() {
        return "Magazine(" + super.toString()
                + ", issueNumber=" + issueNumber + ")";
    }
}