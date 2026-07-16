import java.util.PriorityQueue;

public class PatientTriage {
    static class Patient {
        int priority;
        String name;

        Patient(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }
    }

    private final PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority);

    public void admitPatient(Patient patient) {
        triageQueue.offer(patient);
    }

    public Patient callNextPatient() {
        return triageQueue.poll();
    }

    public static void main(String[] args) {
        PatientTriage triage = new PatientTriage();
        triage.admitPatient(new Patient(5, "Asha"));
        triage.admitPatient(new Patient(1, "Ravi"));
        triage.admitPatient(new Patient(3, "Meera"));

        Patient next = triage.callNextPatient();
        System.out.println("Next patient: " + next.name + " (priority " + next.priority + ")");
    }
}
