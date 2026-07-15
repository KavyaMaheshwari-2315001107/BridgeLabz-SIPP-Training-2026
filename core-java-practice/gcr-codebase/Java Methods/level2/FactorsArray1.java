import java.util.Scanner;

public class FactorsArray1 {
    static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    static int sumFactors(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }

    static long productFactors(int[] arr) {
        long product = 1;
        for (int num : arr) product *= num;
        return product;
    }

    static double sumSquareFactors(int[] arr) {
        double sum = 0;
        for (int num : arr) sum += Math.pow(num, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] factors = getFactors(n);

        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");

        System.out.println("\nSum = " + sumFactors(factors));
        System.out.println("Product = " + productFactors(factors));
        System.out.println("Sum of Squares = " + sumSquareFactors(factors));
    }
}