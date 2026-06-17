import java.util.Scanner;

public class StudentVoting8 {

    static int[] getAges(int n) {

        int[] age = new int[n];

        for (int i = 0; i < n; i++) {
            age[i] = (int) (Math.random() * 90) + 10;
        }

        return age;
    }

    static String[][] checkVoting(int[] age) {

        String[][] data = new String[age.length][2];

        for (int i = 0; i < age.length; i++) {

            data[i][0] = String.valueOf(age[i]);

            if (age[i] >= 18) {
                data[i][1] = "true";
            } else {
                data[i][1] = "false";
            }
        }

        return data;
    }

    static void display(String[][] data) {

        System.out.println("Age\tCan Vote");

        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 10;

        int[] age = getAges(n);

        String[][] result = checkVoting(age);

        display(result);
    }
}