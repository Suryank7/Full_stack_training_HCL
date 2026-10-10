package day2_OOPS;

public class Overloading {

    String name;
    int rollno;

    Overloading() {
        this.name = "Default";
        this.rollno = 0;
    }

    Overloading(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollno);
    }

    void display(String prefix) {
        System.out.println(prefix + " - Name: " + name + ", Roll No: " + rollno);
    }

    public static void main(String[] args) {
        Overloading o1 = new Overloading();
        Overloading o2 = new Overloading("Raman", 101);
        o1.display();
        o2.display("Student Info");
    }
}