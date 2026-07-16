interface StreamingService {
    void streamMovie(String movie);

    default void showSubscriptionDetails() {
        System.out.println("Streaming subscription includes HD movies, new releases, and unlimited content.");
    }
}

interface GamingService {
    void playGame(String game);

    default void showSubscriptionDetails() {
        System.out.println("Gaming subscription includes multiplayer access, DLC, and cloud saves.");
    }
}

public class SmartTVDemo implements StreamingService, GamingService {
    private final String[] movies = {"The Horizon", "Skyward", "Journey to Mars"};
    private final String[] games = {"Space Racer", "Castle Defender", "Mystery Manor"};

    @Override
    public void streamMovie(String movie) {
        System.out.println("Streaming movie: " + movie);
    }

    @Override
    public void playGame(String game) {
        System.out.println("Playing game: " + game);
    }

    @Override
    public void showSubscriptionDetails() {
        System.out.println("Smart TV subscription details:");
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void displayAvailableContent() {
        System.out.println("Available movies:");
        for (String movie : movies) {
            System.out.println(" - " + movie);
        }
        System.out.println("Available games:");
        for (String game : games) {
            System.out.println(" - " + game);
        }
    }

    public static void main(String[] args) {
        SmartTVDemo tv = new SmartTVDemo();
        tv.showSubscriptionDetails();
        tv.displayAvailableContent();
    }
}
