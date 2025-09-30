class Person {
protected String name;
protected int age;

protected String email;
Person(String name, int age, String email) {
this.name = name;
this.age = age;
this.email = email;
}
// TODO: Create 'introduce()' method that prints "Hi! I'm [name],[age] years old."
void introduce() {
// ... (implementation)
System.out.println("Hi! I'm "+name+", "+age+" years old.");
}
// TODO: Create 'getContactInfo()' that prints "Email: [email]"
void getContactInfo() {
// ... (implementation)
System.out.println("Email: "+email);
}
}
class Student extends Person {
private String studentId;
private String major;
Student(String name, int age, String email, String
studentId, String major) {
super(name, age, email);
this.studentId = studentId;
this.major = major;
}
// TODO: Create 'attendLecture()' method that prints "[name] is attending [major] lecture"
void attendLecture() {
// ... (implementation)
System.out.println(name+" is attending "+major+" lecture");
}

// TODO: Create 'submitAssignment()' that prints "Assignment submitted by [studentId]"
void submitAssignment() {
// ... (implementation)
System.out.println("Assignment submitted by "+studentId);
}
}
class Professor extends Person {
private String department;
Professor(String name, int age, String email, String department) {
super(name, age, email);
this.department = department;
}
// TODO: Create 'conductClass()' that prints "Prof. [name] is teaching [department]"
void conductClass() {
// ... (implementation)
System.out.println("Prof. "+name+" is teaching "+department);
}
}
public class UniversitySystem {
public static void main(String[] args) {
// TODO: University Registration Demo:
// 1. Create Student("Alice", 20, "alice@uni.edu", "CS2021","Computer Science")
// 2. Upcast Student to Person reference: Person p = new Student(...)
// 3. Call introduce() and getContactInfo() using Person reference
// 4. Try calling attendLecture() with Person reference - observe compile error
// 5. Access the 'name' field through Person reference
// 6. Explain why upcasting is safe but limits access to subclass-specific methods
Person p = new Student("Alice", 20, "alice@uni.edu", "CS2021","Computer Science");
p.introduce();
p.getContactInfo();

System.out.println("Accessing name via Person reference: "+p.name);



}
}