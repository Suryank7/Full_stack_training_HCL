package com.student;

public class StudentService {
    private Student student;

    // Constructor injection: the Student object is received here.
    public StudentService(Student student) {
        this.student = student;
    }

    public void displayStudentProfile() {
        student.displayStudentDetails();
    }
}
