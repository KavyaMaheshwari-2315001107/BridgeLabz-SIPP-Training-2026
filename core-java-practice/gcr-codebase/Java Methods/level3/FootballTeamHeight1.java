import java.util.Random;

public class FootballTeamHeight1 {

    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public static double findMeanHeight(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public static int findShortestHeight(int[] heights) {
        int min = heights[0];

        for (int height : heights) {
            if (height < min) {
                min = height;
            }
        }

        return min;
    }

    public static int findTallestHeight(int[] heights) {
        int max = heights[0];

        for (int height : heights) {
            if (height > max) {
                max = height;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Random random = new Random();

        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = random.nextInt(101) + 150;
        }

        System.out.println("Player Heights:");

        for (int height : heights) {
            System.out.print(height + " ");
        }

        System.out.println("\n\nMean Height = " + findMeanHeight(heights));
        System.out.println("Shortest Height = " + findShortestHeight(heights));
        System.out.println("Tallest Height = " + findTallestHeight(heights));
    }
}