import java.util.PriorityQueue;

public class TriageQueue {
    private static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }

    private PriorityQueue<Patient> queue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

    public void addPatient(String name, int severity) {
        queue.offer(new Patient(name, severity));
    }

    public String treatNext() {
        Patient next = queue.poll();
        return next == null ? null : next.name;
    }

    public String peekNext() {
        Patient next = queue.peek();
        return next == null ? null : next.name;
    }
}
