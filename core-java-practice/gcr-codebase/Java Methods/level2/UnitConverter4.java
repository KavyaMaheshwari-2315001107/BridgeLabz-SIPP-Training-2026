public class UnitConverter4 {

    static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    static double convertMetersToFeet(double m) {
        return m * 3.28084;
    }

    static double convertFeetToMeters(double ft) {
        return ft * 0.3048;
    }

    public static void main(String[] args) {
        System.out.println(convertKmToMiles(10));
        System.out.println(convertMilesToKm(10));
    }
}