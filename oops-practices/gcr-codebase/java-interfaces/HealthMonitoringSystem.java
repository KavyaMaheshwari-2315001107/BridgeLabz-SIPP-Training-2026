interface HeartRateMonitor {
    boolean checkHeartRate(String patientName, String patientId);

    default void displayHealthTips() {
        System.out.println("HeartRateMonitor Tips: Stay active and avoid excessive stress.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.matches("PAT[0-9]{4}");
    }
}

interface TemperatureMonitor {
    boolean checkTemperature(String patientName, String patientId);

    default void displayHealthTips() {
        System.out.println("TemperatureMonitor Tips: Stay hydrated and monitor fever symptoms.");
    }
}

public class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    private final String[] patientNames = {"David", "Emma", "Frank"};
    private final String[] patientIds = {"PAT0001", "PAT0002", "BADID"};
    private final int[] heartRates = {72, 88, 60};
    private final double[] temperatures = {98.4, 100.2, 99.1};

    @Override
    public boolean checkHeartRate(String patientName, String patientId) {
        boolean validId = HeartRateMonitor.isPatientIdValid(patientId);
        System.out.println(patientName + " (" + patientId + ") heart rate " + (validId ? heartRates[0] : 0));
        return validId;
    }

    @Override
    public boolean checkTemperature(String patientName, String patientId) {
        boolean validId = HeartRateMonitor.isPatientIdValid(patientId);
        System.out.println(patientName + " (" + patientId + ") temperature " + (validId ? temperatures[0] : 0.0));
        return validId;
    }

    @Override
    public void displayHealthTips() {
        System.out.println("Health monitoring tips:");
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public void reportPatients() {
        displayHealthTips();
        System.out.println();
        for (int i = 0; i < patientNames.length; i++) {
            String name = patientNames[i];
            String id = patientIds[i];
            boolean valid = HeartRateMonitor.isPatientIdValid(id);
            System.out.println(name + " (" + id + ") ID valid: " + valid);
            if (valid) {
                System.out.println(" - Heart Rate: " + heartRates[i] + " bpm");
                System.out.println(" - Temperature: " + temperatures[i] + " F");
            } else {
                System.out.println(" - Patient data invalid; cannot display readings.");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new HealthMonitoringSystem().reportPatients();
    }
}
