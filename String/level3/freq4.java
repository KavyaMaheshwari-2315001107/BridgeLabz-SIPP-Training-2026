import java.util.*;

public class freq4 {
    static String[][] get(String s) {
        int[] f = new int[256];
        for (int i = 0; i < s.length(); i++) f[s.charAt(i)]++;
        String[][] r = new String[s.length()][2];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (f[c] > 0) {
                r[k][0] = String.valueOf(c);
                r[k][1] = String.valueOf(f[c]);
                f[c] = 0;
                k++;
            }
        }
        return Arrays.copyOf(r, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[][] r = get(s);
        for (String[] x : r) System.out.println(x[0] + " " + x[1]);
    }
}