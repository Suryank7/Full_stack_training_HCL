
package day_5_functional_interface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Comparator;

public class EmployeeManagement {

    ArrayList<Employee> employees = new ArrayList<>();

    // CREATE
    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee added successfully");
    }

    // READ
    public void displayEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    // UPDATE
    public void updateEmployee(int id, String name, double salary) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.name = name;
                e.salary = salary;
                System.out.println("Employee updated");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    // DELETE
    public void deleteEmployee(int id) {
        Iterator<Employee> it = employees.iterator();

        while (it.hasNext()) {
            Employee e = it.next();

            if (e.getId() == id) {
                it.remove();
                System.out.println("Employee deleted");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    // TRAVERSE USING ITERATOR
    public void traverseUsingIterator() {
        Iterator<Employee> it = employees.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // TRAVERSE USING LISTITERATOR (FORWARD)
    public void traverseUsingListIterator() {
        ListIterator<Employee> it = employees.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // TRAVERSE USING LISTITERATOR (BACKWARD)
    public void traverseBackward() {
        ListIterator<Employee> it =
                employees.listIterator(employees.size());

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }

    // INCREASING ORDER OF EMPLOYEE ID
    public void increasingOrder() {
        employees.sort(Comparator.comparingInt(Employee::getId));

        System.out.println("Increasing order:");
        displayEmployees();
    }

    // DECREASING ORDER OF EMPLOYEE ID
    public void decreasingOrder() {
        employees.sort(
                Comparator.comparingInt(Employee::getId).reversed()
        );

        System.out.println("Decreasing order:");
        displayEmployees();
    }
}
