import java.util.HashMap;
import java.util.Map;

public class MostFrequentErrorCode {
    public static int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int bestCode = codes[0];
        int bestCount = 0;

        for (int code : codes) {
            int count = frequency.merge(code, 1, Integer::sum);
            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }

        return bestCode;
    }

    public static void main(String[] args) {
        int[] codes = {2, 4, 2, 5, 2, 4, 4};
        System.out.println("Most frequent code: " + mostFrequentErrorCode(codes));
    }
}
