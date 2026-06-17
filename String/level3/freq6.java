import java.util.*;

public class freq6 {
    static String[][] get(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] == '0') continue;
            f[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    f[i]++;
                    a[j] = '0';
                }
            }
        }
        int c = 0;
        for (int i = 0; i < n; i++) if (a[i] != '0') c++;
        String[][] r = new String[c][2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != '0') {
                r[k][0] = String.valueOf(a[i]);
                r[k][1] = String.valueOf(f[i]);
                k++;
            }
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