import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeAnalytics {

    record Employee(int id, String name, String dept, BigDecimal salary,
                    LocalDate hireDate, Set<String> skills) {
    }

    static Employee createEmployee(int id, String name, String dept, int salary,
                                   String hireDate, String... skills) {
        return new Employee(id, name, dept, BigDecimal.valueOf(salary),
                LocalDate.parse(hireDate), Set.of(skills));
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            createEmployee(1, "Asha", "Engineering", 90000, "2019-03-01", "Java", "SQL"),
            createEmployee(2, "Ravi", "Engineering", 120000, "2016-07-15", "Java", "Spring", "AWS"),
            createEmployee(3, "Meera", "HR", 60000, "2020-01-10", "Recruiting"),
            createEmployee(4, "John", "Sales", 70000, "2018-11-20", "Negotiation", "CRM"),
            createEmployee(5, "Priya", "Engineering", 105000, "2021-05-05", "Java", "React"),
            createEmployee(6, "Karan", "Sales", 65000, "2022-02-14", "CRM"),
            createEmployee(7, "Sara", "HR", 62000, "2017-09-09", "Recruiting", "Payroll"),
            createEmployee(8, "Vikram", "Finance", 80000, "2015-04-30", "Excel", "SQL")
        );

        // Q1: Engineering employees sorted by salary, highest first.
        List<String> q1 = employees.stream()
                .filter(employee -> employee.dept().equals("Engineering"))
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .map(Employee::name)
                .toList();
        System.out.println("Q1: " + q1);

        // Q2: Names of the three highest-paid employees.
        List<String> q2 = employees.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .limit(3)
                .map(Employee::name)
                .toList();
        System.out.println("Q2: " + q2);

        // Q3: Employees hired before 1 January 2018, oldest first.
        List<String> q3 = employees.stream()
                .filter(employee -> employee.hireDate().isBefore(LocalDate.parse("2018-01-01")))
                .sorted(Comparator.comparing(Employee::hireDate))
                .map(employee -> employee.name() + " (" + employee.hireDate().getYear() + ")")
                .toList();
        System.out.println("Q3: " + q3);

        // Q4: Join all employee names into one string.
        String q4 = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
        System.out.println("Q4: " + q4);

        // Q5: Add all salaries using reduce.
        BigDecimal q5 = employees.stream()
                .map(Employee::salary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Q5: " + q5);

        // Q6: Check skills and salaries.
        boolean hasAws = employees.stream()
                .anyMatch(employee -> employee.skills().contains("AWS"));

        boolean allEarnMoreThan50000 = employees.stream()
                .allMatch(employee ->
                        employee.salary().compareTo(BigDecimal.valueOf(50000)) > 0);

        boolean nobodyEarnsMoreThan150000 = employees.stream()
                .noneMatch(employee ->
                        employee.salary().compareTo(BigDecimal.valueOf(150000)) > 0);

        System.out.println("Q6: " + hasAws + ", "
                + allEarnMoreThan50000 + ", " + nobodyEarnsMoreThan150000);

        // Q7: Find the highest-paid employee.
        String q7 = employees.stream()
                .max(Comparator.comparing(Employee::salary))
                .map(Employee::name)
                .orElse("none");
        System.out.println("Q7: " + q7);

        // Q8: Find the average salary in each department.
        Map<String, Double> q8 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        TreeMap::new,
                        Collectors.averagingDouble(employee ->
                                employee.salary().doubleValue())
                ));
        System.out.println("Q8: " + q8);

        // Q9: Find the highest-paid employee in each department.
        Map<String, String> q9 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::salary)),
                                result -> result.map(Employee::name).orElse("none")
                        )
                ));
        System.out.println("Q9: " + q9);

        // Q10: Split employees into two groups based on salary.
        Map<Boolean, List<Employee>> q10 = employees.stream()
                .collect(Collectors.partitioningBy(
                        employee -> employee.salary()
                                .compareTo(BigDecimal.valueOf(75000)) >= 0
                ));

        System.out.println("Q10 true: "
                + q10.get(true).stream().map(Employee::name).toList());
        System.out.println("Q10 false: "
                + q10.get(false).stream().map(Employee::name).toList());

        // Q11: Get all different skills and sort them.
        List<String> q11 = employees.stream()
                .flatMap(employee -> employee.skills().stream())
                .distinct()
                .sorted()
                .toList();
        System.out.println("Q11: " + q11);

        // Q12: Count how many employees have each skill.
        Map<String, Long> q12 = employees.stream()
                .flatMap(employee -> employee.skills().stream())
                .collect(Collectors.groupingBy(
                        skill -> skill,
                        TreeMap::new,
                        Collectors.counting()
                ));
        System.out.println("Q12 skill counts: " + q12);

        String mostCommonSkill = q12.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey() + " = " + entry.getValue())
                .orElse("none");
        System.out.println("Q12 most common: " + mostCommonSkill);

        // E1: Create a map containing employee ID and employee name.
        Map<Integer, String> idToName = employees.stream()
                .collect(Collectors.toMap(Employee::id, Employee::name));
        System.out.println("E1 ID map: " + idToName);

        // Adding a duplicate ID without a merge function causes an exception.
        List<Employee> duplicateEmployees = new ArrayList<>(employees);
        duplicateEmployees.add(createEmployee(
                1, "Asha Updated", "Engineering", 90000,
                "2019-03-01", "Java", "SQL"));

        try {
            duplicateEmployees.stream()
                    .collect(Collectors.toMap(Employee::id, Employee::name));
        } catch (IllegalStateException exception) {
            System.out.println("E1 duplicate ID: IllegalStateException");
        }

        // The merge function decides which name to keep for a duplicate ID.
        Map<Integer, String> fixedMap = duplicateEmployees.stream()
                .collect(Collectors.toMap(
                        Employee::id,
                        Employee::name,
                        (oldName, newName) -> newName
                ));
        System.out.println("E1 fixed name for ID 1: " + fixedMap.get(1));

        // E2 explanation is included in README.md.

        // E3: map does not run until a terminal operation is used.
        employees.stream()
                .map(employee -> {
                    System.out.println("Mapping " + employee.name());
                    return employee.name();
                });

        System.out.println("E3: No employee names were mapped because there was no terminal operation.");
    }
}
