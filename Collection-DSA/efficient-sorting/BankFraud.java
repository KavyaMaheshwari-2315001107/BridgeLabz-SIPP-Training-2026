import java.util.*;

public class BankFraud {

    static long ans = 0;

    static void merge(int arr[], int l, int m, int r) {

        int j = m + 1;

        for (int i = l; i <= m; i++) {

            while (j <= r && arr[i] > 3L * arr[j])
                j++;

            ans += j - (m + 1);
        }

        int temp[] = new int[r - l + 1];

        int i = l;
        j = m + 1;
        int k = 0;

        while (i <= m && j <= r) {

            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= m)
            temp[k++] = arr[i++];

        while (j <= r)
            temp[k++] = arr[j++];

        for (i = 0; i < temp.length; i++)
            arr[l + i] = temp[i];
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

        System.out.println(ans);
    }
}