interface TextModeration {
    void moderateText(String post);

    default void displayModerationPolicy() {
        System.out.println("Text Moderation Policy: Avoid offensive language and restricted content.");
    }

    static boolean containsRestrictedWords(String post) {
        if (post == null) {
            return false;
        }
        String lower = post.toLowerCase();
        return lower.contains("hate") || lower.contains("violence") || lower.contains("offensive") || lower.contains("abuse");
    }
}

interface SpamDetection {
    void detectSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam Detection Policy: Identify promotional, deceptive, or repeated spam content.");
    }
}

public class ContentModeratorDemo implements TextModeration, SpamDetection {
    private final String[] posts = {
        "Huge discount! Buy now and save big.",
        "I hate this product.",
        "Limited offer: free gift with every order.",
        "Looking forward to the weekend with my family.",
        "This is offensive content and should be removed."
    };

    @Override
    public void moderateText(String post) {
        if (TextModeration.containsRestrictedWords(post)) {
            System.out.println("Offensive post: " + post);
        } else {
            System.out.println("Valid post: " + post);
        }
    }

    @Override
    public void detectSpam(String post) {
        String lower = post.toLowerCase();
        if (lower.contains("buy now") || lower.contains("limited offer") || lower.contains("free gift") || lower.contains("discount")) {
            System.out.println("Spam post: " + post);
        }
    }

    @Override
    public void displayModerationPolicy() {
        System.out.println("Content moderation policy summary:");
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public void reviewPosts() {
        displayModerationPolicy();
        System.out.println();
        for (String post : posts) {
            boolean isSpam = post.toLowerCase().contains("buy now") || post.toLowerCase().contains("limited offer") || post.toLowerCase().contains("free gift") || post.toLowerCase().contains("discount");
            boolean isOffensive = TextModeration.containsRestrictedWords(post);
            if (isSpam) {
                System.out.println("Spam post detected: " + post);
            }
            if (isOffensive) {
                System.out.println("Offensive post detected: " + post);
            }
            if (!isSpam && !isOffensive) {
                System.out.println("Valid post: " + post);
            }
        }
    }

    public static void main(String[] args) {
        new ContentModeratorDemo().reviewPosts();
    }
}
