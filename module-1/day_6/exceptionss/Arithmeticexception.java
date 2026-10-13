package day_6.exceptionss;

public class Arithmeticexception {
    public static void main(String[] args) {
        int a = 10;
        int b =0;

        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic exceptions occur");
        }
    }
}
