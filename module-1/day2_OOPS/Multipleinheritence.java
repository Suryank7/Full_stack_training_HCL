package day2_OOPS;

interface InterfaceA {
    void m1();
}

interface InterfaceB {
    void m2();
}

public class Multipleinheritence implements InterfaceA, InterfaceB {
    @Override
    public void m1() {
        System.out.println("hello from m1");
    }

    @Override
    public void m2() {
        System.out.println("Hi from m2");
    }

    public static void main(String[] args) {
        Multipleinheritence obj = new Multipleinheritence();
        obj.m1();
        obj.m2();
    }
}

