public class LogStreamMerger {
    public static Node mergeLogStreams(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.value <= b.value) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(3);
        first.next.next = new Node(5);

        Node second = new Node(2);
        second.next = new Node(4);
        second.next.next = new Node(6);

        Node merged = mergeLogStreams(first, second);
        printList(merged);
    }
}
