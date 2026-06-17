import java.util.Scanner;

public class RockPaperScissors9 {

    static String computerChoice() {

        int n = (int) (Math.random() * 3);

        if (n == 0) {
            return "rock";
        } else if (n == 1) {
            return "paper";
        }

        return "scissors";
    }

    static String winner(String user, String comp) {

        if (user.equals(comp)) {
            return "Draw";
        }

        if ((user.equals("rock") && comp.equals("scissors")) ||
                (user.equals("paper") && comp.equals("rock")) ||
                (user.equals("scissors") && comp.equals("paper"))) {
            return "Player";
        }

        return "Computer";
    }

    static String[][] stats(int playerWin, int computerWin, int games) {

        String[][] data = new String[2][3];

        double playerPercent = Math.round((playerWin * 100.0 / games) * 100.0) / 100.0;
        double computerPercent = Math.round((computerWin * 100.0 / games) * 100.0) / 100.0;

        data[0][0] = "Player";
        data[0][1] = String.valueOf(playerWin);
        data[0][2] = String.valueOf(playerPercent);

        data[1][0] = "Computer";
        data[1][1] = String.valueOf(computerWin);
        data[1][2] = String.valueOf(computerPercent);

        return data;
    }

    static void display(String[][] gameData, String[][] stats) {

        System.out.println("Game\tPlayer\tComputer\tWinner");

        for (int i = 0; i < gameData.length; i++) {
            System.out.println((i + 1) + "\t" + gameData[i][0] + "\t" + gameData[i][1] + "\t\t" + gameData[i][2]);
        }

        System.out.println();
        System.out.println("Name\tWins\tPercentage");

        for (String[] row : stats) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2] + "%");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int games = sc.nextInt();
        sc.nextLine();

        String[][] gameData = new String[games][3];

        int playerWin = 0;
        int computerWin = 0;

        for (int i = 0; i < games; i++) {

            String player = sc.nextLine().toLowerCase();

            String computer = computerChoice();

            String win = winner(player, computer);

            if (win.equals("Player")) {
                playerWin++;
            } else if (win.equals("Computer")) {
                computerWin++;
            }

            gameData[i][0] = player;
            gameData[i][1] = computer;
            gameData[i][2] = win;
        }

        String[][] result = stats(playerWin, computerWin, games);

        display(gameData, result);
    }
}