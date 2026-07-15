import java.util.*;

public class freq5 {
    static char[] uni(String s) {
        char[] t = new char[s.length()];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean ok = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) ok = false;
            }
            if (ok) t[k++] = c;
        }
        return Arrays.copyOf(t, k);
    }

    static String[][] get(String s) {
        int[] f = new int[256];
        for (int i = 0; i < s.length(); i++) f[s.charAt(i)]++;
        char[] u = uni(s);
        String[][] r = new String[u.length][2];
        for (int i = 0; i < u.length; i++) {
            r[i][0] = String.valueOf(u[i]);
            r[i][1] = String.valueOf(f[u[i]]);
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[][] r = get(s);
        for (String[] x : r) System.out.println(x[0] + " " + x[1]);
    }
}