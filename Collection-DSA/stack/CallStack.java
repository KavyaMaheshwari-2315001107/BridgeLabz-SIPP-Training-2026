public class CallStack {
    private static class Frame {
        String functionName;
        Frame next;

        Frame(String functionName, Frame next) {
            this.functionName = functionName;
            this.next = next;
        }
    }

    private Frame top;

    public CallStack() {
        this.top = null;
    }

    public void push(String functionName) {
        top = new Frame(functionName, top);
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("No active call to return from");
        }
        String name = top.functionName;
        top = top.next;
        return name;
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("No active call to inspect");
        }
        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        CallStack stack = new CallStack();
        stack.push("main");
        stack.push("helper");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
