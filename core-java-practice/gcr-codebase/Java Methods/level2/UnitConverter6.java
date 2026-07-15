public class UnitConverter6 {

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    static double poundsToKg(double p) {
        return p * 0.453592;
    }

    static double kgToPounds(double kg) {
        return kg * 2.20462;
    }

    static double gallonsToLiters(double g) {
        return g * 3.78541;
    }

    static double litersToGallons(double l) {
        return l * 0.264172;
    }

    public static void main(String[] args) {
        System.out.println(fahrenheitToCelsius(98.6));
    }
}