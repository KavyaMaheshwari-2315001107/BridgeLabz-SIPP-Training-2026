package collectionframework;
import java.util.*;

public class ParkingManager {

    static ArrayList<String> park = new ArrayList<>();

    static void enter(String no) {

        if (park.contains(no)) {
            System.out.println("Vehicle Already Parked.");
            return;
        }

        park.add(no);
        System.out.println("Vehicle Entered.");
    }

    static void exit(String no) {

        if (park.remove(no))
            System.out.println("Vehicle Removed.");
        else
            System.out.println("Vehicle Not Found.");
    }

    static void search(String no) {

        if (park.contains(no))
            System.out.println("Vehicle Present.");
        else
            System.out.println("Vehicle Not Present.");
    }

    static void display() {

        System.out.println("\nParked Vehicles");

        for (String s : park)
            System.out.println(s);

        System.out.println("Occupied Slots : " + park.size());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 Enter");
            System.out.println("2 Exit");
            System.out.println("3 Search");
            System.out.println("4 Display");
            System.out.println("5 Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Vehicle Number : ");
                    enter(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Vehicle Number : ");
                    exit(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Vehicle Number : ");
                    search(sc.nextLine());
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}