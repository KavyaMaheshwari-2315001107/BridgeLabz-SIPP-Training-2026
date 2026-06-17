import java.util.Scanner;

public class VowelConsonantCount5 {

    public static int[] countVC(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = Character.toLowerCase(text.charAt(i));

            if (ch >= 'a' && ch <= 'z') {

                if ("aeiou".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }

        return new int[] { vowels, consonants };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        int[] result = countVC(text);

        System.out.println("Vowels = " + result[0]);
        System.out.println("Consonants = " + result[1]);

        sc.close();
    }
}