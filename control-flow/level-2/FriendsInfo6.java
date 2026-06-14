import java.util.Scanner;

public class FriendsInfo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amarAge = sc.nextInt();
        double amarHeight = sc.nextDouble();

        int akbarAge = sc.nextInt();
        double akbarHeight = sc.nextDouble();

        int anthonyAge = sc.nextInt();
        double anthonyHeight = sc.nextDouble();

        String youngest;
        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            youngest = "Amar";
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }

        String tallest;
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            tallest = "Amar";
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }

        System.out.println("Youngest friend is " + youngest);
        System.out.println("Tallest friend is " + tallest);
    }
}