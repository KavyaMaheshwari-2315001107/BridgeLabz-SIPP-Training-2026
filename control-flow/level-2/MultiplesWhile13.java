import java.util.Scanner;

public class MultiplesWhile13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if (num > 0 && num < 100) {
            int i = num;

            while (i < 100) {
                System.out.println(i);
                i += num;
            }
        }
    }
}