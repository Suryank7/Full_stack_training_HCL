package OOPS;

class Parent {

    void m1() {
        System.out.println("hello from m1");
    }
}

class B extends Parent {

    void m2() {
        System.out.println("Hi from m2");
    }

    public static void main(String[] args) {

        Parent a1 = new Parent();
        B a2 = new B();
        B b1 = new B();
        Parent b2 = new Parent();

        a1.m1();
        b1.m1();
        b1.m2();
        a2.m1();
    }
}