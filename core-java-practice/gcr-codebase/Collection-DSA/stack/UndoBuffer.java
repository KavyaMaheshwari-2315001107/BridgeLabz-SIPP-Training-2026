public class UndoBuffer {
    private final String[] data;
    private int top;

    public UndoBuffer(int maxDepth) {
        this.data = new String[maxDepth];
        this.top = -1;
    }

    public boolean push(String edit) {
        if (top == data.length - 1) {
            return false;
        }
        data[++top] = edit;
        return true;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo");
        }
        return data[top--];
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to peek");
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        UndoBuffer buffer = new UndoBuffer(3);
        buffer.push("Type hello");
        buffer.push("Add name");
        System.out.println(buffer.peek());
        System.out.println(buffer.pop());
    }
}
