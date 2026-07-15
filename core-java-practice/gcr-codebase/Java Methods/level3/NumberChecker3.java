import java.util.Scanner;

public class NumberChecker3 {

    public static int[] digitsArray(int number) {

        int temp = number;
        int count = 0;

        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    public static int sumDigits(int[] digits) {

        int sum = 0;

        for (int digit : digits) {
            sum += digit;
        }

        return sum;
    }

    public static int sumSquares(int[] digits) {

        int sum = 0;

        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }

        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        return number % sumDigits(digits) == 0;
    }

    public static int[][] frequency(int[] digits) {

        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
        }

        for (int digit : digits) {
            freq[digit][1]++;
        }

        return freq;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = sc.nextInt();

        int[] digits = digitsArray(number);

        System.out.println("Sum Digits = " + sumDigits(digits));
        System.out.println("Sum Squares = " + sumSquares(digits));
        System.out.println("Harshad Number = " + isHarshad(number, digits));

        int[][] freq = frequency(digits);

        System.out.println("Digit Frequency");

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " -> " + freq[i][1]);
        }
    }
}