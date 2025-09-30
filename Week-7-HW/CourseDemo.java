class Course {
    String title;
    String instructor;
    String enrollmentDate;

    Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    void displayProgress() {
        System.out.println("Course Progress: Generic (no specific data).");
    }
}

class VideoCourse extends Course {
    int completionPercentage;
    int watchTime;

    VideoCourse(String title, String instructor, String enrollmentDate,int completionPercentage, int watchTime) {
        super(title, instructor, enrollmentDate);
        this.completionPercentage = completionPercentage;
        this.watchTime = watchTime;
    }

    void displayProgress() {
        System.out.println("Video Course: " + title);
        System.out.println("Instructor: " + instructor + " | Enrolled: " + enrollmentDate);
        System.out.println("Completion: " + completionPercentage + "%");
        System.out.println("Watch Time: " + watchTime + " mins\n");
    }
}

class InteractiveCourse extends Course {
    int quizScore;
    int projectsCompleted;

    InteractiveCourse(String title, String instructor, String enrollmentDate,int quizScore, int projectsCompleted) {
        super(title, instructor, enrollmentDate);
        this.quizScore = quizScore;
        this.projectsCompleted = projectsCompleted;
    }

    void displayProgress() {
        System.out.println("Interactive Course: " + title);
        System.out.println("Instructor: " + instructor + " | Enrolled: " + enrollmentDate);
        System.out.println("Quiz Score: " + quizScore + "%");
        System.out.println("Projects Completed: " + projectsCompleted + "\n");
    }
}

class ReadingCourse extends Course {
    int pagesRead;
    int notesTaken;

    ReadingCourse(String title, String instructor, String enrollmentDate,int pagesRead, int notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }

    void displayProgress() {
        System.out.println("Reading Course: " + title);
        System.out.println("Instructor: " + instructor + " | Enrolled: " + enrollmentDate);
        System.out.println("Pages Read: " + pagesRead);
        System.out.println("Notes Taken: " + notesTaken + "\n");
    }
}

class CertificationCourse extends Course {
    int examAttempts;
    boolean certified;

    CertificationCourse(String title, String instructor, String enrollmentDate,int examAttempts, boolean certified) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.certified = certified;
    }

    void displayProgress() {
        System.out.println("Certification Course: " + title);
        System.out.println("Instructor: " + instructor + " | Enrolled: " + enrollmentDate);
        System.out.println("Exam Attempts: " + examAttempts);
        System.out.println("Certified: " + (certified ? "Yes" : "No") + "\n");
    }
}

public class CourseDemo {
    public static void main(String[] args) {
        Course c1 = new VideoCourse("Java Basics", "Alice", "2025-01-15", 70, 180);
        Course c2 = new InteractiveCourse("Python Projects", "Bob", "2025-02-01", 85, 3);
        Course c3 = new ReadingCourse("Algorithms", "Charlie", "2025-01-20", 120, 15);
        Course c4 = new CertificationCourse("AWS Cloud", "Diana", "2025-03-01", 2, true);

        c1.displayProgress();
        c2.displayProgress();
        c3.displayProgress();
        c4.displayProgress();
    }
}
