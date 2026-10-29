package day2_OOPS;

class ParentSuper {
    ParentSuper() {
        System.out.println("parent class constructor");
    }
}

class Child extends ParentSuper {

    Child() {
        super();
        System.out.println("child class constructor");
    }
}

public class Super {
    public static void main(String[] args) {
        Child c = new Child();
    }
}