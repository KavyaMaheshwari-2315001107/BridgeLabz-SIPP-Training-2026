public class TaskQueue {
    public static Node removeTask(Node head, int taskId) {
        if (head == null) {
            return null;
        }

        if (head.value == taskId) {
            return head.next;
        }

        Node previous = head;
        Node current = head.next;

        while (current != null && current.value != taskId) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        head = removeTask(head, 20);
        printList(head);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
