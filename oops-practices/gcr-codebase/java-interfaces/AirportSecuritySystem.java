interface LuggageScanner {
    boolean scanLuggage(String passengerName, String luggageTag);

    default void displaySecurityGuidelines() {
        System.out.println("LuggageScanner Guidelines: Report prohibited items and keep baggage within allowed weight.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z]{2}[0-9]{7}");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passengerName, String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("PassportVerifier Guidelines: Verify identity, expiration date, and travel authorization.");
    }
}

public class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    private final String[] passengers = {"Alice", "Bob", "Cathy"};
    private final String[] passportNumbers = {"AB1234567", "XY7654321", "INVALID"};
    private final String[] luggageTags = {"LUG001", "LUG002", "LUG003"};

    @Override
    public boolean scanLuggage(String passengerName, String luggageTag) {
        System.out.println("Scanning luggage for " + passengerName + " with tag " + luggageTag);
        return true;
    }

    @Override
    public boolean verifyPassport(String passengerName, String passportNo) {
        boolean valid = LuggageScanner.isPassportNumberValid(passportNo);
        System.out.println("Passport " + passportNo + " for " + passengerName + " is " + (valid ? "valid" : "invalid"));
        return valid;
    }

    @Override
    public void displaySecurityGuidelines() {
        System.out.println("Airport security guidelines:");
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public void processPassengers() {
        displaySecurityGuidelines();
        System.out.println();
        for (int i = 0; i < passengers.length; i++) {
            boolean passportOk = verifyPassport(passengers[i], passportNumbers[i]);
            boolean luggageOk = scanLuggage(passengers[i], luggageTags[i]);
            System.out.println(passengers[i] + " can " + (passportOk && luggageOk ? "board" : "not board") + " the flight.\n");
        }
    }

    public static void main(String[] args) {
        new AirportSecuritySystem().processPassengers();
    }
}
