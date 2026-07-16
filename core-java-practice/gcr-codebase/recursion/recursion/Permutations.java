public class Permutations {

    static void generate(String str, String answer) {

        if (str.length() == 0) {
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i);

            String remaining = str.substring(0, i) + str.substring(i + 1);

            generate(remaining, answer + current);
        }
    }

    public static void main(String[] args) {

        String str = "ABC";

        generate(str, "");
    }
}




