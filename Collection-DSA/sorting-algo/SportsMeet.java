import java.util.*;

public class SportsMeet {

    static int bubbleSort(int arr[]) {

        int swap = 0;
        boolean sorted;

        for (int i = 0; i < arr.length - 1; i++) {

            sorted = true;

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;

                    swap++;
                    sorted = false;
                }
            }

            System.out.println("Pass " + (i + 1) + " : " + Arrays.toString(arr));

            if (sorted) {
                System.out.println("Already Sorted");
                break;
            }
        }

        return swap;
    }

    static void insertionSort(int arr[]) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort : " + Arrays.toString(arr));
    }

    static void top3(int arr[]) {

        Arrays.sort(arr);

        System.out.println("\nTop 3 Medalists");

        for (int i = arr.length - 1; i >= arr.length - 3; i--)
            System.out.println(arr[i]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Athletes : ");
        int n = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];

        System.out.println("Enter Scores");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i];
        }

        int s = bubbleSort(a);

        System.out.println("Total Swaps : " + s);

        insertionSort(b);

        top3(a);

        System.out.println("\nTrace Array");

        int x[] = {64,25,12,22,11};

        bubbleSort(x);
    }
}