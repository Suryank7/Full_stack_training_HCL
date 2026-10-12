package day_5;

import java.util.ArrayList;
import java.util.*;

//implementing comparable class in Employees
public class Employee implements Comparable<Employee> {
    //defining variables
    String name;
    Integer id;
    String department;
    String email;

    //creating constructor of the class student
    public Employee(String name, Integer id, String department, String email) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.email = email;
    }

    //implementing comparator function
    @Override
    public int compareTo(Employee other) {
        int result = Integer.compare(other.id, this.id);
        if(result != 0) {
            return result;
        }
        return 0;
    }

//    defining the array list object with initial size as 10
    static List<Employee> employee = new ArrayList<>(10);
    public static void add(Employee e) {
        //adding the data
        employee.add(e);
    }

    //traversing the employee object
    public static void traverse() {
        System.out.println("The data of the employees:");
        Iterator<Employee> iterator = employee.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //updating the employee data on the basis of employee_id
    public static void update(int id, String department) {
        for(Employee e:employee) {
            if(e.id.equals(id)) {
                e.department = department;
                System.out.println("The data is updated of" + e.id);
                return;
            }
        }
        System.out.println("No such data exist");
    }

    //deleting the existing data of the employee
    public static void delete(int id){
        if (id>=0 && id<employee.size()){
            System.out.println("The data is deleted of"+employee.remove(id));
        }
        else {
            System.out.println("Invalid Operation");
        }
    }

    public static class Task{
        //adding the data of the employees in the
        public static void main(String[] args){
            add(new Employee("Rohit", 2332, "IT", "rohit@gmail.com"));
            add(new Employee("Sachin", 3555, "SALES", "sachin@gmail.com"));
            add(new Employee("Param", 5645, "DESIGN", "param@gmail.com"));
            add(new Employee("Amit", 2323, "MAINTANENCE", "amit@gmail.com"));
            add(new Employee("Parakshit", 5676, "IT", "parakshit@gmail.com"));

            System.out.println("Before Sorting:");
            employee.forEach(System.out::println);

            System.out.println("\nIterator:");
            Iterator<Employee> iterator = employee.iterator();
//iterating the data..
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }

            //iterating forward using iterator
            System.out.println("\nList Iterator Forward:");
            ListIterator<Employee> listIterator = employee.listIterator();

            while(listIterator.hasNext()){
                System.out.println(listIterator.next());
            }

            //iterating backward using iterator
            System.out.println("\nList Iterator Backward:");
            while (listIterator.hasPrevious()){
                System.out.println(listIterator.previous());
            }

            //sorting of the data
            Collections.sort(employee);
            System.out.println("\nAscending Order:");
            employee.sort(Comparator.comparingInt(e -> e.id));
            employee.forEach(System.out::println);
            System.out.println("\nDescending Order:");
            employee.sort(Comparator.comparingInt((Employee e) -> e.id).reversed());
            employee.forEach(System.out::println);
        }
    }

    //imported from object class
    @Override
    public String toString(){
        return "Name: " + name +
                ", ID: " + id +
                ", Department: " + department +
                ", Email: " + email;
    }
}

//package day_5;
//import day4_collections.Student;
//
//import java.util.ArrayList;
//import java.util.*;
//
//public class Employee implements Comparable<Employee>{
//    String name;
//    Integer id;
//    String department;
//    String email;
//
//    public Employee(String name, Integer id, String department, String email) {
//        name = employee.name;
//        id = employee.name;
//        department = employee.name;
//        email = employee.name;
//    }
//
//    @Override
//    public int compareTo(Employee other) {
//        int result = Integer.compare(other.id, this.id);
//        if (result != 0) {
//            return result;
//        }
//    }
//
//    public static void add(){
//    name.add(name);
//    id.add(id);
//    department.add(department);
//    email.add(email);
//    }
//
//    public static void traverse(){
//        System.out.println("the data of the employees:"+employee);
//    }
//    public static void update(){
//        if(id>=0 && id<name.size()){
//            name.set(id,department);
//            System.out.println("the dat is deleted of"+employee.id);
//        }
//        else{
//            System.out.println("No such data exist");
//        }
//    }
//    public static void delete(int id){
//  if(id>=0 && id<name.size()){
//      System.out.println("the dat is deleted of"+employee.remove(id);
//  }
//  else{
//      System.out.println("Invalid Operation");
//  }
//    }
//}
//    public static class Task{
//        static void main() {
//            List<Student>employee = new ArrayList<>(10);
//
//            employee.add(new employee(name:"Rohit",id:2332,department:"IT",email:"rohit@gmail.com"));
//            employee.add(new employee(name:"Sachin",id:3555,department:"SALES",email:"sachin@gmail.com"));
//            employee.add(new employee(name:"Param",id:5645,department:"DESIGN",email:"param@gmail.com"));
//            employee.add(new employee(name:"Amit",id:2323,department:"MAINTANENCE",email:"amit@gmail.com"));
//            employee.add(new employee(name:"Parakshit",id:5676,department:"IT",email:"parakshit@gmail.com"));
//
//            System.out.println("Before Sorting:");
//            employee.forEach(System.out::println);
//            Collections.sort(employee);
//            System.out.println("After Sorting:");
//            employee.forEach(System.out::println);
//        }
//    }
//
//
//
