import java.util.Scanner;

public class LargestDigitDynamic4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();

        int maxDigit = 10;
        int[] digit = new int[maxDigit];
        int idx = 0;

        while (num != 0) {
            if (idx == maxDigit) {
                maxDigit += 10;

                int[] temp = new int[maxDigit];

                for (int i = 0; i < digit.length; i++) {
                    temp[i] = digit[i];
                }

                digit = temp;
            }

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