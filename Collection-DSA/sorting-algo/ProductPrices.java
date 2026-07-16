import java.util.*;

public class ProductPrices {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Products : ");
        int n = sc.nextInt();

        int price[] = new int[n];

        System.out.println("Enter Prices");

        for (int i = 0; i < n; i++)
            price[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {

            boolean swap = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (price[j] > price[j + 1]) {

                    int t = price[j];
                    price[j] = price[j + 1];
                    price[j + 1] = t;

                    swap = true;
                }
            }

            if (!swap)
                break;
        }

        System.out.println("Sorted Prices");

        for (int x : price)
            System.out.print(x + " ");
    }
}