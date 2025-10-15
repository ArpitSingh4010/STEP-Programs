class University {
    String universityName = "SRM University";
    class Department {
        String deptName;

        Department(String deptName) {
            this.deptName = deptName;
        }

        void showDetails() {
            System.out.println("University: " + universityName);
            System.out.println("Department: " + deptName);
        }
    }
    static class ExamCell {
        static void conductExam() {
            System.out.println("ExamCell: Conducting university exams...");
        }

        void announceResults() {
            System.out.println("ExamCell: Announcing exam results...");
        }
    }
}

public class UniversityDetails{
    public static void main(String[] args) {
        University uni = new University();
        University.Department dept = uni.new Department("Computer Science");
        dept.showDetails();
        System.out.println();
        University.ExamCell.conductExam();
        University.ExamCell examCell = new University.ExamCell();
        examCell.announceResults();
    }
}
