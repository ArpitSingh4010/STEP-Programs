import java.util.HashSet;

 class Employee {
private String empCode;
private String name;
 Employee(String empCode, String name) {
this.empCode = empCode;
this.name = name;
}
// TODO: Override equals() - same empCode means same employee
@Override
public boolean equals(Object o) {
	if (this == o) return true; // same reference
	if (o == null || getClass() != o.getClass()) return false; // null or different class
	Employee employee = (Employee) o;
	// If both empCodes are null, consider them equal (same identity missing)
	if (this.empCode == null && employee.empCode == null) return true;
	// If one is null and the other isn't, not equal
	if (this.empCode == null || employee.empCode == null) return false;
	// Otherwise, compare string values
	return this.empCode.equals(employee.empCode);
}

// TODO: Override hashCode() based on empCode
@Override
public int hashCode() {
	return empCode == null ? 0 : empCode.hashCode();
}

// TODO: Write toString() showing both fields
@Override
public String toString() {
	return "Employee[empCode=" + empCode + ", name=" + name + "]";
}
}
public class EmployeeAuth {
public static void main(String[] args) {
// 1. Employee e1 = new Employee("BL001", "Ritika");
// 2. Employee e2 = new Employee("BL001", "Ritika S.");
// 3. Compare using e1 == e2 and e1.equals(e2)
// 4. Test using HashSet<Employee>
Employee e1 = new Employee("BL001", "Ritika");
Employee e2 = new Employee("BL001", "Ritika S.");

System.out.println("e1: " + e1);
System.out.println("e2: " + e2);
System.out.println("e1 == e2: " + (e1 == e2));
System.out.println("e1.equals(e2): " + e1.equals(e2));

HashSet<Employee> set = new HashSet<>();
set.add(e1);
set.add(e2);
System.out.println("HashSet size: " + set.size());
System.out.println("HashSet contents: " + set);
}
}