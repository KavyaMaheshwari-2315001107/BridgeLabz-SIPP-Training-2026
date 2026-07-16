import java.util.*;

public class StudentMarks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Students : ");
        int n = sc.nextInt();

        int marks[] = new int[n];

        System.out.println("Enter Marks");

        for (int i = 0; i < n; i++)
            marks[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {

            boolean swap = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (marks[j] > marks[j + 1]) {

                    int t = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = t;

                    swap = true;
                }
            }

            if (!swap)
                break;
        }

        System.out.println("Sorted Marks");

        for (int x : marks)
            System.out.print(x + " ");
    }
}