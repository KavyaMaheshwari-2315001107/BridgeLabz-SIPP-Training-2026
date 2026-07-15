public class NullPointerException4 {

    static void handle() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException Handled");
        }
    }

    public static void main(String[] args) {
        handle();
    }
}