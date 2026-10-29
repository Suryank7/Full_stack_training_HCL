package day_7;

public class SwitchCase {
    public static void main(String[] args) {
        String day = "Monday";
        String result = switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> "Invalid Day";
        };
        System.out.println(result);
}
    }
