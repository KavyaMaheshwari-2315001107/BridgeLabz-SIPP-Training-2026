import java.util.Scanner;

public class TrimString7 {

    public static int[] trimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < text.length() &&
                text.charAt(start) == ' ') {
            start++;
        }

        while (end >= 0 &&
                text.charAt(end) == ' ') {
            end--;
        }

        return new int[] { start, end };
    }

    public static String substring(String text,
                                   int start,
                                   int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    public static boolean compare(String a, String b) {

        if (a.length() != b.length())
            return false;

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) != b.charAt(i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        int[] pos = trimIndexes(text);

        String userTrim =
                substring(text, pos[0], pos[1]);

        String builtIn = text.trim();

        System.out.println("User Trim = " + userTrim);
        System.out.println("Built-in Trim = " + builtIn);
        System.out.println("Same = " +
                compare(userTrim, builtIn));

        sc.close();
    }
}