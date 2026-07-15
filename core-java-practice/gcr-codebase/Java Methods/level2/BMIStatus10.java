import java.util.Scanner;

public class BMIStatus10 {

    static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] person = new double[10][3];

        for (int i = 0; i < 10; i++) {
            person[i][0] = sc.nextDouble();
            person[i][1] = sc.nextDouble();

            double h = person[i][1] / 100;

            person[i][2] = person[i][0] / (h * h);
        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f %.2f %.2f %s%n",
                    person[i][0],
                    person[i][1],
                    person[i][2],
                    getStatus(person[i][2]));
        }
    }
}