import java.util.Scanner;

public class ReverseNumber5 {
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

        for (int i = 0; i < count; i++) {
            System.out.print(digit[i]);
        }
    }
}