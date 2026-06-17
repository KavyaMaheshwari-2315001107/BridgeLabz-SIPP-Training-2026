import java.util.Scanner;

public class SplitWords2 {

    public static String[] splitWords(String text) {

        int words = 1;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }

        String[] result = new String[words];

        int start = 0;
        int index = 0;

        for (int i = 0; i <= text.length(); i++) {

            if (i == text.length() || text.charAt(i) == ' ') {
                result[index++] = text.substring(start, i);
                start = i + 1;
            }
        }

        return result;
    }

    public static boolean compareArrays(String[] a, String[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        String[] userArray = splitWords(text);
        String[] builtInArray = text.split(" ");

        System.out.println("Arrays Equal = " +
                compareArrays(userArray, builtInArray));

        sc.close();
    }
}