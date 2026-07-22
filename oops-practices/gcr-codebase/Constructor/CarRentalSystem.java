public class CarRentalSystem {
    public static void main(String[] args) {
        CarRental rental = new CarRental("Karan", "Honda City", 4);
        rental.displayRentalDetails();
        rental.calculateTotalCost();
    }
}

class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double totalCost;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.totalCost = calculatePrice();
    }

    private double calculatePrice() {
        double dailyRate = 1500.0;
        return dailyRate * rentalDays;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
        this.totalCost = calculatePrice();
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void displayRentalDetails() {
        System.out.println("Car Rental Details:");
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + totalCost);
    }
}
