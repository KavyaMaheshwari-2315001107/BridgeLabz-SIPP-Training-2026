package level1;
import java.util.Scanner;

public class StoreNumbers4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] arr = new double[10];
        double total = 0;
        int idx = 0;

        while (true) {
            double num = sc.nextDouble();

            if (num <= 0 || idx == 10) {
                break;
            }

            arr[idx] = num;
            idx++;
        }

        for (int i = 0; i < idx; i++) {
            System.out.println(arr[i]);
            total += arr[i];
        }

        System.out.println("Sum = " + total);
    }
}