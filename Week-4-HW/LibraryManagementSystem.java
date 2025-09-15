// Book.java
 class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean isIssued;
    private String issueDate;
    private String dueDate;

    private static int totalBooks = 0;

    public Book(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        this.issueDate = "";
        this.dueDate = "";
        totalBooks++;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }
}
// Member.java
 class Member {
    private String memberId;
    private String memberName;
    private String memberType; // Student, Faculty, General
    private Book[] booksIssued;
    private double totalFines;
    private String membershipDate;

    private static int totalMembers = 0;
    private static String libraryName = "Central Library";
    private static double finePerDay = 2.0;
    private static int maxBooksAllowed = 3;

    public Member(String memberId, String memberName, String memberType, int maxBooks, String membershipDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberType = memberType;
        this.booksIssued = new Book[maxBooks];
        this.totalFines = 0.0;
        this.membershipDate = membershipDate;
        totalMembers++;
    }

    public boolean issueBook(Book book, String issueDate, String dueDate) {
        for (int i = 0; i < booksIssued.length; i++) {
            if (booksIssued[i] == null) {
                if (!book.isIssued()) {
                    booksIssued[i] = book;
                    book.setIssued(true);
                    book.setIssueDate(issueDate);
                    book.setDueDate(dueDate);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean returnBook(String bookId, String returnDate) {
        for (int i = 0; i < booksIssued.length; i++) {
            if (booksIssued[i] != null && booksIssued[i].getBookId().equals(bookId)) {
                double fine = calculateFine(booksIssued[i].getDueDate(), returnDate);
                totalFines += fine;
                booksIssued[i].setIssued(false);
                booksIssued[i] = null;
                return true;
            }
        }
        return false;
    }

    public double calculateFine(String dueDate, String returnDate) {
        // very simple date handling: assume format "DD"
        int due = Integer.parseInt(dueDate);
        int ret = Integer.parseInt(returnDate);
        if (ret > due) {
            return (ret - due) * finePerDay;
        }
        return 0.0;
    }

    public boolean renewBook(String bookId, String newDueDate) {
        for (Book b : booksIssued) {
            if (b != null && b.getBookId().equals(bookId)) {
                b.setDueDate(newDueDate);
                return true;
            }
        }
        return false;
    }

    public boolean searchBooks(Book[] allBooks, String title) {
        for (Book b : allBooks) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + b.getTitle() + " - " + (b.isIssued() ? "Issued" : "Available"));
                return true;
            }
        }
        return false;
    }

    public boolean reserveBook(Book[] allBooks, String bookId) {
        for (Book b : allBooks) {
            if (b.getBookId().equals(bookId) && !b.isIssued()) {
                System.out.println("Book " + b.getTitle() + " reserved successfully.");
                return true;
            }
        }
        return false;
    }

    // --- Static Methods ---
    public static void generateLibraryReport(Member[] members) {
        System.out.println("Library Report - " + libraryName);
        System.out.println("Total Members: " + totalMembers);
        System.out.println("Total Books: " + Book.getTotalBooks());
        double totalFinesCollected = 0.0;
        for (Member m : members) {
            totalFinesCollected += m.totalFines;
        }
        System.out.println("Total Fines Collected: " + totalFinesCollected);
    }

    public static void getOverdueBooks(Member[] members, String currentDate) {
        System.out.println("Overdue Books:");
        int today = Integer.parseInt(currentDate);
        for (Member m : members) {
            for (Book b : m.booksIssued) {
                if (b != null) {
                    int due = Integer.parseInt(b.getDueDate());
                    if (today > due) {
                        System.out.println("Book: " + b.getTitle() + " (Member: " + m.memberName + ")");
                    }
                }
            }
        }
    }

    public static void getMostPopularBooks(Book[] books) {
        System.out.println("Most Popular Books (Issued ones):");
        for (Book b : books) {
            if (b.isIssued()) {
                System.out.println(b.getTitle());
            }
        }
    }
}
// Main.java
public class LibraryManagementSystem{
    public static void main(String[] args) {
        Book b1 = new Book("B1", "Java Basics", "Author1", "ISBN1", "Programming");
        Book b2 = new Book("B2", "C++ Guide", "Author2", "ISBN2", "Programming");
        Book b3 = new Book("B3", "Database Systems", "Author3", "ISBN3", "Databases");

        Book[] allBooks = {b1, b2, b3};

        Member m1 = new Member("M1", "Alice", "Student", 3, "01");
        Member m2 = new Member("M2", "Bob", "Faculty", 5, "01");

        m1.issueBook(b1, "01", "05");
        m2.issueBook(b2, "01", "03");

        m1.returnBook("B1", "07"); // late return, fine will apply
        m2.renewBook("B2", "10");

        m1.searchBooks(allBooks, "C++ Guide");
        m2.reserveBook(allBooks, "B3");

        Member[] allMembers = {m1, m2};

        Member.generateLibraryReport(allMembers);
        Member.getOverdueBooks(allMembers, "08");
        Member.getMostPopularBooks(allBooks);
    }
}
