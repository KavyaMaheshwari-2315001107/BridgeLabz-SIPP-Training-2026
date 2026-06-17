import java.util.*;

public class cal9 {
    static String mon(int m) {
        String[] a = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        return a[m];
    }

    static int days(int m, int y) {
        int[] a = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (m == 2 && ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)) return 29;
        return a[m];
    }

    static int first(int m, int y) {
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + 31 * m0 / 12) % 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int y = sc.nextInt();
        int d = days(m, y);
        int f = first(m, y);
        System.out.println(mon(m) + " " + y);
        for (int i = 0; i < f; i++) System.out.print("   ");
        for (int i = 1; i <= d; i++) {
            System.out.printf("%3d", i);
            if ((i + f) % 7 == 0) System.out.println();
        }
    }
}