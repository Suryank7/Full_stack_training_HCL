package day1_basics;

import day2_OOPS.A;

public class Demo {

    public static void main(String[] args) {
        A a = new A();
    }
}

class Student {

    Student() {
        System.out.println("Student object created");
    }

    public static void main(String[] args) {
        Student s = new Student();
    }
}

class Constructor {

    public static void main(String[] args) {
        System.out.println("Constructor demo execution");
    }
}