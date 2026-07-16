package collectionframework;
import java.util.*;

public class ClassroomAttendance {

    static HashMap<String, ArrayList<String>> map = new HashMap<>();

    static void mark(Scanner sc) {

        System.out.print("Enter Subject : ");
        String sub = sc.nextLine();

        System.out.print("Enter Student Name : ");
        String stu = sc.nextLine();

        if (!map.containsKey(sub))
            map.put(sub, new ArrayList<>());

        ArrayList<String> list = map.get(sub);

        if (list.contains(stu)) {
            System.out.println("Attendance Already Marked.");
            return;
        }

        list.add(stu);

        System.out.println("Attendance Marked.");
    }

    static void display() {

        if (map.isEmpty()) {
            System.out.println("No Attendance Record.");
            return;
        }

        for (String sub : map.keySet()) {

            System.out.println("\nSubject : " + sub);

            ArrayList<String> list = map.get(sub);

            for (String s : list)
                System.out.println(s);

            System.out.println("Total Students : " + list.size());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Mark Attendance");
            System.out.println("2. Display Attendance");
            System.out.println("3. Exit");

            System.out.print("Enter Choice : ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    mark(sc);
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    System.out.println("Thank You");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}