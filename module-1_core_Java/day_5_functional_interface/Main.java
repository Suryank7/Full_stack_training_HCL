package day_5_functional_interface;

public class Main{
    public static void main(String[] args){
        EmployeeManagement em = new EmployeeManagement();

        em.addEmployee(new Employee(103, "Rahul", 30000));
        em.addEmployee(new Employee(101, "Amit", 25000));
        em.addEmployee(new Employee(102, "Priya", 35000));

        System.out.println("\nAll Employees:");
        em.displayEmployees();

        System.out.println("\nUpdating Employee:");
        em.updateEmployee(101, "Amit Kumar", 28000);

        System.out.println("\nDeleting Employee:");
        em.deleteEmployee(103);

        // ITERATOR
        System.out.println("\nUsing Iterator:");
        em.traverseUsingIterator();

        System.out.println("\nUsing ListIterator:");
        em.traverseUsingListIterator();

        System.out.println("\nSorting Employees:");
        em.increasingOrder();

        System.out.println("\nSorting Employees:");
        em.decreasingOrder();
    }
}
