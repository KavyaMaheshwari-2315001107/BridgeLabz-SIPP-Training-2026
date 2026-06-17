import java.util.*;

public class bmi1 {
    public static String[][] calc(double[][] a) {
        String[][] r = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double w = a[i][0];
            double h = a[i][1] / 100.0;
            double b = w / (h * h);
            String s;
            if (b < 18.5) s = "under";
            else if (b < 25) s = "normal";
            else if (b < 30) s = "over";
            else s = "obese";
            r[i][0] = String.valueOf(a[i][1]);
            r[i][1] = String.valueOf(w);
            r[i][2] = String.format("%.2f", b);
            r[i][3] = s;
        }
        return r;
    }

    public static void show(String[][] r) {
        System.out.println("h w bmi status");
        for (int i = 0; i < 10; i++) {
            System.out.println(r[i][0] + " " + r[i][1] + " " + r[i][2] + " " + r[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] a = new double[10][2];
        for (int i = 0; i < 10; i++) {
            a[i][0] = sc.nextDouble();
            a[i][1] = sc.nextDouble();
        }
        show(calc(a));
    }
}