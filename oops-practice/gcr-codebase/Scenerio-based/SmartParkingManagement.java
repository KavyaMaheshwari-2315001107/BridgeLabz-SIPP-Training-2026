public class SmartParkingManagement {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Vehicle("KA01AB1234", "Rakesh", "Car"),
            new Vehicle("KA01CD5678", "Seema", "Bike"),
            new Vehicle("KA01EF9012", "Nitin", "Car"),
            new Vehicle("KA01GH3456", "Aarti", "Bike"),
            new Vehicle("KA01IJ7890", "Adrian", "Car"),
            new Vehicle("KA01KL1234", "Rohit", "Bike"),
            new Vehicle("KA01MN5678", "Sneha", "Car"),
            new Vehicle("KA01OP9012", "Mira", "Bike"),
            new Vehicle("KA01QR3456", "Vijay", "Car"),
            new Vehicle("KA01ST7890", "Priyanka", "Bike")
        };

        displayCars(vehicles);
        System.out.println();
        displayBikes(vehicles);
    }

    private static void displayCars(Vehicle[] vehicles) {
        System.out.println("Cars parked in the mall:");
        for (Vehicle vehicle : vehicles) {
            if ("Car" .equalsIgnoreCase(vehicle.getVehicleType())) {
                vehicle.displayInfo();
            }
        }
    }

    private static void displayBikes(Vehicle[] vehicles) {
        System.out.println("Bikes parked in the mall:");
        for (Vehicle vehicle : vehicles) {
            if ("Bike" .equalsIgnoreCase(vehicle.getVehicleType())) {
                vehicle.displayInfo();
            }
        }
    }
}

class Vehicle {
    private final String vehicleNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void displayInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Owner: " + ownerName + ", Type: " + vehicleType);
    }
}
