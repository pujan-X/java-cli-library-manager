import java.util.Scanner;

/**
 * Main.java
 * Menu-driven command-line interface with exception handling and input validation.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryManager library = new LibraryManager();

    public static void main(String[] args) {
        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("    WELCOME TO THE LIBRARY MANAGEMENT SYSTEM      ");
        System.out.println("==================================================");

        while (isRunning) {
            printMenu();
            int choice = readIntegerInput("Enter your choice (1-5): ");

            switch (choice) {
                case 1:
                    handleAddBook();
                    break;
                case 2:
                    library.listAllBooks();
                    break;
                case 3:
                    handleUpdateBook();
                    break;
                case 4:
                    handleDeleteBook();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 5.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n----------------- MAIN MENU -----------------");
        System.out.println("1. Add New Book");
        System.out.println("2. List All Books");
        System.out.println("3. Update Book Details");
        System.out.println("4. Delete a Book");
        System.out.println("5. Exit Application");
        System.out.println("---------------------------------------------");
    }

    private static void handleAddBook() {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();

        if (isbn.isEmpty()) {
            System.out.println("Error: ISBN cannot be empty.");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();

        int year = readIntegerInput("Enter Publication Year: ");

        Book newBook = new Book(isbn, title, author, year);
        library.addBook(newBook);
    }

    private static void handleUpdateBook() {
        System.out.println("\n--- Update Book Details ---");
        System.out.print("Enter the ISBN of the book to update: ");
        String isbn = scanner.nextLine().trim();

        Book existingBook = library.findBookByIsbn(isbn);
        if (existingBook == null) {
            System.out.println("Error: No book found with ISBN: " + isbn);
            return;
        }

        System.out.println("Leave blank to keep existing value.");
        System.out.print("Enter new Title [" + existingBook.getTitle() + "]: ");
        String title = scanner.nextLine();

        System.out.print("Enter new Author [" + existingBook.getAuthor() + "]: ");
        String author = scanner.nextLine();

        System.out.print("Enter new Publication Year [" + existingBook.getPublicationYear() + "] (or 0 to keep): ");
        int year = readIntegerInput("");

        library.updateBook(isbn, title, author, year);
    }

    private static void handleDeleteBook() {
        System.out.println("\n--- Delete Book ---");
        System.out.print("Enter ISBN of the book to delete: ");
        String isbn = scanner.nextLine().trim();
        library.deleteBook(isbn);
    }

    /**
     * Helper to read integer inputs safely, preventing crashes on invalid input strings.
     */
    private static int readIntegerInput(String prompt) {
        while (true) {
            if (!prompt.isEmpty()) {
                System.out.print(prompt);
            }
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid number: ");
            }
        }
    }
}