import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BalancedBrackets {
    public static boolean isValidConfig(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matches = Map.of(')', '(', ']', '[', '}', '{');

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() != matches.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidConfig("({[]})"));
        System.out.println(isValidConfig("([)]"));
    }
}
