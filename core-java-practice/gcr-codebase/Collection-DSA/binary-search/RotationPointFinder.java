public class RotationPointFinder {

    public static int findRotationPointIndex(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (numbers[middle] > numbers[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 6, 7, 1, 2, 3};
        int rotationIndex = findRotationPointIndex(rotatedArray);

        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + rotatedArray[rotationIndex]);
    }
}
