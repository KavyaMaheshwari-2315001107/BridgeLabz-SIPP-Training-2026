public class DroneDeliverySystem {
    public static void main(String[] args) {
        Drone drone1 = new Drone("D001", 85);
        Drone drone2 = new Drone("D002", 90);
        Drone drone3 = new Drone("D003", 78);

        drone1.startDelivery();
        drone2.displayStatus();
        drone3.displayStatus();

        System.out.println("All drones operate for " + Drone.getCompanyName());
    }
}

class Drone {
    private final String droneId;
    private int batteryPercentage;
    private static String companyName = "SkyShip Logistics";

    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        System.out.println("Drone " + droneId + " is starting delivery. Battery at " + batteryPercentage + "%.");
    }

    public void displayStatus() {
        System.out.println("Drone " + droneId + " status: battery " + batteryPercentage + "%.");
    }

    public static String getCompanyName() {
        return companyName;
    }
}
