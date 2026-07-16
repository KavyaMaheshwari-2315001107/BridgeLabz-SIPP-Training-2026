import java.util.*;

public class CustomerOrders {

    static void merge(int arr[], int l, int m, int r) {

        int a[] = Arrays.copyOfRange(arr, l, m + 1);
        int b[] = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;

        while (i < a.length && j < b.length) {

            if (a[i] <= b[j])
                arr[k++] = a[i++];
            else
                arr[k++] = b[j++];
        }

        while (i < a.length)
            arr[k++] = a[i++];

        while (j < b.length)
            arr[k++] = b[j++];
    }

    static void sort(int arr[], int l, int r) {

        if (l < r) {

            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        sort(arr, 0, n - 1);

        for (int x : arr)
            System.out.print(x + " ");
    }
}