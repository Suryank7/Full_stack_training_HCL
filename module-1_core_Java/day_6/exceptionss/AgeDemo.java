package day_6.exceptionss;

class InvalidCustomException extends Exception {
    public InvalidCustomException(String message) {
        super(message);
    }
}

class Age {
    private int age = 17;
    public void withdraw(int age)
            throws InvalidCustomException {

        if (age <= 18) {
            throw new InvalidCustomException(
                    "Under Age"
            );
        }
        System.out.println("Program Finished");
    }
}

public class AgeDemo {
    public static void main(String[] args) {
        Age age = new Age();
        try{
            age.withdraw(17);
        }
        catch(InvalidCustomException e){
            System.out.println(e.getMessage());
        }
    }
}