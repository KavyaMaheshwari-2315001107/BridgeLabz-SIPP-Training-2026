import java.util.Scanner;

public class Friends2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] name = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }

        int young = 0;
        int tall = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[young]) {
                young = i;
            }

            if (height[i] > height[tall]) {
                tall = i;
            }
        }

        System.out.println("Youngest Friend: " + name[young]);
        System.out.println("Tallest Friend: " + name[tall]);
    }
}