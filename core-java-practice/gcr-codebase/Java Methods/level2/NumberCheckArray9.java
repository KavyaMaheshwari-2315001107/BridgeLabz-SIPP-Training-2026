import java.util.Scanner;

public class NumberCheckArray9 {

    static boolean isPositive(int n) {
        return n >= 0;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static int compare(int a, int b) {
        if (a > b) return 1;
        if (a < b) return -1;
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        for (int num : arr) {
            if (isPositive(num))
                System.out.println(num + " " + (isEven(num) ? "Even" : "Odd"));
            else
                System.out.println(num + " Negative");
        }

        System.out.println(compare(arr[0], arr[4]));
    }
}