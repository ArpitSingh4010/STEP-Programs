import java.util.HashSet;
import java.util.Objects;

class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student s = (Student) obj;
        return this.rollNo == s.rollNo;
    }
    public int hashCode() {
        return Objects.hash(rollNo);
    }
    public String toString() {
        return "Student Roll No: " + rollNo + ", Name: " + name;
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();

        Student s1 = new Student(1, "Ayush");
        Student s2 = new Student(2, "Arpit");
        Student s3 = new Student(1, "Ayush"); 

        students.add(s1);
        students.add(s2);
        students.add(s3); 

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
