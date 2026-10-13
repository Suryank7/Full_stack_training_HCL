package day_5_functional_interface.interfacee;

@FunctionalInterface
interface calculator{
    int calculate(int a,int b);
}

public class Inter {
    public static void main(String [] args) {
        calculator add = (a,b)->a+b;
        calculator sub = (a,b)->a-b;
        calculator mul = (a,b)->a*b;
        calculator div = (a,b)->a/b;
        calculator mod = (a,b)->a%b;


        System.out.println("sum of two elements is"+add.calculate(10,5));
        System.out.println("difference of two elements is"+sub.calculate(10,5));
        System.out.println("product of two elements is"+mul.calculate(10,5));
        System.out.println("division of two elements is"+div.calculate(10,5));
        System.out.println("remainer of two elements is"+mod.calculate(10,5));
    }
}
