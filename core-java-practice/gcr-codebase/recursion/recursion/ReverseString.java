public class ReverseString {

    static void reverse(String str, int index) {
        if (index < 0) {
            return;
        }

        System.out.print(str.charAt(index));
        reverse(str, index - 1);
    }

    public static void main(String[] args) {
        String str = "hello";
        reverse(str, str.length() - 1);
    }
}