import java.util.*;

public class deck {
    static String[] init() {
        String[] s = {"Hearts","Diamonds","Clubs","Spades"};
        String[] r = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        String[] d = new String[52];
        int k = 0;
        for (String a : s) {
            for (String b : r) {
                d[k++] = b + " of " + a;
            }
        }
        return d;
    }

    static void shuf(String[] d) {
        for (int i = 0; i < d.length; i++) {
            int j = i + (int)(Math.random() * (d.length - i));
            String t = d[i];
            d[i] = d[j];
            d[j] = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int c = sc.nextInt();
        String[] d = init();
        shuf(d);
        String[][] pl = new String[p][c];
        int k = 0;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < c; j++) {
                pl[i][j] = d[k++];
            }
        }
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(pl[i][j] + " ");
            }
            System.out.println();
        }
    }
}