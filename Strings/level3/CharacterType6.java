import java.util.Scanner;

public class CharacterType6 {

    public static String checkType(char ch) {

        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch == 'a' || ch == 'e' || ch == 'i' ||
            ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        if (ch >= 'a' && ch <= 'z') {
            return "Consonant";
        }

        return "Not a Letter";
    }

    public static String[][] getDetails(String text) {

        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {

            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkType(text.charAt(i));
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        String[][] result = getDetails(text);

        System.out.println("Character\tType");

        for (String[] row : result) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }

        sc.close();
    }
}