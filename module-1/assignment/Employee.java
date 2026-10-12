package assignment;

public class Employee {
    private final int empId;
    private final String name;
    private final Role role;
    private final long basic;
    private final long hra;
    private final long ta;
    private final long specialAllowance;

    public Employee(int empId, String name, Role role,
                    long basic, long hra, long ta, long specialAllowance) {
        this.empId = empId;
        this.name = name;
        this.role = role;
        this.basic = basic;
        this.hra = hra;
        this.ta = ta;
        this.specialAllowance = specialAllowance;
    }

    public long calculateBonus() {
        return Math.round((basic + hra) * role.getBonusPercentage() / 100.0);
    }

    public long getTotalSalary() {
        return basic + hra + ta + specialAllowance;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "---------------------------------------------\n" +
                "Emp_id: " + empId + "\n" +
                "Name: " + name + "\n" +
                "Role: " + role + "\n" +
                "Basic: Rs. " + basic + "\n" +
                "HRA: Rs. " + hra + "\n" +
                "TA: Rs. " + ta + "\n" +
                "Special Allowance: Rs. " + specialAllowance + "\n" +
                "Total Salary: Rs. " + getTotalSalary() + "\n" +
                "Bonus: Rs. " + calculateBonus() + "\n" +
                "---------------------------------------------";
    }
}
