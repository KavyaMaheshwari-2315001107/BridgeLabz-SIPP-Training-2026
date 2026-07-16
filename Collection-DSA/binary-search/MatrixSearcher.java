public class MatrixSearcher {

    public static boolean searchInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;
        int left = 0;
        int right = totalRows * totalColumns - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int row = middle / totalColumns;
            int column = middle % totalColumns;
            int currentValue = matrix[row][column];

            if (currentValue == target) {
                return true;
            } else if (currentValue < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] sortedMatrix = {
                {1, 3, 5, 7},
                {10, 12, 14, 16},
                {18, 20, 22, 24}
        };

        int targetValue = 14;
        System.out.println("Target found: " + searchInMatrix(sortedMatrix, targetValue));
    }
}
