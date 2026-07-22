public class PalindromeChecker {
    public static void main(String[] args) {
        PalindromeText text1 = new PalindromeText("level");
        text1.displayResult();

        PalindromeText text2 = new PalindromeText("hello");
        text2.displayResult();
    }
}

class PalindromeText {
    private String text;

    public PalindromeText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String normalized = text.toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();
        return normalized.equals(reversed);
    }

    public void displayResult() {
        System.out.println("Text: " + text);
        System.out.println("Is palindrome? " + isPalindrome());
    }
}
