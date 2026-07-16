import java.util.*;

public class LibrarySorting {

    static void merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int a[] = new int[n1];
        int b[] = new int[n2];

        for (int i = 0; i < n1; i++)
            a[i] = arr[l + i];

        for (int i = 0; i < n2; i++)
            b[i] = arr[m + 1 + i];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {

            if (a[i] <= b[j])
                arr[k++] = a[i++];
            else
                arr[k++] = b[j++];
        }

        while (i < n1)
            arr[k++] = a[i++];

        while (j < n2)
            arr[k++] = b[j++];
    }

    static void mergeSort(int arr[], int l, int r) {

        if (l < r) {

            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {

                i++;

                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;

        return i + 1;
    }

    static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static void countingSort(int arr[]) {

        int count[] = new int[21];

        for (int x : arr)
            count[x]++;

        int k = 0;

        for (int i = 1; i <= 20; i++) {

            while (count[i]-- > 0)
                arr[k++] = i;
        }
    }

    static void show(int arr[]) {

        for (int x : arr)
            System.out.print(x + " ");

        System.out.println();
    }

    public static void main(String[] args) {

        int a[] = {2018, 2015, 2022, 2019, 2021};
        int b[] = a.clone();
        int c[] = {3, 7, 2, 1, 20, 5, 10};

        mergeSort(a, 0, a.length - 1);
        quickSort(b, 0, b.length - 1);
        countingSort(c);

        System.out.println("Merge Sort");
        show(a);

        System.out.println("Quick Sort");
        show(b);

        System.out.println("Counting Sort");
        show(c);

        int size[] = {100,1000,10000};

        for(int s:size){

            int arr=new Random().ints(s,1,10000).toArray();

            long st=System.nanoTime();
            mergeSort(arr,0,s-1);
            long et=System.nanoTime();

            System.out.println("Size "+s+" Time "+(et-st)+" ns");
        }
    }
}