import java.util.*;

public class nonrep3 {
    static char find(String s) {
        int[] f = new int[256];
        for (int i = 0; i < s.length(); i++) f[s.charAt(i)]++;
        for (int i = 0; i < s.length(); i++) {
            if (f[s.charAt(i)] == 1) return s.charAt(i);
        }
        return '$';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(find(s));
    }
}