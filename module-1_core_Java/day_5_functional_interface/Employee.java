package day_5_functional_interface;

import java.util.ArrayList;
import java.util.*;

//implementing comparable class in Employees
public class Employee {
    //defining variables
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name
                + ", Salary: " + salary;
    }
}