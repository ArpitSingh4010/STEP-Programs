// Program: Employee Payroll System with Method Overloading
import java.util.*;

class Employee {
    // a. Private variables
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;

    // For part-time employees
    private double hourlyRate;
    private int hoursWorked;

    // For contract employees
    private double contractAmount;

    // Static variables
    private static int totalEmployees = 0;
    private static int empCounter = 1;

    // b. Constructors
    // Full-time employee
    public Employee(String name, String dept, double baseSalary) {
        this.empId = generateEmpId();
        this.empName = name;
        this.department = dept;
        this.baseSalary = baseSalary;
        this.empType = "Full-Time";
        totalEmployees++;
    }

    // Part-time employee
    public Employee(String name, String dept, double hourlyRate, int hoursWorked) {
        this.empId = generateEmpId();
        this.empName = name;
        this.department = dept;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.empType = "Part-Time";
        totalEmployees++;
    }

    // Contract employee (distinguished by boolean flag)
    public Employee(String name, String dept, double contractAmount, boolean isContract) {
        this.empId = generateEmpId();
        this.empName = name;
        this.department = dept;
        this.contractAmount = contractAmount;
        this.empType = "Contract";
        totalEmployees++;
    }

    // c. Overloaded calculateSalary()
    public double calculateSalary(double bonus) { // Full-time
        return baseSalary + bonus;
    }

    public double calculateSalary() { // Part-time
        return hourlyRate * hoursWorked;
    }

    public double calculateSalary(boolean contract) { // Contract
        return contractAmount;
    }

    // d. Overloaded calculateTax()
    public double calculateTax(double salary) { // Full-time tax = 20%
        if (empType.equals("Full-Time")) {
            return salary * 0.20;
        }
        return 0.0;
    }

    public double calculateTax() { // Part-time tax = 10%
        if (empType.equals("Part-Time")) {
            return calculateSalary() * 0.10;
        }
        return 0.0;
    }

    public double calculateTax(boolean contract) { // Contract tax = 5%
        if (empType.equals("Contract")) {
            return calculateSalary(true) * 0.05;
        }
        return 0.0;
    }

    // e. Methods
    public void generatePaySlip(double bonus) { // Full-time
        double salary = calculateSalary(bonus);
        double tax = calculateTax(salary);
        System.out.println("\n--- Pay Slip (Full-Time) ---");
        displayEmployeeInfo();
        System.out.println("Salary: " + salary);
        System.out.println("Tax: " + tax);
        System.out.println("Net Pay: " + (salary - tax));
    }

    public void generatePaySlip() { // Part-time
        double salary = calculateSalary();
        double tax = calculateTax();
        System.out.println("\n--- Pay Slip (Part-Time) ---");
        displayEmployeeInfo();
        System.out.println("Salary: " + salary);
        System.out.println("Tax: " + tax);
        System.out.println("Net Pay: " + (salary - tax));
    }

    public void generatePaySlip(boolean contract) { // Contract
        double salary = calculateSalary(true);
        double tax = calculateTax(true);
        System.out.println("\n--- Pay Slip (Contract) ---");
        displayEmployeeInfo();
        System.out.println("Salary: " + salary);
        System.out.println("Tax: " + tax);
        System.out.println("Net Pay: " + (salary - tax));
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name       : " + empName);
        System.out.println("Department : " + department);
        System.out.println("Type       : " + empType);
    }

    // f. Static methods
    private static String generateEmpId() {
        return "EMP" + String.format("%03d", empCounter++);
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public static void generatePayrollReport(Employee[] employees) {
        System.out.println("\n--- Company Payroll Report ---");
        for (Employee e : employees) {
            if (e != null) {
                if (e.empType.equals("Full-Time")) {
                    e.generatePaySlip(5000); // assume fixed bonus
                } else if (e.empType.equals("Part-Time")) {
                    e.generatePaySlip();
                } else if (e.empType.equals("Contract")) {
                    e.generatePaySlip(true);
                }
            }
        }
        System.out.println("\nTotal Employees: " + getTotalEmployees());
    }
}

public class Q3 {
    public static void main(String[] args) {
        // g. Create employees
    Employee e1 = new Employee("Alice", "IT", 50000); // Full-time
    Employee e2 = new Employee("Bob", "HR", 200, 80); // Part-time
    Employee e3 = new Employee("Charlie", "Finance", 60000.0, true); // Contract

        // Put into array
        Employee[] employees = {e1, e2, e3};

        // Demonstrate method overloading
        e1.generatePaySlip(5000);   // Full-time with bonus
        e2.generatePaySlip();       // Part-time
        e3.generatePaySlip(true);   // Contract

        // Company-wide report
        Employee.generatePayrollReport(employees);
    }
}
