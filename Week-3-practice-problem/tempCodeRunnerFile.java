 class Student { 
// TODO: Define private instance variables: 
// - studentId (String) 
private String studentId;
// - name (String) 
private String name;
// - grade (double) 
private double grade;
// - course (String) 
private String course;
// TODO: Create a default constructor (no parameters) 
    Student() {
       studentId = "930";
        name = "Arpit";
        grade = 85.5;
        course = "CSE";
    }
// TODO: Create a parameterized constructor that accepts all attributes // TODO: Create getter and setter methods for all attributes 
Student(String studentId, String name, double grade, String course) {
    this.studentId = studentId;
    this.name = name;
    this.grade = grade;
    this.course = course;
}
// TODO: Create a method calculateLetterGrade() that returns: // A (90-100), B (80-89), C (70-79), D (60-69), F (below 60)
void calculateLetterGrade() {
    if(grade >= 90) System.err.println("A");
    else if(grade >= 80) System.err.println("B");
    else if(grade >= 70) System.err.println("C");
    else if(grade >= 60) System.err.println("D");
    else System.err.println("F");
}
// TODO: Create a method displayStudent() that shows all information 
void displayStudent() {
    System.out.println("Student ID: " + studentId);
    System.out.println("Name: " + name);
    System.out.println("Grade: " + grade);
    System.out.println("Course: " + course);
}


}
public class Q2 {
public static void main(String[] args) { 
// TODO: Create one student using default constructor, then set values 
Student student1 = new Student();
//student1.studentId = "930";
//student1.name = "Arpit";
//student1.grade = 85.5;
//student1.course="CSE";
// TODO: Create another student using parameterized constructor // TODO: Demonstrate all getter/setter methods 
Student student2=new Student("931","Yatindra",92.5,"CSE");
// TODO: Show both students' information and letter grades } 
student1.calculateLetterGrade();
student2.calculateLetterGrade();
student1.displayStudent();
student2.displayStudent();
}
}
