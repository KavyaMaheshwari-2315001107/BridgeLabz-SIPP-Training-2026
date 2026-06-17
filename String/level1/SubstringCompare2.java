import java.util.Scanner;

public class SubstringCompare2 {

    static String getSubstring(String text, int start, int end) {
        String sub = "";

        for (int i = start; i < end; i++) {
            sub += text.charAt(i);
        }

        return sub;
    }

    static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String s1 = getSubstring(text, start, end);
        String s2 = text.substring(start, end);

        System.out.println("User Substring: " + s1);
        System.out.println("Built In Substring: " + s2);
        System.out.println("Same Result: " + compare(s1, s2));
    }
}