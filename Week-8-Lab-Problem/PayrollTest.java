abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    public void showDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Base Salary: " + salary);
    }
}

interface Payable {
    void generatePaySlip();
}

class Manager extends Employee implements Payable {
    private String department;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.20; // 20% bonus for managers
    }

    @Override
    public void generatePaySlip() {
        System.out.println("Pay Slip for Manager");
        System.out.println("-------------------------");
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Base Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Total Pay: " + (salary + calculateBonus()));
    }
}

public class PayrollTest {
    public static void main(String[] args) {
        Manager mgr = new Manager("Alice Johnson", 80000, "Finance");
        mgr.showDetails();
        mgr.generatePaySlip();
    }
}
