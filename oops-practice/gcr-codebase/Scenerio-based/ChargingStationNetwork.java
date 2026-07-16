public class ChargingStationNetwork {
    public static void main(String[] args) {
        ChargingStation station1 = new ChargingStation("CS101", 50);
        ChargingStation station2 = new ChargingStation("CS102", 120);
        ChargingStation station3 = new ChargingStation("CS103", 80);
        ChargingStation station4 = new ChargingStation("CS104", 200);
        ChargingStation station5 = new ChargingStation("CS105", 150);

        station1.displayStationDetails();
        station2.displayStationDetails();
        station3.displayStationDetails();
        station4.displayStationDetails();
        station5.displayStationDetails();

        ChargingStation.setElectricityRate(25.0);
        System.out.println("Updated electricity rate for all stations.");
        station1.calculateBill();
    }
}

class ChargingStation {
    private static int totalStations = 0;
    private static double electricityRate = 20.0;
    private final String stationId;
    private int unitsConsumed;

    public ChargingStation(String stationId, int unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public double calculateBill() {
        double bill = unitsConsumed * electricityRate;
        System.out.println("Station " + stationId + " bill: " + bill);
        return bill;
    }

    public void displayStationDetails() {
        System.out.println("Station ID: " + stationId + ", Units consumed: " + unitsConsumed + ", Rate: " + electricityRate);
    }

    public static void setElectricityRate(double newRate) {
        electricityRate = newRate;
    }
}
