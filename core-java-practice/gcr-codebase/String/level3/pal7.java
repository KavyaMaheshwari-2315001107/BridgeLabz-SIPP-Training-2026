import java.util.*;

public class pal7 {
    static boolean i(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }

    static boolean r(String s, int l, int h) {
        if (l >= h) return true;
        if (s.charAt(l) != s.charAt(h)) return false;
        return r(s, l + 1, h - 1);
    }

    static boolean a(String s) {
        char[] c = s.toCharArray();
        char[] r = new char[c.length];
        for (int i = 0; i < c.length; i++) r[i] = c[c.length - 1 - i];
        for (int i = 0; i < c.length; i++) if (c[i] != r[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(i(s));
        System.out.println(r(s, 0, s.length() - 1));
        System.out.println(a(s));
    }
}