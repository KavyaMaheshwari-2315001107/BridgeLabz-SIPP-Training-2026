import java.util.Scanner;

public class LargestDigit3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();

        int[] digit = new int[10];
        int idx = 0;

        while (num != 0 && idx < 10) {
            digit[idx++] = (int) (num % 10);
            num /= 10;
        }

        int largest = -1;
        int second = -1;

        for (int i = 0; i < idx; i++) {
            if (digit[i] > largest) {
                second = largest;
                largest = digit[i];
            } else if (digit[i] > second && digit[i] != largest) {
                second = digit[i];
            }
        }

        System.out.println("Largest = " + largest);
        System.out.println("Second Largest = " + second);
    }
}