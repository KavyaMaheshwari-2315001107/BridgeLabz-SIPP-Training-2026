import java.util.Scanner;

public class NumberChecker4 {

    public static int[] digitsArray(int number) {

        String str = String.valueOf(number);
        int[] digits = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }

        return digits;
    }

    public static int[] reverseArray(int[] arr) {

        int[] rev = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }

        return rev;
    }

    public static boolean compareArrays(int[] a, int[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {

            if (a[i] != b[i])
                return false;
        }

        return true;
    }

    public static boolean isPalindrome(int number) {

        int[] digits = digitsArray(number);
        int[] reverse = reverseArray(digits);

        return compareArrays(digits, reverse);
    }

    public static boolean isDuckNumber(int[] digits) {

        for (int digit : digits) {
            if (digit == 0)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = sc.nextInt();

        int[] digits = digitsArray(number);

        System.out.println("Palindrome = " + isPalindrome(number));
        System.out.println("Duck Number = " + isDuckNumber(digits));
    }
}