import java.util.Scanner;

public class ShortestLongest4 {

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

        int words = 1;

        for (int i = 0; i < findLength(text); i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }

        String[] arr = new String[words];

        String word = "";
        int idx = 0;

        for (int i = 0; i < findLength(text); i++) {

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

    static int[] shortestLongest(String[][] data) {

        int min = 0;
        int max = 0;

        for (int i = 1; i < data.length; i++) {

            int len = Integer.parseInt(data[i][1]);

            if (len < Integer.parseInt(data[min][1])) {
                min = i;
            }

            if (len > Integer.parseInt(data[max][1])) {
                max = i;
            }
        }

        return new int[]{min, max};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] words = splitWords(text);

        String[][] data = getData(words);

        int[] ans = shortestLongest(data);

        System.out.println("Shortest Word = " + data[ans[0]][0]);
        System.out.println("Longest Word = " + data[ans[1]][0]);
    }
}