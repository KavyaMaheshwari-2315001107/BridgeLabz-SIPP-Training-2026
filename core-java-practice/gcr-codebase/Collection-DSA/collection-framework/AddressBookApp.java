package collectionframework;
import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

public class AddressBookApp {

    static ArrayList<Contact> list = new ArrayList<>();
    static HashMap<String, Contact> map = new HashMap<>();
    static HashSet<String> phoneSet = new HashSet<>();

    static void add(String n, String p, String e) {
        if (phoneSet.contains(p)) {
            System.out.println("Phone number already exists.");
            return;
        }

        Contact c = new Contact(n, p, e);
        list.add(c);
        map.put(n, c);
        phoneSet.add(p);

        System.out.println("Contact Added.");
    }

    static void search(String n) {
        if (map.containsKey(n)) {
            Contact c = map.get(n);
            System.out.println(c.name + " " + c.phone + " " + c.email);
        } else {
            System.out.println("Contact Not Found.");
        }
    }

    static void delete(String n) {
        Contact c = map.remove(n);

        if (c == null) {
            System.out.println("Contact Not Found.");
            return;
        }

        phoneSet.remove(c.phone);
        list.remove(c);

        System.out.println("Deleted Successfully.");
    }

    static void display() {
        Collections.sort(list, (a, b) -> a.name.compareToIgnoreCase(b.name));

        System.out.println("\nContacts");

        for (Contact c : list) {
            System.out.println(c.name + " " + c.phone + " " + c.email);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 Add");
            System.out.println("2 Search");
            System.out.println("3 Delete");
            System.out.println("4 Display");
            System.out.println("5 Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Name : ");
                    String n = sc.nextLine();

                    System.out.print("Phone : ");
                    String p = sc.nextLine();

                    System.out.print("Email : ");
                    String e = sc.nextLine();

                    add(n, p, e);
                    break;

                case 2:
                    System.out.print("Enter Name : ");
                    search(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter Name : ");
                    delete(sc.nextLine());
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