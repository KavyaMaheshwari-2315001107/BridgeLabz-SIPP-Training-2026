import java.util.Random;
import java.util.Scanner;

public class StudentScorecard13 {

    public static int[][] generateScores(int students) {

        Random random = new Random();

        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {

            for (int j = 0; j < 3; j++) {
                scores[i][j] =
                        10 + random.nextInt(90);
            }
        }

        return scores;
    }

    public static double[][] calculateResult(
            int[][] scores) {

        double[][] result =
                new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {

            int total =
                    scores[i][0]
                            + scores[i][1]
                            + scores[i][2];

            double average =
                    Math.round(
                            (total / 3.0) * 100.0)
                            / 100.0;

            double percentage =
                    Math.round(
                            (total / 300.0 * 100)
                                    * 100.0)
                            / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }

    public static void display(
            int[][] scores,
            double[][] result) {

        System.out.println(
                "Phy\tChem\tMath\tTotal\tAvg\tPercent");

        for (int i = 0; i < scores.length; i++) {

            System.out.println(
                    scores[i][0] + "\t"
                            + scores[i][1] + "\t"
                            + scores[i][2] + "\t"
                            + result[i][0] + "\t"
                            + result[i][1] + "\t"
                            + result[i][2]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Students: ");
        int n = sc.nextInt();

        int[][] scores =
                generateScores(n);

        double[][] result =
                calculateResult(scores);

        display(scores, result);
    }
}