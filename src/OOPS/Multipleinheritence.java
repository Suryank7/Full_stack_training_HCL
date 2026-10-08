package OOPS;

class A {
    void m1(){
        System.out.println("hello from m1");
    }
}
public class B extends A {
    void m2() {
        System.out.println("Hi from m2");
    }

    public static void main(String[] args) {
        A a1 = new A();
        B a2 = new B();
        B b1 = new B();
        A b2 = new A();

        a1.m1();
        b1.m1();
        b1.m2();
        a2.m1();
    }
}

