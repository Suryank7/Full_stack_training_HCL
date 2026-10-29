# Student Course Enrolment — Spring Core Day 1

## Requirements
- JDK 17 or later
- Maven
- Internet access for the first Maven dependency download

## Run in VS Code
Open this folder in VS Code. Open Terminal in the folder containing `pom.xml`, then run:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.student.MainApp"
```

If `mvn exec:java` says the exec plugin is unavailable, run:

```bash
mvn org.codehaus.mojo:exec-maven-plugin:3.5.0:java -Dexec.mainClass="com.student.MainApp"
```

## Expected output

```text
Student ID: 101
Student Name: Aditi Sharma
Course ID: C01
Course Name: Java Full Stack
Duration: 4 months
```

## Where constructor injection happens
- `Student` receives `Course` in its constructor.
- `StudentService` receives `Student` in its constructor.
- `AppConfig` declares the beans using `@Bean` methods. Spring supplies the `Course` parameter to `student(Course course)` and the `Student` parameter to `studentService(Student student)`.

## What AnnotationConfigApplicationContext does
It starts the Spring container using the Java configuration class `AppConfig`. Spring creates the configured beans and resolves their dependencies. `getBean(StudentService.class)` retrieves the service from the container. `close()` shuts down the container.

This is Spring Core, not Spring Boot. No XML configuration, field injection, or setter injection is used.
