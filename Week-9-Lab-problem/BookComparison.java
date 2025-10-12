class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author);
    }
}

public class BookComparison {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "James Gosling");
        Book book2 = new Book("Java Programming", "James Gosling");

        System.out.println("Using == : " + (book1 == book2));
        System.out.println("Using .equals() : " + book1.equals(book2));
    }
}
