import java.util.UUID;

interface FoodDelivery {
    void deliverFood(String customerName);

    default void trackOrder() {
        System.out.println("FoodDelivery tracking: Your food is on the way.");
    }

    static String generateDeliveryCode() {
        return "FD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}

interface GroceryDelivery {
    void deliverGrocery(String customerName);

    default void trackOrder() {
        System.out.println("GroceryDelivery tracking: Your groceries are being packed.");
    }
}

public class DeliveryExecutiveSystem implements FoodDelivery, GroceryDelivery {
    private final String[] customers = {"Grace", "Hannah", "Ian"};

    @Override
    public void deliverFood(String customerName) {
        System.out.println("Delivering food to " + customerName + ". Code: " + FoodDelivery.generateDeliveryCode());
    }

    @Override
    public void deliverGrocery(String customerName) {
        System.out.println("Delivering groceries to " + customerName + ". Code: " + FoodDelivery.generateDeliveryCode());
    }

    @Override
    public void trackOrder() {
        System.out.println("Delivery tracking summary:");
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }

    public void processDeliveries() {
        trackOrder();
        System.out.println();
        for (String customer : customers) {
            deliverFood(customer);
            deliverGrocery(customer);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new DeliveryExecutiveSystem().processDeliveries();
    }
}
