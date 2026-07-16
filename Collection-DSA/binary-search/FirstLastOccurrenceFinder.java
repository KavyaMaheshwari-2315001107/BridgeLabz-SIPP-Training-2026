public class FirstLastOccurrenceFinder {

    public static int[] findFirstAndLastOccurrence(int[] numbers, int target) {
        int firstIndex = findFirstOccurrence(numbers, target);
        int lastIndex = findLastOccurrence(numbers, target);
        return new int[]{firstIndex, lastIndex};
    }

    private static int findFirstOccurrence(int[] numbers, int target) {
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

    private static int findLastOccurrence(int[] numbers, int target) {
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

    public static void main(String[] args) {
        int[] sortedNumbers = {1, 2, 2, 2, 3, 4};
        int[] result = findFirstAndLastOccurrence(sortedNumbers, 2);

        System.out.println("First occurrence index: " + result[0]);
        System.out.println("Last occurrence index: " + result[1]);
    }
}
