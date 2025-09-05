// Program: Library Book Management System
import java.util.Scanner;

class Book {
    // a. Private variables
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    // Static variables
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int bookCounter = 1;

    // b. Constructor
    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    // Methods
    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId + ", Title: " + title +
                ", Author: " + author + ", Status: " + (isAvailable ? "Available" : "Issued"));
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // e. Static methods
    private static String generateBookId() {
        return "B" + String.format("%03d", bookCounter++);
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}

class Member {
    // c. Private variables
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;

    // Static counter
    private static int memberCounter = 1;

    // Constructor
    public Member(String name, int maxBooks) {
        this.memberId = generateMemberId();
        this.memberName = name;
        this.booksIssued = new String[maxBooks];
        this.bookCount = 0;
    }

    // d. Methods
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            if (bookCount < booksIssued.length) {
                if (book.issueBook()) {
                    booksIssued[bookCount++] = book.getBookId();
                    System.out.println(memberName + " borrowed book: " + book.getBookId());
                }
            } else {
                System.out.println(memberName + " cannot borrow more books (limit reached).");
            }
        } else {
            System.out.println("Book " + book.getBookId() + " is not available.");
        }
    }

    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                // Find book in library
                for (Book b : books) {
                    if (b != null && b.getBookId().equals(bookId)) {
                        b.returnBook();
                        System.out.println(memberName + " returned book: " + bookId);
                        break;
                    }
                }
                // Shift issued books array
                for (int j = i; j < bookCount - 1; j++) {
                    booksIssued[j] = booksIssued[j + 1];
                }
                booksIssued[--bookCount] = null;
                return;
            }
        }
        System.out.println(memberName + " does not have book: " + bookId);
    }

    public void displayMemberInfo() {
        System.out.print("Member ID: " + memberId + ", Name: " + memberName + ", Books Issued: ");
        if (bookCount == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < bookCount; i++) {
                System.out.print(booksIssued[i] + " ");
            }
            System.out.println();
        }
    }

    // e. Static method
    private static String generateMemberId() {
        return "M" + String.format("%03d", memberCounter++);
    }
}

public class Q2{
    public static void main(String[] args) {
        // f. Arrays of Book and Member
        Book[] books = new Book[5];
        books[0] = new Book("Java Programming", "James Gosling");
        books[1] = new Book("C++ Basics", "Bjarne Stroustrup");
        books[2] = new Book("Python Fundamentals", "Guido van Rossum");
        books[3] = new Book("Operating Systems", "Silberschatz");
        books[4] = new Book("Database Systems", "C.J. Date");

        Member[] members = new Member[2];
        members[0] = new Member("Alice", 3);
        members[1] = new Member("Bob", 2);

        // Display initial library status
        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            b.displayBookInfo();
        }

        // Members borrow books
        System.out.println("\n--- Borrowing Books ---");
        members[0].borrowBook(books[0]); // Alice borrows Java
        members[0].borrowBook(books[1]); // Alice borrows C++
        members[1].borrowBook(books[0]); // Bob tries Java (not available)
        members[1].borrowBook(books[2]); // Bob borrows Python

        // Display member info
        System.out.println("\n--- Members ---");
        for (Member m : members) {
            m.displayMemberInfo();
        }

        // Members return books
        System.out.println("\n--- Returning Books ---");
        members[0].returnBook("B001", books); // Alice returns Java
        members[1].returnBook("B002", books); // Bob tries returning book he doesn't have

        // Display final status
        System.out.println("\n--- Library Books After Transactions ---");
        for (Book b : books) {
            b.displayBookInfo();
        }

        System.out.println("\nTotal Books: " + Book.getTotalBooks() +
                ", Available Books: " + Book.getAvailableBooks());
    }
}
