public class PeakElementFinder {

    public static int findPeakElement(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            boolean hasLeftNeighbor = middle > 0;
            boolean hasRightNeighbor = middle < numbers.length - 1;

            boolean isPeak = (!hasLeftNeighbor || numbers[middle] > numbers[middle - 1])
                    && (!hasRightNeighbor || numbers[middle] > numbers[middle + 1]);

            if (isPeak) {
                return middle;
            }

            if (hasLeftNeighbor && numbers[middle - 1] > numbers[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sampleArray = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(sampleArray);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + sampleArray[peakIndex]);
    }
}
