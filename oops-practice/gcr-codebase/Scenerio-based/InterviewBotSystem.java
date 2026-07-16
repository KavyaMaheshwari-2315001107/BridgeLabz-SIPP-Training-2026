public class InterviewBotSystem {
    public static void main(String[] args) {
        InterviewBot bot1 = new InterviewBot("AlphaBot", "Java");
        InterviewBot bot2 = new InterviewBot("BetaBot", "Python");
        InterviewBot bot3 = new InterviewBot("GammaBot", "Data Science");

        bot1.conductInterview();
        bot2.conductInterview();
        bot3.conductInterview();
    }
}

class InterviewBot {
    private String botName;
    private String technology;

    public InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    public void conductInterview() {
        System.out.println(botName + " is conducting a " + technology + " interview.");
    }
}
