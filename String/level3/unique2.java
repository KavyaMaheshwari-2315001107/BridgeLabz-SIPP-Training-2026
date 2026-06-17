import java.util.*;

public class unique2 {
    static int len(String s) {
        int i = 0;
        try {
            while (true) {
                s.charAt(i);
                i++;
            }
        } catch (Exception e) {}
        return i;
    }

    static char[] uni(String s) {
        int n = len(s);
        char[] t = new char[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            boolean ok = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) ok = false;
            }
            if (ok) t[k++] = c;
        }
        char[] r = new char[k];
        for (int i = 0; i < k; i++) r[i] = t[i];
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] r = uni(s);
        for (char c : r) System.out.print(c + " ");
    }
}