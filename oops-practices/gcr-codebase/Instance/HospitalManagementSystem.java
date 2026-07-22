public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient patient1 = new Patient("Asha", 401, "Fever");
        Patient patient2 = new Patient("Dev", 402, "Cough");

        if (patient1 instanceof Patient) {
            patient1.displayDetails();
        }
        if (patient2 instanceof Patient) {
            patient2.displayDetails();
        }

        Patient.getTotalPatients();
    }
}

class Patient {
    private static String hospitalName = "Carewell Hospital";
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int patientID, String ailment) {
        this.name = name;
        this.patientID = patientID;
        this.age = 0;
        this.ailment = ailment;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    public void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient Name: " + name);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Ailment: " + ailment);
    }
}
