import java.util.Scanner;

public class WordsLength2D3 {

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

    static String[][] getData(String[] words) {

        String[][] data = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {

            data[i][0] = words[i];
            data[i][1] = String.valueOf(findLength(words[i]));
        }

        return data;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] words = splitWords(text);

        String[][] data = getData(words);

        System.out.println("Word\tLength");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + Integer.parseInt(data[i][1]));
        }
    }
}