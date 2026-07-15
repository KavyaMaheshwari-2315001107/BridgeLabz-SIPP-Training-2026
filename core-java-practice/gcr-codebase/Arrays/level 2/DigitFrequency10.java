import java.util.Scanner;

public class DigitFrequency10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int temp = num;
        int count = 0;

        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digit = new int[count];

        temp = num;

        for (int i = 0; i < count; i++) {
            digit[i] = temp % 10;
            temp /= 10;
        }

        int[] freq = new int[10];

        for (int i = 0; i < count; i++) {
            freq[digit[i]]++;
        }

        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println(i + " -> " + freq[i]);
            }
        }
    }
}