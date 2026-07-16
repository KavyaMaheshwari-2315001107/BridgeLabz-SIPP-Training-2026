package collectionframework;
import java.util.*;

public class MusicPlaylist {

    static LinkedList<String> list = new LinkedList<>();

    static void playSong(Scanner sc) {

        System.out.print("Enter Song Name : ");
        String song = sc.nextLine();

        if (list.contains(song))
            list.remove(song);

        list.addFirst(song);

        if (list.size() > 10)
            list.removeLast();

        System.out.println("Song Added.");
    }

    static void searchSong(Scanner sc) {

        System.out.print("Enter Song Name : ");
        String song = sc.nextLine();

        if (list.contains(song))
            System.out.println("Song Found.");
        else
            System.out.println("Song Not Found.");
    }

    static void display() {

        if (list.isEmpty()) {
            System.out.println("Playlist Empty.");
            return;
        }

        System.out.println("\nRecently Played Songs");

        int i = 1;

        for (String s : list) {
            System.out.println(i + ". " + s);
            i++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Play Song");
            System.out.println("2. Search Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Exit");

            System.out.print("Enter Choice : ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    playSong(sc);
                    break;

                case 2:
                    searchSong(sc);
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