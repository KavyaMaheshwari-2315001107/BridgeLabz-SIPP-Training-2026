import java.util.ArrayDeque;
import java.util.Deque;

public class PrintQueue {
    private final Deque<Integer> printQueue = new ArrayDeque<>();

    public void submitJob(int jobId) {
        printQueue.addLast(jobId);
    }

    public void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
    }

    public int printNextJob() {
        return printQueue.removeFirst();
    }

    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        queue.submitJob(101);
        queue.submitUrgentJob(1);
        queue.submitJob(102);
        System.out.println(queue.printNextJob());
    }
}
