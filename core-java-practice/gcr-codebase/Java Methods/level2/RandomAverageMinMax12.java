public class RandomAverageMinMax12 {

    static int[] generate4DigitRandomArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 9000) + 1000;
        }

        return arr;
    }

    static double[] findAverageMinMax(int[] arr) {

        int min = arr[0];
        int max = arr[0];
        int sum = 0;

        for (int num : arr) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return new double[]{
                (double) sum / arr.length,
                min,
                max
        };
    }

    public static void main(String[] args) {

        int[] arr = generate4DigitRandomArray(5);

        for (int num : arr)
            System.out.print(num + " ");

        System.out.println();

        double[] result = findAverageMinMax(arr);

        System.out.println("Average = " + result[0]);
        System.out.println("Min = " + result[1]);
        System.out.println("Max = " + result[2]);
    }
}