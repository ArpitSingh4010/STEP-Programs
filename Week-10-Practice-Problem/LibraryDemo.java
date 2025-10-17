import java.util.*;

class Book {
    // Declare private attributes: title, author, isbn
    private String title;
    private String author;
    private String isbn;
    
    // Create a parameterized constructor to initialize all attributes
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    // Create a method to show details of the book
    public void showDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }
    
    // Create a getter method to return the book title
    public String getTitle() {
        return title;
    }
}

class Library {
    // Declare private attributes: name (String), books (List<Book>)
    private String name;
    private List<Book> books;
    
    // Create a constructor to initialize the library name and list
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book '" + book.getTitle() + "' to " + name + " Library");
    }
    
    // Display all books in the library
    public void showBooks() {
        System.out.println("Books in " + name + " Library:");
        for (Book book : books) {
            book.showDetails();
        }
    }
}

class Member {
    // Declare private attributes: name (String), borrowedBooks (List<Book>)
    private String name;
    private List<Book> borrowedBooks;
    
    // Create a constructor to initialize the member name and list
    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    
    // Borrow a book from the library
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed book: " + book.getTitle());
    }
    
    // Show all borrowed books
    public void showBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (Book book : borrowedBooks) {
            book.showDetails();
        }
    }
}
public class LibraryDemo {
    public static void main(String[] args) {
        // Step 1 - Create a Library object
        Library lib = new Library("Central City");
        
        // Step 2 - Create 3 Book objects with sample data
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        Book book3 = new Book("1984", "George Orwell", "978-0451524935");
        
        // Step 3 - Add books to library using addBook()
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        
        // Step 4 - Display all books in the library using showBooks()
        lib.showBooks();
        
        System.out.println(); // Empty line for better readability
        
        // Step 5 - Create a Member object
        Member member = new Member("Ravi");
        
        // Step 6 - Borrow 2 books using borrowBook()
        member.borrowBook(book1);
        member.borrowBook(book3);
        
        System.out.println(); // Empty line for better readability
        
        // Step 7 - Display borrowed books using showBorrowedBooks()
        member.showBorrowedBooks();
    }
}