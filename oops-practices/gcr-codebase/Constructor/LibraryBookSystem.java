public class LibraryBookSystem {
    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("The Silent Patient", "Alex Michaelides", 250.0, true);
        book.displayBookDetails();
        book.borrowBook();
        book.borrowBook();
    }
}

class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public LibraryBook(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have borrowed '" + title + "'.");
        } else {
            System.out.println("'" + title + "' is currently unavailable.");
        }
    }

    public void displayBookDetails() {
        System.out.println("Library Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + available);
    }
}
