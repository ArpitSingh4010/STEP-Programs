import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

// JavaBean-compliant Employee class
public class EmployeeBean implements Serializable {

    // Private fields as per JavaBean standard
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private LocalDate hireDate;
    private boolean active;

    // No-argument constructor (required by JavaBeans)
    public EmployeeBean() {
        this.employeeId = "";
        this.firstName = "";
        this.lastName = "";
        this.salary = 0.0;
        this.department = "";
        this.hireDate = LocalDate.now();
        this.active = true;
    }

    // Parameterized constructor for convenience
    public EmployeeBean(String employeeId, String firstName, String lastName,
                        double salary, String department, LocalDate hireDate, boolean active) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        setSalary(salary); // apply validation
        this.department = department;
        this.hireDate = hireDate;
        this.active = active;
    }

    // Standard JavaBean getter methods
    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public LocalDate getHireDate() { return hireDate; }
    public boolean isActive() { return active; }

    // Standard JavaBean setter methods with validation where appropriate
    public void setEmployeeId(String employeeId) {
        if (employeeId != null && !employeeId.trim().isEmpty()) {
            this.employeeId = employeeId;
        } else {
            System.out.println("Invalid Employee ID");
        }
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName.trim();
        } else {
            System.out.println("Invalid First Name");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName.trim();
        } else {
            System.out.println("Invalid Last Name");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be positive");
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHireDate(LocalDate hireDate) {
        if (hireDate != null && !hireDate.isAfter(LocalDate.now())) {
            this.hireDate = hireDate;
        } else {
            System.out.println("Invalid Hire Date");
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Computed property: full name derived from first and last name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Computed property: number of years since hire date
    public int getYearsOfService() {
        return Period.between(hireDate, LocalDate.now()).getYears();
    }

    // Computed property: formatted salary with currency symbol
    public String getFormattedSalary() {
        return NumberFormat.getCurrencyInstance().format(salary);
    }

    // Derived setter: allows setting first and last name together
    public void setFullName(String fullName) {
        if (fullName != null && fullName.trim().contains(" ")) {
            String[] parts = fullName.trim().split(" ", 2);
            this.firstName = parts[0];
            this.lastName = parts[1];
        } else {
            System.out.println("Full Name must contain both first and last name");
        }
    }

    // Override toString() to display object details
    @Override
    public String toString() {
        return String.format("Employee[id=%s, name=%s, dept=%s, salary=%s, hired=%s, active=%s]",
                employeeId, getFullName(), department, getFormattedSalary(), hireDate, active);
    }

    // Equality based on employeeId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EmployeeBean)) return false;
        EmployeeBean e = (EmployeeBean) obj;
        return Objects.equals(employeeId, e.employeeId);
    }

    // HashCode consistent with equals
    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create EmployeeBean using default constructor and setters
        EmployeeBean emp1 = new EmployeeBean();
        emp1.setEmployeeId("E001");
        emp1.setFullName("Arpit Singh");
        emp1.setDepartment("IT");
        emp1.setSalary(60000);
        emp1.setHireDate(LocalDate.of(2020, 5, 15));
        emp1.setActive(true);

        // Create EmployeeBean using parameterized constructor
        EmployeeBean emp2 = new EmployeeBean("E002", "John", "Doe", 75000,
                "Finance", LocalDate.of(2018, 3, 10), true);

        // Demonstrating getters and computed properties
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println("Years of Service (emp1): " + emp1.getYearsOfService());
        System.out.println("Formatted Salary (emp2): " + emp2.getFormattedSalary());

        // Test validation
        emp1.setSalary(-5000); // invalid
        emp1.setFullName("SingleName"); // invalid

        // Create a list of employees
        List<EmployeeBean> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(new EmployeeBean("E003", "Alice", "Brown", 50000,
                "HR", LocalDate.of(2021, 7, 1), false));

        // Sorting employees by salary
        employees.sort(Comparator.comparingDouble(EmployeeBean::getSalary));
        System.out.println("\nEmployees sorted by salary:");
        employees.forEach(System.out::println);

        // Filtering only active employees
        System.out.println("\nActive Employees:");
        employees.stream().filter(EmployeeBean::isActive).forEach(System.out::println);

        // Using reflection-based utility class
        System.out.println("\nJavaBean Properties of emp1:");
        JavaBeanProcessor.printAllProperties(emp1);

        // Copy properties from one bean to another
        EmployeeBean empCopy = new EmployeeBean();
        JavaBeanProcessor.copyProperties(emp2, empCopy);
        System.out.println("\nCopied Employee: " + empCopy);
    }
}

// Utility class for JavaBean processing
class JavaBeanProcessor {

    // Prints all properties of an EmployeeBean using reflection
    public static void printAllProperties(EmployeeBean emp) {
        try {
            Arrays.stream(EmployeeBean.class.getMethods())
                    .filter(m -> m.getName().startsWith("get") || m.getName().startsWith("is"))
                    .filter(m -> m.getParameterCount() == 0)
                    .forEach(m -> {
                        try {
                            Object value = m.invoke(emp);
                            String propName = m.getName().replaceFirst("get|is", "");
                            System.out.println(propName + " = " + value);
                        } catch (Exception ignored) {}
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Copies properties from source to target using reflection
    public static void copyProperties(EmployeeBean source, EmployeeBean target) {
        try {
            Arrays.stream(EmployeeBean.class.getMethods())
                    .filter(m -> m.getName().startsWith("get") || m.getName().startsWith("is"))
                    .filter(m -> m.getParameterCount() == 0)
                    .forEach(getter -> {
                        try {
                            String setterName = getter.getName().replaceFirst("get|is", "set");
                            Object value = getter.invoke(source);
                            try {
                                EmployeeBean.class
                                        .getMethod(setterName, getter.getReturnType())
                                        .invoke(target, value);
                            } catch (NoSuchMethodException ignored) {
                            }
                        } catch (Exception ignored) {}
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
