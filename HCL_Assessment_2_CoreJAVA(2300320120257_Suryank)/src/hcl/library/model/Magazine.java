package hcl.library.model;

public class Magazine extends LibraryItem {
    private final int issueNumber;

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        if (issueNumber < 1) {
            throw new IllegalArgumentException("Issue number must be positive");
        }
        this.issueNumber = issueNumber;
    }

    @Override
    public double lateFee(int daysLate) {
        validateDaysLate(daysLate);
        return 1.90 * daysLate;
    }

    @Override
    public String toString() {
        return "Magazine(" + super.toString()
                + ", issueNumber=" + issueNumber + ")";
    }
}