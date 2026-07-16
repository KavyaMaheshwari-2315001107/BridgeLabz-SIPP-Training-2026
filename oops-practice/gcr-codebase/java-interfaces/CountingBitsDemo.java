public class CountingBitsDemo {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBitsDemo demo = new CountingBitsDemo();
        int n = 5;
        int[] bits = demo.countBits(n);
        System.out.print("Counting bits up to " + n + ": ");
        for (int value : bits) {
            System.out.print(value + " ");
        }
    }
}
