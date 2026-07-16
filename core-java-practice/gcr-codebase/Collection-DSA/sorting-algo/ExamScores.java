import java.util.*;

public class ExamScores {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Students : ");
        int n = sc.nextInt();

        int score[] = new int[n];

        System.out.println("Enter Scores");

        for (int i = 0; i < n; i++)
            score[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {

            int min = i;

            for (int j = i + 1; j < n; j++) {

                if (score[j] < score[min])
                    min = j;
            }

            int t = score[i];
            score[i] = score[min];
            score[min] = t;
        }

        System.out.println("Sorted Scores");

        for (int x : score)
            System.out.print(x + " ");
    }
}