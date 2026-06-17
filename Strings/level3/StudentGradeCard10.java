import java.util.Scanner;

public class StudentGradeCard10 {

    public static int[][] generateMarks(
            int students) {

        int[][] marks =
                new int[students][3];

        for (int i = 0; i < students; i++) {

            for (int j = 0; j < 3; j++) {

                marks[i][j] =
                        (int)(Math.random()*100);
            }
        }

        return marks;
    }

    public static double[][] calculate(
            int[][] marks) {

        double[][] result =
                new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {

            int total =
                    marks[i][0] +
                    marks[i][1] +
                    marks[i][2];

            double average =
                    total / 3.0;

            double percentage =
                    total / 3.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }

    public static String getGrade(
            double percentage) {

        if (percentage >= 90)
            return "A+";
        else if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else if (percentage >= 50)
            return "D";
        else
            return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print(
                "Enter Number of Students: ");

        int students = sc.nextInt();

        int[][] marks =
                generateMarks(students);

        double[][] result =
                calculate(marks);

        System.out.println(
                "\nPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < students; i++) {

            System.out.println(
                    marks[i][0] + "\t" +
                    marks[i][1] + "\t" +
                    marks[i][2] + "\t" +
                    result[i][0] + "\t" +
                    Math.round(result[i][1] * 100) / 100.0 + "\t" +
                    Math.round(result[i][2] * 100) / 100.0 + "\t" +
                    getGrade(result[i][2]));
        }

        sc.close();
    }
}