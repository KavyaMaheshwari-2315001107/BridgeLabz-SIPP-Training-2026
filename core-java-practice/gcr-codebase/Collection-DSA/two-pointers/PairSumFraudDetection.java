import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSumFraudDetection {
    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];

            if (sum == target) {
                return new int[]{transactions[left], transactions[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] transactions = {10, 20, 30, 40, 49, 50};
        int target = 60;

        int[] result = findPairSum(transactions, target);
        System.out.println("Fraud pair: " + Arrays.toString(result));
    }
}
