public class PacketBuffer {
    private final int[] data;
    private int front;
    private int count;

    public PacketBuffer(int capacity) {
        this.data = new int[capacity];
        this.front = 0;
        this.count = 0;
    }

    public boolean enqueue(int packetId) {
        if (count == data.length) {
            return false;
        }
        data[(front + count) % data.length] = packetId;
        count++;
        return true;
    }

    public int dequeue() {
        if (count == 0) {
            throw new RuntimeException("Buffer empty");
        }
        int value = data[front];
        front = (front + 1) % data.length;
        count--;
        return value;
    }

    public static void main(String[] args) {
        PacketBuffer buffer = new PacketBuffer(3);
        buffer.enqueue(10);
        buffer.enqueue(20);
        System.out.println(buffer.dequeue());
        buffer.enqueue(30);
        System.out.println(buffer.dequeue());
    }
}
