public class ShoppingCartDemo {
    public static void main(String[] args) {
        CartItem item = new CartItem("Chocolate", 45.0, 3);
        item.displayItemDetails();
        item.addItem(2);
        item.removeItem(1);
        System.out.println("Final total cost: " + item.calculateTotalCost());
    }
}

class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addItem(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("Added " + amount + " items. Quantity is now " + quantity);
        }
    }

    public void removeItem(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            System.out.println("Removed " + amount + " items. Quantity is now " + quantity);
        } else {
            System.out.println("Cannot remove " + amount + " items. Current quantity: " + quantity);
        }
    }

    public double calculateTotalCost() {
        return price * quantity;
    }

    public void displayItemDetails() {
        System.out.println("Cart Item Details:");
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
    }
}
