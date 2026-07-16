package collectionframework;
import java.util.*;

public class EventEntry {

    static HashSet<String> set = new HashSet<>();

    static void register(String email) {

        if (set.add(email))
            System.out.println("Registration Successful.");
        else
            System.out.println("Duplicate Registration.");
    }

    static void display() {

        System.out.println("\nParticipants");

        for (String s : set)
            System.out.println(s);

        System.out.println("Total Participants : " + set.size());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 Register");
            System.out.println("2 Display");
            System.out.println("3 Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Email : ");
                    register(sc.nextLine());
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}