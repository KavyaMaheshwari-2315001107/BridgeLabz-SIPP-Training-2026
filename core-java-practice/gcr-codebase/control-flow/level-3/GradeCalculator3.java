import java.util.Scanner;

public class GradeCalculator3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double physics = sc.nextDouble();
        double chemistry = sc.nextDouble();
        double maths = sc.nextDouble();

        double percentage = (physics + chemistry + maths) / 3;

        String grade;
        String remark;

        if (percentage >= 90) {
            grade = "A+";
            remark = "Excellent";
        } else if (percentage >= 80) {
            grade = "A";
            remark = "Very Good";
        } else if (percentage >= 70) {
            grade = "B";
            remark = "Good";
        } else if (percentage >= 60) {
            grade = "C";
            remark = "Average";
        } else if (percentage >= 40) {
            grade = "D";
            remark = "Pass";
        } else {
            grade = "F";
            remark = "Fail";
        }

        System.out.println("Percentage = " + percentage);
        System.out.println("Grade = " + grade);
        System.out.println("Remarks = " + remark);
    }
}