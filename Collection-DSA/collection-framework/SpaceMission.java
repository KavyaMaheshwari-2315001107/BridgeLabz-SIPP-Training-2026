package collectionframework;
import java.util.*;

class Astronaut {

    int id;
    String name;
    String sp;

    Astronaut(int id, String name, String sp) {
        this.id = id;
        this.name = name;
        this.sp = sp;
    }

    public String toString() {
        return "ID : " + id +
                "  Name : " + name +
                "  Specialization : " + sp;
    }
}

public class SpaceMission {

    static HashMap<String, ArrayList<Astronaut>> map = new HashMap<>();
    static HashMap<String, HashSet<Integer>> ids = new HashMap<>();

    static void addMission(Scanner sc) {

        System.out.print("Enter Mission Name : ");
        String m = sc.nextLine();

        if (map.containsKey(m)) {
            System.out.println("Mission Already Exists.");
            return;
        }

        map.put(m, new ArrayList<>());
        ids.put(m, new HashSet<>());

        System.out.println("Mission Added.");
    }

    static void addAstronaut(Scanner sc) {

        System.out.print("Enter Mission Name : ");
        String m = sc.nextLine();

        if (!map.containsKey(m)) {
            System.out.println("Mission Not Found.");
            return;
        }

        System.out.print("Enter ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        if (ids.get(m).contains(id)) {
            System.out.println("Astronaut Already Assigned.");
            return;
        }

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization : ");
        String sp = sc.nextLine();

        Astronaut a = new Astronaut(id, name, sp);

        map.get(m).add(a);
        ids.get(m).add(id);

        System.out.println("Astronaut Assigned.");
    }

    static void display() {

        if (map.isEmpty()) {
            System.out.println("No Mission Available.");
            return;
        }

        for (String m : map.keySet()) {

            System.out.println("\nMission : " + m);

            ArrayList<Astronaut> list = map.get(m);

            if (list.isEmpty()) {
                System.out.println("No Crew Assigned.");
            } else {

                for (Astronaut a : list)
                    System.out.println(a);

                System.out.println("Total Crew : " + list.size());
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Mission");
            System.out.println("2. Assign Astronaut");
            System.out.println("3. Display Missions");
            System.out.println("4. Exit");

            System.out.print("Enter Choice : ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    addMission(sc);
                    break;

                case 2:
                    addAstronaut(sc);
                    break;

                case 3:
                    display();
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