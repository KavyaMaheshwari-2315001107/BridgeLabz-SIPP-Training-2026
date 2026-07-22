public class BookConstructors {
    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book customBook = new Book("The Alchemist", "Paulo Coelho", 299.0);

        defaultBook.displayBookDetails();
        System.out.println();
        customBook.displayBookDetails();
    }
}

class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
        this("Unknown Title", "Unknown Author", 0.0);
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
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

    public void displayBookDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}
