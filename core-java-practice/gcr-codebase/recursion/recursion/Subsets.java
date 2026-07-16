import java.util.ArrayList;

public class Subsets {

    static void findSubsets(int[] arr, int index, ArrayList<Integer> current) {

        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Include current element
        current.add(arr[index]);
        findSubsets(arr, index + 1, current);

        // Remove current element
        current.remove(current.size() - 1);

        // Exclude current element
        findSubsets(arr, index + 1, current);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2};

        findSubsets(arr, 0, new ArrayList<>());
    }
}