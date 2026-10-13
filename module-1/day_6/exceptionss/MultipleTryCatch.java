package day_6.exceptionss;

public class MultipleTryCatch {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        try {
            System.out.println(numbers[5]);
            System.out.println(10 / 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error");
        }

        System.out.println("Program continues");
    }
}
