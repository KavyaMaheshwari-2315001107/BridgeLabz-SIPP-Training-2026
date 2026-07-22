public class SpaceTourismReservation {
    public static void main(String[] args) {
        SpaceTourist tourist = new SpaceTourist("Rhea", 5, "Voyager I");
        tourist.displayDetails();
        tourist.updateSeatNumber(10).updateSeatNumber(15);
        tourist.displayDetails();
        System.out.println("Total reservations: " + SpaceTourist.getTotalReservations());
    }
}

class SpaceTourist {
    private static int totalReservations = 0;
    private static String missionName;
    private String touristName;
    private int seatNumber;

    public SpaceTourist(String touristName, int seatNumber, String missionName) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        SpaceTourist.missionName = missionName;
        totalReservations++;
    }

    public SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public void displayDetails() {
        System.out.println("Tourist: " + touristName + ", Seat: " + seatNumber + ", Mission: " + missionName);
    }

    public static int getTotalReservations() {
        return totalReservations;
    }
}
