import java.util.Scanner;

public class VowelConsonantCount5 {

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

    static int[] countVC(String text) {

        int vowel = 0;
        int consonant = 0;

        for (int i = 0; i < text.length(); i++) {

            String type = check(text.charAt(i));

            if (type.equals("Vowel")) {
                vowel++;
            } else if (type.equals("Consonant")) {
                consonant++;
            }
        }

        return new int[]{vowel, consonant};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int[] ans = countVC(text);

        System.out.println("Vowels = " + ans[0]);
        System.out.println("Consonants = " + ans[1]);
    }
}