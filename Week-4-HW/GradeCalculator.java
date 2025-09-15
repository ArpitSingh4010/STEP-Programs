// Subject.java
class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;

    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public String getInstructor() {
        return instructor;
    }
}
// Student.java
class Student {
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks; // marks[subject][exam]
    private double gpa;

    private static int totalStudents = 0;
    private static String schoolName = "ABC School";
    private static String[] gradingScale = {"A", "B", "C", "D", "F"};
    private static double passPercentage = 40.0;

    public Student(String studentId, String studentName, String className, String[] subjects, int examsPerSubject) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.subjects = subjects;
        this.marks = new double[subjects.length][examsPerSubject];
        this.gpa = 0.0;
        totalStudents++;
    }

    public void addMarks(String subject, double mark, int examIndex) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(subject)) {
                marks[i][examIndex] = mark;
            }
        }
    }

    public void calculateGPA() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
                count++;
            }
        }
        double percentage = (total / count);
        this.gpa = percentage / 20.0; // GPA out of 5
    }

    public void generateReportCard() {
        System.out.println("Report Card - " + studentName);
        for (int i = 0; i < subjects.length; i++) {
            double total = 0;
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
            }
            double avg = total / marks[i].length;
            System.out.println(subjects[i] + ": " + avg + " (" + getGrade(avg) + ")");
        }
        System.out.println("GPA: " + gpa);
        System.out.println("Promotion Eligibility: " + (checkPromotionEligibility() ? "Yes" : "No"));
    }

    public boolean checkPromotionEligibility() {
        double total = 0;
        int count = 0;
        for (double[] subjectMarks : marks) {
            for (double m : subjectMarks) {
                total += m;
                count++;
            }
        }
        double percentage = total / count;
        return percentage >= passPercentage;
    }

    private String getGrade(double avg) {
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }

    // ---- Static Methods ----
    public static void setGradingScale(String[] scale) {
        gradingScale = scale;
    }

    public static double calculateClassAverage(Student[] students) {
        double total = 0;
        int count = 0;
        for (Student s : students) {
            for (double[] subjectMarks : s.marks) {
                for (double m : subjectMarks) {
                    total += m;
                    count++;
                }
            }
        }
        return total / count;
    }

    public static void getTopPerformers(Student[] students, int count) {
        System.out.println("Top " + count + " Performers:");
        for (int i = 0; i < students.length; i++) {
            students[i].calculateGPA();
        }
        // Simple bubble sort based on GPA
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].gpa < students[j + 1].gpa) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < count && i < students.length; i++) {
            System.out.println(students[i].studentName + " - GPA: " + students[i].gpa);
        }
    }

    public static void generateSchoolReport(Student[] students) {
        System.out.println("School Report - " + schoolName);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Class Average: " + calculateClassAverage(students));
        getTopPerformers(students, 3);
    }
}
// Main.java
public class GradeCalculator{
    public static void main(String[] args) {
        String[] subjects = {"Math", "Science", "English"};

        Student s1 = new Student("S1", "Alice", "10A", subjects, 2);
        Student s2 = new Student("S2", "Bob", "10A", subjects, 2);
        Student s3 = new Student("S3", "Charlie", "10A", subjects, 2);

        s1.addMarks("Math", 95, 0);
        s1.addMarks("Science", 88, 0);
        s1.addMarks("English", 76, 0);

        s2.addMarks("Math", 67, 0);
        s2.addMarks("Science", 70, 0);
        s2.addMarks("English", 80, 0);

        s3.addMarks("Math", 40, 0);
        s3.addMarks("Science", 45, 0);
        s3.addMarks("English", 50, 0);

        s1.calculateGPA();
        s2.calculateGPA();
        s3.calculateGPA();

        s1.generateReportCard();
        s2.generateReportCard();
        s3.generateReportCard();

        Student[] students = {s1, s2, s3};
        Student.generateSchoolReport(students);
    }
}
