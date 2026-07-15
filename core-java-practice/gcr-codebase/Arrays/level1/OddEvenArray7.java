package level1;
import java.util.Scanner;

public class OddEvenArray7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Invalid Input");
            return;
        }

        int[] odd = new int[num / 2 + 1];
        int[] even = new int[num / 2 + 1];

        int oddIdx = 0;
        int evenIdx = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                even[evenIdx++] = i;
            } else {
                odd[oddIdx++] = i;
            }
        }

        System.out.println("Odd Numbers:");
        for (int i = 0; i < oddIdx; i++) {
            System.out.print(odd[i] + " ");
        }

        System.out.println();

        System.out.println("Even Numbers:");
        for (int i = 0; i < evenIdx; i++) {
            System.out.print(even[i] + " ");
        }
    }
}