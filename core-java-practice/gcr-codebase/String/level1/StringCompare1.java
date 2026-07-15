import java.util.Scanner;

public class StringCompare1 {

    static boolean check(String s1, String s2) {
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

        String s1 = sc.next();
        String s2 = sc.next();

        boolean a = check(s1, s2);
        boolean b = s1.equals(s2);

        System.out.println("Using charAt(): " + a);
        System.out.println("Using equals(): " + b);
        System.out.println("Both results same: " + (a == b));
    }
}