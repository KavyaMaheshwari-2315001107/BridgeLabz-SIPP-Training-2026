import java.util.*;

public class MovieRatings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Movies : ");
        int n = sc.nextInt();

        int rating[] = new int[n];

        System.out.println("Enter Ratings");

        for (int i = 0; i < n; i++)
            rating[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {

            int min = i;

            for (int j = i + 1; j < n; j++) {

                if (rating[j] < rating[min])
                    min = j;
            }

            int t = rating[i];
            rating[i] = rating[min];
            rating[min] = t;
        }

        System.out.println("Sorted Ratings");

        for (int x : rating)
            System.out.print(x + " ");
    }
}