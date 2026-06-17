import java.util.Scanner;

public class CharacterType6 {

    static String check(char ch) {

        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }

            return "Consonant";
        }

        return "Not a Letter";
    }

    static String[][] getData(String text) {

        String[][] data = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {

            data[i][0] = String.valueOf(text.charAt(i));
            data[i][1] = check(text.charAt(i));
        }

        return data;
    }

    static void display(String[][] data) {

        System.out.println("Character\tType");

        for (String[] row : data) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[][] data = getData(text);

        display(data);
    }
}