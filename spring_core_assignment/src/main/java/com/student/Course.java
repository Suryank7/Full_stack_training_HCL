package com.student;

public class Course {
    private String courseId;
    private String courseName;
    private int durationMonths;

    public Course(String courseId, String courseName, int durationMonths) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.durationMonths = durationMonths;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void displayCourseDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + durationMonths + " months");
    }
}
