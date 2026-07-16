public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Rajat", "Car", "VR1001");
        Vehicle vehicle2 = new Vehicle("Meera", "Bike", "VR1002");

        if (vehicle1 instanceof Vehicle) {
            vehicle1.displayRegistrationDetails();
        }
        if (vehicle2 instanceof Vehicle) {
            vehicle2.displayRegistrationDetails();
        }

        Vehicle.updateRegistrationFee(650.0);
        Vehicle.displayRegistrationFee();
    }
}

class Vehicle {
    private static double registrationFee = 500.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void displayRegistrationFee() {
        System.out.println("Registration Fee: " + registrationFee);
    }

    public void displayRegistrationDetails() {
        System.out.println("Vehicle Registration Details:");
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }
}
