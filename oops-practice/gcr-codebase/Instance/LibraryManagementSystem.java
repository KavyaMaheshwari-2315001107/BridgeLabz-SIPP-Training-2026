public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", "ISBN1001");
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", "ISBN1002");

        if (book1 instanceof Book) {
            book1.displayDetails();
        }
        if (book2 instanceof Book) {
            book2.displayDetails();
        }

        Book.displayLibraryName();
    }
}

class Book {
    private static String libraryName = "City Library";
    private final String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Library: " + libraryName);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
}
