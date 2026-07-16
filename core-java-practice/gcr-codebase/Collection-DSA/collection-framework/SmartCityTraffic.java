package collectionframework;
import java.util.*;

public class SmartCityTraffic {

    static HashMap<String, Integer> map = new HashMap<>();

    static void addRoad(Scanner sc) {

        System.out.print("Enter Road Name : ");
        String road = sc.nextLine();

        System.out.print("Enter Vehicle Count : ");
        int count = sc.nextInt();
        sc.nextLine();

        if (map.containsKey(road))
            map.put(road, map.get(road) + count);
        else
            map.put(road, count);

        System.out.println("Data Updated Successfully.");
    }

    static void display() {

        if (map.isEmpty()) {
            System.out.println("No Traffic Data Available.");
            return;
        }

        TreeMap<String, Integer> tree = new TreeMap<>(map);

        System.out.println("\nTraffic Report");

        for (String road : tree.keySet()) {
            System.out.println(road + " -> " + tree.get(road) + " Vehicles");
        }

        System.out.println("Total Roads : " + tree.size());
    }

    static void busiestRoad() {

        if (map.isEmpty()) {
            System.out.println("No Data Available.");
            return;
        }

        String road = "";
        int max = 0;

        for (String r : map.keySet()) {

            if (map.get(r) > max) {
                max = map.get(r);
                road = r;
            }
        }

        System.out.println("Busiest Road : " + road);
        System.out.println("Vehicle Count : " + max);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add/Update Road");
            System.out.println("2. Display Traffic Report");
            System.out.println("3. Show Busiest Road");
            System.out.println("4. Exit");

            System.out.print("Enter Choice : ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    addRoad(sc);
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    busiestRoad();
                    break;

                case 4:
                    System.out.println("Thank You");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}