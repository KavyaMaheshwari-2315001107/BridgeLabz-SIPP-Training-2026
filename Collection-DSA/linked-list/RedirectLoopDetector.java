public class RedirectLoopDetector {
    public static boolean hasRedirectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        head.next = second;
        second.next = head;

        System.out.println("Redirect loop exists: " + hasRedirectLoop(head));
    }
}
