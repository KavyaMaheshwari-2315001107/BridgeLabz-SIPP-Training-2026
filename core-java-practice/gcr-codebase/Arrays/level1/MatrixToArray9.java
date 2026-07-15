package level1;
import java.util.Scanner;

public class MatrixToArray9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int[] arr = new int[rows * cols];
        int idx = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[idx++] = mat[i][j];
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}