package day2_OOPS;

class Parent {

    void m1() {
        System.out.println("hello from m1");
    }
}

class ChildB extends Parent {

    void m2() {
        System.out.println("Hi from m2");
    }
}

public class Inheritence {
    public static void main(String[] args) {
        Parent a1 = new Parent();
        ChildB a2 = new ChildB();
        ChildB b1 = new ChildB();
        Parent b2 = new Parent();

        a1.m1();
        b1.m1();
        b1.m2();
        a2.m1();
    }
}