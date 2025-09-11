class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Default constructor → empty book
    public Book() {
        this("Unknown", "Unknown", "0000", true);
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this(title, author, "Not Assigned", true);
    }

    // Constructor with all details
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    // Borrow a book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    // Return a book
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println( title + " was not borrowed.");
        }
    }

    // Display book details
    public void displayBookInfo() {
        System.out.println("Book Info:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("-------------------------");
    }
}

// Main class
public class LibrarySystem{
    public static void main(String[] args) {
        // Create books using constructor overloading
        Book b1 = new Book();
        Book b2 = new Book("The Alchemist", "Paulo Coelho");
        Book b3 = new Book("1984", "George Orwell", "ISBN12345", true);

        // Borrow and return operations
        b2.borrowBook();
        b3.borrowBook();
        b3.returnBook();

        // Display all books
        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
    }
}
