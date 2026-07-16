package generics;
import java.util.*;

abstract class Category {

    String name;

    Category(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class BookCategory extends Category {

    BookCategory(String name) {
        super(name);
    }
}

class ClothingCategory extends Category {

    ClothingCategory(String name) {
        super(name);
    }
}

class GadgetCategory extends Category {

    GadgetCategory(String name) {
        super(name);
    }
}

class Product<T extends Category> {

    int id;
    String name;
    double price;
    T category;

    Product(int id, String name, double price, T category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return "ID : " + id +
                "  Name : " + name +
                "  Price : " + price +
                "  Category : " + category;
    }
}

public class Marketplace {

    static ArrayList<Product<? extends Category>> list = new ArrayList<>();

    static <T extends Product<?>> void applyDiscount(T p, double per) {

        p.price = p.price - (p.price * per / 100);

        System.out.println("Discount Applied.");
    }

    static void display() {

        if (list.isEmpty()) {
            System.out.println("No Products.");
            return;
        }

        for (Product<?> p : list)
            System.out.println(p);
    }

    public static void main(String[] args) {

        Product<BookCategory> b =
                new Product<>(101, "Java Book", 800,
                        new BookCategory("Programming"));

        Product<ClothingCategory> c =
                new Product<>(102, "T-Shirt", 1200,
                        new ClothingCategory("Men"));

        Product<GadgetCategory> g =
                new Product<>(103, "Laptop", 65000,
                        new GadgetCategory("Electronics"));

        list.add(b);
        list.add(c);
        list.add(g);

        applyDiscount(b, 10);
        applyDiscount(c, 15);
        applyDiscount(g, 5);

        display();
    }
}