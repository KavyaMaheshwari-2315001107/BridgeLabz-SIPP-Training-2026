import java.util.Stack;

public class MyQueueWithStacks {
    private final Stack<Integer> input = new Stack<>();
    private final Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        moveInputToOutput();
        return output.pop();
    }

    public int peek() {
        moveInputToOutput();
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void moveInputToOutput() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueueWithStacks queue = new MyQueueWithStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Empty: " + queue.empty());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Empty after all pops: " + queue.empty());
    }
}
