import java.util.Scanner;

public class BMI2D7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[][] person = new double[n][3];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            do {
                person[i][0] = sc.nextDouble();
                person[i][1] = sc.nextDouble();
            } while (person[i][0] <= 0 || person[i][1] <= 0);

            double h = person[i][1] / 100;
            person[i][2] = person[i][0] / (h * h);

            if (person[i][2] < 18.5) {
                status[i] = "Underweight";
            } else if (person[i][2] < 25) {
                status[i] = "Normal";
            } else if (person[i][2] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(person[i][0] + " " + person[i][1] + " " + person[i][2] + " " + status[i]);
        }
    }
}