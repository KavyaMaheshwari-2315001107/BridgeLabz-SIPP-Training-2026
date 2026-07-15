import java.util.Random;

public class EmployeeBonus11 {

    public static double[][] generateEmployeeData(int n) {

        Random random = new Random();
        double[][] data = new double[n][2];

        for (int i = 0; i < n; i++) {
            data[i][0] = 10000 + random.nextInt(90000);
            data[i][1] = random.nextInt(11);
        }

        return data;
    }

    public static double[][] calculateBonus(double[][] data) {

        double[][] result = new double[data.length][4];

        for (int i = 0; i < data.length; i++) {

            double salary = data[i][0];
            double years = data[i][1];

            double bonus =
                    years > 5 ? salary * 0.05 : salary * 0.02;

            result[i][0] = salary;
            result[i][1] = years;
            result[i][2] = bonus;
            result[i][3] = salary + bonus;
        }

        return result;
    }

    public static void display(double[][] result) {

        double oldTotal = 0;
        double newTotal = 0;
        double bonusTotal = 0;

        System.out.println("OldSalary\tYears\tBonus\tNewSalary");

        for (double[] row : result) {

            System.out.printf("%.0f\t\t%.0f\t%.2f\t%.2f%n",
                    row[0], row[1], row[2], row[3]);

            oldTotal += row[0];
            newTotal += row[3];
            bonusTotal += row[2];
        }

        System.out.println("\nTotal Old Salary = " + oldTotal);
        System.out.println("Total Bonus = " + bonusTotal);
        System.out.println("Total New Salary = " + newTotal);
    }

    public static void main(String[] args) {

        double[][] data = generateEmployeeData(10);
        double[][] result = calculateBonus(data);

        display(result);
    }
}