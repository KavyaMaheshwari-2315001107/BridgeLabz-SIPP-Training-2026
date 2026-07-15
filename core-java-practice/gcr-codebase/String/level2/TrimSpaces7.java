import java.util.Scanner;

public class TrimSpaces7 {

    static int[] trimIndex(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }

        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    static String makeSubstring(String s, int start, int end) {

        String ans = "";

        for (int i = start; i <= end; i++) {
            ans += s.charAt(i);
        }

        return ans;
    }

    static boolean compare(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int[] pos = trimIndex(text);

        String custom = makeSubstring(text, pos[0], pos[1]);
        String builtIn = text.trim();

        System.out.println("Custom Trim = " + custom);
        System.out.println("Built In Trim = " + builtIn);
        System.out.println("Same Result = " + compare(custom, builtIn));
    }
}