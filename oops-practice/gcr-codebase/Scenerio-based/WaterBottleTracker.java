public class WaterBottleTracker {
    public static void main(String[] args) {
        WaterBottle bottle1 = new WaterBottle("Aanya", 3000);
        WaterBottle bottle2 = new WaterBottle("Kabir", 2500);

        bottle1.displayBottleInfo();
        bottle2.displayBottleInfo();
    }
}

class WaterBottle {
    private String ownerName;
    private int dailyTarget;

    public WaterBottle(String ownerName, int dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    public void displayBottleInfo() {
        System.out.println("Water Bottle Owner: " + ownerName);
        System.out.println("Daily Target (ml): " + dailyTarget);
    }
}
