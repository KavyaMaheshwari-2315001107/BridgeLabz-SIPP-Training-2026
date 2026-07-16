import java.util.*;

public class BubbleSwapCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter Elements");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int swap = 0;

        for (int i = 0; i < n - 1; i++) {

            boolean flag = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;

                    swap++;
                    flag = true;
                }
            }

            if (!flag)
                break;
        }

        System.out.println("Sorted Array");

        for (int x : arr)
            System.out.print(x + " ");

        System.out.println("\nTotal Swaps : " + swap);
    }
}