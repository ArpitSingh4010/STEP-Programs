import java.util.HashSet;
import java.util.Objects;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class StudentHashSetExample {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();

        Student s1 = new Student(101, "Arpit");
        Student s2 = new Student(102, "Ayush");
        Student s3 = new Student(101, "Arpit"); // same id as s1

        students.add(s1);
        students.add(s2);
        students.add(s3); 

        System.out.println("HashSet contents:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
