import java.util.ArrayList;
import java.util.List;

/**
 * LibraryManager.java
 * Handles core business logic and in-memory CRUD operations using Java Collections.
 */
public class LibraryManager {
    // In-memory data store using an ArrayList collection
    private final List<Book> books;

    public LibraryManager() {
        this.books = new ArrayList<>();
    }

    /**
     * CREATE: Adds a new book to the library inventory.
     * Validates that duplicate ISBNs are not allowed.
     */
    public boolean addBook(Book newBook) {
        if (findBookByIsbn(newBook.getIsbn()) != null) {
            System.out.println("Error: A book with ISBN " + newBook.getIsbn() + " already exists.");
            return false;
        }
        books.add(newBook);
        System.out.println("Success: Book added successfully.");
        return true;
    }

    /**
     * READ: Displays all books currently in the collection.
     */
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the inventory.");
            return;
        }
        System.out.println("\n--- Current Library Inventory ---");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("Total Books: " + books.size() + "\n");
    }

    /**
     * Helper Method: Finds a book by its unique ISBN.
     */
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn.trim())) {
                return book;
            }
        }
        return null;
    }

    /**
     * UPDATE: Updates existing book details by ISBN.
     */
    public boolean updateBook(String isbn, String newTitle, String newAuthor, int newYear) {
        Book existingBook = findBookByIsbn(isbn);
        if (existingBook == null) {
            System.out.println("Error: Book with ISBN " + isbn + " not found.");
            return false;
        }

        // Update fields if non-empty values are provided
        if (!newTitle.trim().isEmpty()) {
            existingBook.setTitle(newTitle);
        }
        if (!newAuthor.trim().isEmpty()) {
            existingBook.setAuthor(newAuthor);
        }
        if (newYear > 0) {
            existingBook.setPublicationYear(newYear);
        }

        System.out.println("Success: Book details updated successfully.");
        return true;
    }

    /**
     * DELETE: Removes a book from the inventory by ISBN.
     */
    public boolean deleteBook(String isbn) {
        Book bookToDelete = findBookByIsbn(isbn);
        if (bookToDelete == null) {
            System.out.println("Error: Book with ISBN " + isbn + " not found.");
            return false;
        }
        books.remove(bookToDelete);
        System.out.println("Success: Book removed from inventory.");
        return true;
    }
}