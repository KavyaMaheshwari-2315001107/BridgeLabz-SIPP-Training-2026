public class BinarySearchScenario {

    public static int binarySearchSorted(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (numbers[middle] == target) {
                return middle;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static int searchInRotatedArray(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (numbers[middle] == target) {
                return middle;
            }

            if (numbers[left] <= numbers[middle]) {
                if (numbers[left] <= target && target < numbers[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (numbers[middle] < target && target <= numbers[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }

    public static int findFirstOccurrence(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (numbers[middle] == target) {
                firstIndex = middle;
                right = middle - 1;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return firstIndex;
    }

    public static int findLastOccurrence(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (numbers[middle] == target) {
                lastIndex = middle;
                left = middle + 1;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return lastIndex;
    }

    public static int findMinimumElement(int[] numbers) {
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

        return numbers[left];
    }

    public static void main(String[] args) {
        int[] brightnessEntries = {10, 20, 30, 40, 50};
        int targetValue = 30;

        System.out.println("Sorted binary search result: " + binarySearchSorted(brightnessEntries, targetValue));

        int[] rotatedCatalog = {40, 50, 60, 10, 20, 30};
        System.out.println("Rotated array search result: " + searchInRotatedArray(rotatedCatalog, 20));

        int[] repeatedValues = {1, 2, 2, 2, 3};
        System.out.println("First occurrence of 2: " + findFirstOccurrence(repeatedValues, 2));
        System.out.println("Last occurrence of 2: " + findLastOccurrence(repeatedValues, 2));

        int[] minimumArray = {45, 50, 60, 10, 20, 30};
        System.out.println("Minimum element: " + findMinimumElement(minimumArray));
    }
}
