import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("You borrowed the book: " + title);
        } else {
            System.out.println("This book is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You returned the book: " + title);
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return title + " by " + author + (isBorrowed ? " (Borrowed)" : " (Available)");
    }
}

public class LibraryManagementSystem {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add a Book");
        System.out.println("2. View All Books");
        System.out.println("3. Borrow a Book");
        System.out.println("4. Return a Book");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\nList of Books:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    public void borrowBook() {
        if (books.isEmpty()) {
            System.out.println("No books in the library to borrow.");
            return;
        }
        viewBooks();
        System.out.print("Enter the number of the book to borrow: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (choice > 0 && choice <= books.size()) {
            books.get(choice - 1).borrowBook();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void returnBook() {
        if (books.isEmpty()) {
            System.out.println("No books in the library to return.");
            return;
        }
        viewBooks();
        System.out.print("Enter the number of the book to return: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (choice > 0 && choice <= books.size()) {
            books.get(choice - 1).returnBook();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.start();
    }
}
