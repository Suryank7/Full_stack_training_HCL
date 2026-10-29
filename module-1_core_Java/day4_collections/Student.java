package day4_collections;

import java.util.ArrayList;
import java.util.*;

public class Student implements Comparable<Student>{
    String name;
    Integer rollno;
    Integer marks;
    Integer age;

    Student(String name, Integer rollno, Integer marks, Integer age){
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
        this.age = age;
    }

    //custom comparator implementation
    static class MyComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.rollno, s2.rollno);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Roll No: " + rollno +
                ", Age: " + age +
                ", Marks: " + marks;
    }

    @Override
    public int compareTo(Student other) {
        int result = Integer.compare(other.marks, this.marks);
        if (result != 0) {
            return result;
        }
        return Integer.compare(other.age, this.age);
    }

    public static class Task1{
    public static void main(String[] args) {
        List<Student>a = new ArrayList<>(10);

        a.add(new Student("raman", 1, 23, 21));
        a.add(new Student("sohail", 2, 21, 21));
        a.add(new Student("vivek", 3, 25, 21));
        a.add(new Student("ranjan", 4, 27, 21));
        a.add(new Student("ankit", 5, 22, 21));
        a.add(new Student("amit", 6, 24, 21));
        a.add(new Student("kartik", 7, 28, 21));
        a.add(new Student("ram", 8, 24, 21));
        a.add(new Student("pankaj", 9, 22, 21));
        a.add(new Student("uday", 10, 23, 21));

        System.out.println("Before Sorting:");
        a.forEach(System.out::println);
        Collections.sort(a,new MyComparator());
        System.out.println("AfterSorting:");
        a.forEach(System.out::println);
    }
    }

}
