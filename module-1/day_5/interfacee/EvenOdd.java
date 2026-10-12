package day_5.interfacee;

@FunctionalInterface
interface evodd{
    boolean inter(int a);
        }
public class EvenOdd {
    public static void main(String[] args) {
        evodd ab = (a)->a%2==0;
        int a = 21;
        if(ab.inter(a)){
            System.out.println("Number is even");
        }
        else{
            System.out.println("Number is odd");
        }
    }
}
