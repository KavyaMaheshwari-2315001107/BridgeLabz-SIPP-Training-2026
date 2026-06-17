import java.util.Scanner;

public class UpperCase9 {

    static String convert(String text) {
        String ans = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            ans += ch;
        }

        return ans;
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

        String text = sc.nextLine();

        String s1 = convert(text);
        String s2 = text.toUpperCase();

        System.out.println(compare(s1, s2));
    }
}