package hcl.library.model;

public class DVD extends LibraryItem {
    private final int durationMinutes;

    public DVD(String title, int year, int durationMinutes) {
        super(title, year);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public double lateFee(int daysLate) {
        return 5.0 * daysLate;
    }

    @Override
    public String toString() {
        return "DVD(" + super.toString()
                + ", durationMinutes=" + durationMinutes + ")";
    }
}