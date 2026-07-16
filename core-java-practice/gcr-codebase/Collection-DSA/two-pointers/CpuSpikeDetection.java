public class CpuSpikeDetection {
    public static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];

            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= cpuLoad[start];
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] cpuLoad = {1, 3, 2, 5, 4, 6, 7};
        int k = 3;

        System.out.println("Maximum window sum: " + maxSubarrayOfSizeK(cpuLoad, k));
    }
}
