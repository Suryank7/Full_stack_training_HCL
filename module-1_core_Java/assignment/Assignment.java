package assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Assignment {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(100, "Rahul", Role.MANAGER,
                50000, 6000, 2500, 4000));

        employees.add(new Employee(101, "Priya", Role.ADMIN,
                45000, 5000, 2000, 3000));

        employees.add(new Employee(102, "Aman", Role.ENGINEER,
                48000, 7000, 2500, 3500));

        employees.add(new Employee(103, "Neha", Role.ACCOUNTANT,
                40000, 4500, 1800, 2500));

        employees.add(new Employee(104, "Rohan", Role.MANAGER,
                52000, 6500, 3000, 4000));

        employees.add(new Employee(105, "Kavita", Role.ENGINEER,
                45000, 6000, 2200, 3000));

        employees.add(new Employee(106, "Arjun", Role.ADMIN,
                50000, 5500, 2500, 3500));

        employees.add(new Employee(107, "Simran", Role.ACCOUNTANT,
                42000, 5000, 2000, 2800));

        employees.sort(
                Comparator.comparingLong(Employee::calculateBonus).reversed()
        );

        System.out.println("Employees sorted by bonus (descending):");

        employees.forEach(System.out::println);
    }
}
