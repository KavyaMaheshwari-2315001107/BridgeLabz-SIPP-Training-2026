public class Palindrome {

    static boolean check(String str, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return check(str, left + 1, right - 1);
    }

    public static void main(String[] args) {

        String str = "madam";

        if (check(str, 0, str.length() - 1)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}