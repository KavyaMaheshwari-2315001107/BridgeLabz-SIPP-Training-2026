import java.util.Random;

public class MatrixAdvanced15 {

    public static int[][] createMatrix(
            int rows,
            int cols) {

        Random random = new Random();

        int[][] matrix =
                new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] =
                        random.nextInt(9) + 1;
            }
        }

        return matrix;
    }

    public static int[][] transpose(
            int[][] matrix) {

        int[][] trans =
                new int[matrix[0].length]
                        [matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                trans[j][i] = matrix[i][j];
            }
        }

        return trans;
    }

    public static int determinant2x2(
            int[][] m) {

        return (m[0][0] * m[1][1])
                - (m[0][1] * m[1][0]);
    }

    public static void display(
            int[][] matrix) {

        for (int[] row : matrix) {

            for (int value : row) {

                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix =
                createMatrix(2, 2);

        System.out.println("Matrix");
        display(matrix);

        System.out.println("\nTranspose");
        display(transpose(matrix));

        System.out.println(
                "\nDeterminant = "
                        + determinant2x2(matrix));
    }
}