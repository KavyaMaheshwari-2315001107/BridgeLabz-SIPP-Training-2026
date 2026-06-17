import java.util.Random;

public class StudentVoting8 {

    public static int[] generateAges(int n) {

        Random random = new Random();

        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = random.nextInt(90) + 10;
        }

        return ages;
    }

    public static String[][] checkVoting(int[] ages) {

        String[][] result =
                new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            result[i][0] =
                    String.valueOf(ages[i]);

            if (ages[i] >= 18)
                result[i][1] = "true";
            else
                result[i][1] = "false";
        }

        return result;
    }

    public static void main(String[] args) {

        int[] ages = generateAges(10);

        String[][] result =
                checkVoting(ages);

        System.out.println("Age\tCan Vote");

        for (String[] row : result) {
            System.out.println(row[0] +
                    "\t" + row[1]);
        }
    }
}