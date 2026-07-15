import java.util.*;

public class ana8 {
    static boolean chk(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] f1 = new int[256];
        int[] f2 = new int[256];
        for (int i = 0; i < a.length(); i++) {
            f1[a.charAt(i)]++;
            f2[b.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (f1[i] != f2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.print(chk(a, b));
    }
}