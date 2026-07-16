public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product product1 = new Product("P1001", "Coffee Mug", 250.0, 2);
        Product product2 = new Product("P1002", "Notebook", 120.0, 5);

        if (product1 instanceof Product) {
            product1.displayProductDetails();
        }
        if (product2 instanceof Product) {
            product2.displayProductDetails();
        }

        Product.updateDiscount(15);
        product1.displayProductDetails();
    }
}

class Product {
    private static int discount = 10;
    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(int newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        System.out.println("Product Details:");
        System.out.println("ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }
}
