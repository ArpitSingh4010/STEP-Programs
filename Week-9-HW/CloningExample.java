import java.util.ArrayList;
import java.util.List;

class Book implements Cloneable {
    String title;

    Book(String title) {
        this.title = title;
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
    public String toString() {
        return title;
    }
}
class Library implements Cloneable {
    List<Book> books = new ArrayList<>();

    Library(List<Book> books) {
        this.books = books;
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    protected Library deepClone() throws CloneNotSupportedException {
        List<Book> copiedBooks = new ArrayList<>();
        for (Book b : books) {
            copiedBooks.add((Book) b.clone());
        }
        return new Library(copiedBooks);
    }
    public String toString() {
        return books.toString();
    }
}

public class CloningExample{
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Java"));
        bookList.add(new Book("Python"));
        bookList.add(new Book("C++"));

        Library originalLibrary = new Library(bookList);
        Library shallowLibrary = (Library) originalLibrary.clone();
        Library deepLibrary = originalLibrary.deepClone();

        shallowLibrary.books.get(0).title = "JavaScript";
        deepLibrary.books.get(1).title = "C#";

        System.out.println("Original Library (after shallow change): " + originalLibrary);
        System.out.println("Shallow Cloned Library: " + shallowLibrary);
        System.out.println("Deep Cloned Library: " + deepLibrary);
    }
}
