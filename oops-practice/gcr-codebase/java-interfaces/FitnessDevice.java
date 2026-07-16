import java.util.ArrayList;
import java.util.List;

interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("All tracking data has been reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

public class FitnessDevice implements Trackable, Reportable, Notifiable {
    private final List<String> activities = new ArrayList<>();

    @Override
    public void logActivity() {
        activities.add("Morning run: 5 km");
        activities.add("Afternoon yoga: 30 min");
        activities.add("Evening walk: 4 km");
        System.out.println("Activities logged: " + activities.size());
    }

    @Override
    public void generateReport() {
        System.out.println("Fitness Report:");
        for (String activity : activities) {
            System.out.println(" - " + activity);
        }
        System.out.println("Total activities: " + activities.size());
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("Alert: " + message);
    }

    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();
        device.logActivity();
        device.generateReport();
        device.sendAlert("You have reached 10,000 steps today!");
        device.resetData();

        System.out.println();
        System.out.println("Note: Java allows implementing multiple interfaces like Trackable, Reportable, and Notifiable,");
        System.out.println("but it does not allow a class to extend more than one class at the same time.");
    }
}
