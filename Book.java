/**
 * Book.java
 * Entity model representing a book in the library system.
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;

    // Constructor to initialize all properties
    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Overriding toString for clean tabular / readable terminal display
    @Override
    public String toString() {
        return String.format("ISBN: %-13s | Title: %-25s | Author: %-20s | Year: %d",
                isbn, title, author, publicationYear);
    }
}