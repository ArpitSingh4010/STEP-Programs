 class Hospital {
private String name;
public class Department {
private String deptName;
// TODO: Display department info along with hospital name
public Department(String deptName) {
this.deptName = deptName;
}

public void displayInfo() {
System.out.println("Hospital: " + Hospital.this.name + ", Department: " + this.deptName);
}
}
// TODO: Method to create Department object
public Hospital(String name) {
this.name = name;
}

public Department createDepartment(String deptName) {
return new Department(deptName);
}
}
public class HospitalManagement {
public static void main(String[] args) {


// 1. Create Hospital with 2 Departments, display info
Hospital hospital = new Hospital("City Care Hospital");
Hospital.Department d1 = hospital.createDepartment("Cardiology");
Hospital.Department d2 = hospital.createDepartment("Pediatrics");

d1.displayInfo();
d2.displayInfo();
}
}