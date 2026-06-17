import java.util.Scanner;

public class SplitWords2 {

    static int findLength(String s) {
        int count = 0;

        while (true) {
            try {
                s.charAt(count);
                count++;
            } catch (Exception e) {
                break;
            }
        }

        return count;
    }

    static String[] splitWords(String text) {

        int len = findLength(text);
        int words = 1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }

        String[] arr = new String[words];

        String word = "";
        int idx = 0;

        for (int i = 0; i < len; i++) {

            if (text.charAt(i) == ' ') {
                arr[idx++] = word;
                word = "";
            } else {
                word += text.charAt(i);
            }
        }

        arr[idx] = word;

        return arr;
    }

    static boolean compare(String[] a, String[] b) {

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {

            if (!a[i].equals(b[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] a = splitWords(text);
        String[] b = text.split(" ");

        System.out.println("Same Result = " + compare(a, b));
    }
}