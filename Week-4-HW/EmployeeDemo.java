// Employee.java
 abstract class Employee {
    // Required attributes
    protected String empId;
    protected String empName;
    protected String department;
    protected String designation;
    protected double baseSalary;
    protected String joinDate;
    protected boolean[] attendanceRecord;

    // Required static variables
    protected static int totalEmployees = 0;
    protected static String companyName = "Acme Corp";
    protected static double totalSalaryExpense = 0.0;
    protected static int workingDaysPerMonth = 22;

    // Simple leave counter (for leave management)
    private int leavesRequested = 0;

    public Employee(String empId, String empName, String department,
                    String designation, double baseSalary, String joinDate) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        this.attendanceRecord = new boolean[30];
        totalEmployees++;
    }

    // Required methods
    public void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= 30) {
            attendanceRecord[day - 1] = present;
        }
    }

    // Different per type → implemented by subclasses
    public abstract double calculateSalary();

    // Performance-based bonus (default rule; subclasses may override)
    public double calculateBonus() {
        int presentDays = getPresentDays();
        double attendancePct = (presentDays * 100.0) / workingDaysPerMonth;

        if (attendancePct >= 90) return baseSalary * 0.10;
        if (attendancePct >= 75) return baseSalary * 0.05;
        return 0.0;
    }

    public void generatePaySlip() {
        double salary = calculateSalary();
        double bonus = calculateBonus();
        double total = salary + bonus;

        System.out.println("----- Pay Slip -----");
        System.out.println("Company   : " + companyName);
        System.out.println("Emp ID    : " + empId);
        System.out.println("Name      : " + empName);
        System.out.println("Dept/Desg : " + department + " / " + designation);
        System.out.println("Base Pay  : " + baseSalary);
        System.out.println("Salary    : " + salary);
        System.out.println("Bonus     : " + bonus);
        System.out.println("Total Pay : " + total);
        System.out.println("--------------------");
    }

    public void requestLeave() {
        leavesRequested++;
        System.out.println(empName + " requested leave. Total leaves requested: " + leavesRequested);
    }

    // ---- Static methods (required) ----
    public static double calculateCompanyPayroll(Employee[] employees) {
        double total = 0.0;
        for (Employee e : employees) {
            if (e != null) {
                total += e.calculateSalary() + e.calculateBonus();
            }
        }
        totalSalaryExpense = total;
        System.out.println("Company Payroll (incl. bonus): " + totalSalaryExpense);
        return totalSalaryExpense;
    }

    public static void getAttendanceReport(Employee[] employees) {
        System.out.println("=== Attendance Report ===");
        for (Employee e : employees) {
            if (e != null) {
                int present = e.getPresentDays();
                double pct = (present * 100.0) / workingDaysPerMonth;
                System.out.println(e.empName + " (" + e.empId + ") - Present: " + present +
                        "/" + workingDaysPerMonth + " (" + String.format("%.1f", pct) + "%)");
            }
        }
    }

    // ---- Helpers kept internal (no extra public API) ----
    protected int getPresentDays() {
        int count = 0;
        for (int i = 0; i < workingDaysPerMonth && i < attendanceRecord.length; i++) {
            if (attendanceRecord[i]) count++;
        }
        return count;
    }
}
// FullTimeEmployee.java
 class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String empId, String empName, String department,
                            String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }

    // Monthly salary prorated by attendance
    @Override
    public double calculateSalary() {
        int presentDays = getPresentDays();
        return baseSalary * (presentDays / (double) workingDaysPerMonth);
    }

    // Full-timers get standard bonus (from base) → use default or customize slightly
    @Override
    public double calculateBonus() {
        return super.calculateBonus();
    }
}
// PartTimeEmployee.java
 class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String empId, String empName, String department,
                            String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }

    // Interpret baseSalary as "monthly if full attendance"; pay strictly per day present
    @Override
    public double calculateSalary() {
        int presentDays = getPresentDays();
        double perDay = baseSalary / workingDaysPerMonth;
        return perDay * presentDays;
    }

    // Smaller bonus for part-time
    @Override
    public double calculateBonus() {
        int presentDays = getPresentDays();
        double attendancePct = (presentDays * 100.0) / workingDaysPerMonth;
        if (attendancePct >= 90) return baseSalary * 0.05;
        if (attendancePct >= 75) return baseSalary * 0.02;
        return 0.0;
    }
}
// ContractEmployee.java
 class ContractEmployee extends Employee {
    public ContractEmployee(String empId, String empName, String department,
                            String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }

    // Fixed pay regardless of daily attendance (per contract)
    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    // Minimal/none performance bonus for contract
    @Override
    public double calculateBonus() {
        int presentDays = getPresentDays();
        double attendancePct = (presentDays * 100.0) / workingDaysPerMonth;
        return attendancePct >= 95 ? baseSalary * 0.02 : 0.0;
    }
}
// Department.java
 class Department {
    // Required attributes
    private String deptId;
    private String deptName;
    private Employee manager;
    private Employee[] employees;
    private double budget;

    public Department(String deptId, String deptName, Employee manager, int capacity, double budget) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.manager = manager;
        this.employees = new Employee[capacity];
        this.budget = budget;
        // Place manager in slot 0 (simple convention)
        if (manager != null && capacity > 0) this.employees[0] = manager;
    }

    // Add employee to array (simple placement)
    public void addEmployee(Employee e) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) { employees[i] = e; break; }
        }
    }

    // Required static method: department-wise expenses
    public static void getDepartmentWiseExpenses(Department[] depts) {
        System.out.println("=== Department-wise Expenses (Salary + Bonus) ===");
        for (Department d : depts) {
            if (d != null) {
                double total = 0.0;
                for (Employee e : d.employees) {
                    if (e != null) total += e.calculateSalary() + e.calculateBonus();
                }
                System.out.println(d.deptName + " (Budget: " + d.budget + ") -> " + total);
            }
        }
    }
}
// Main.java
public class EmployeeDemo{
    public static void main(String[] args) {
        // Company setup via static fields (already defaulted)
        // Employee.workingDaysPerMonth = 22;

        // Create employees of different types
        Employee e1 = new FullTimeEmployee("E001", "Alice", "Engineering", "SDE-1", 60000, "2024-04-15");
        Employee e2 = new PartTimeEmployee("E002", "Bob", "Engineering", "PT-Dev", 30000, "2024-06-01");
        Employee e3 = new ContractEmployee("E003", "Carol", "HR", "Recruiter-Contract", 40000, "2024-02-10");
        Employee e4 = new FullTimeEmployee("E004", "David", "HR", "HR Exec", 45000, "2023-11-20");

        // Mark attendance (simple pattern for demo)
        for (int d = 1; d <= 22; d++) {
            e1.markAttendance(d, true);                       
            e2.markAttendance(d, d % 2 == 1);                
            e3.markAttendance(d, d % 3 != 0);                
            e4.markAttendance(d, d <= 20);                  
        }

        // Leave requests (simple counter)
        e1.requestLeave();
        e2.requestLeave();

        // Departments
        Department eng = new Department("D01", "Engineering", e1, 5, 500000);
        eng.addEmployee(e2);

        Department hr = new Department("D02", "HR", e3, 5, 300000);
        hr.addEmployee(e4);

        Department[] depts = { eng, hr };
        Employee[] all = { e1, e2, e3, e4 };

        // Generate pay slips
        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();
        e4.generatePaySlip();

        // Static reports
        Employee.calculateCompanyPayroll(all);
        Department.getDepartmentWiseExpenses(depts);
        Employee.getAttendanceReport(all);
    }
}
