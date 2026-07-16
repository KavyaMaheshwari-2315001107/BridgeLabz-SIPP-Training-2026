public class PlaylistQueue {
    public static void insertAfter(Node current, int trackId) {
        if (current == null) {
            return;
        }

        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        insertAfter(head.next, 99);
        printList(head);
    }
}
