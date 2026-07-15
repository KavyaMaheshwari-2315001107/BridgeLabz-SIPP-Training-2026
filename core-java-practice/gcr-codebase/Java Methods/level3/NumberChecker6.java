import java.util.Scanner;

public class NumberChecker6 {

    public static int sumProperDivisors(int number) {
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static boolean isPerfect(int number) {
        return sumProperDivisors(number) == number;
    }

    public static boolean isAbundant(int number) {
        return sumProperDivisors(number) > number;
    }

    public static boolean isDeficient(int number) {
        return sumProperDivisors(number) < number;
    }

    public static int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static boolean isStrong(int number) {

        int temp = number;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        return sum == number;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = sc.nextInt();

        System.out.println("Perfect Number = " + isPerfect(number));
        System.out.println("Abundant Number = " + isAbundant(number));
        System.out.println("Deficient Number = " + isDeficient(number));
        System.out.println("Strong Number = " + isStrong(number));
    }
}