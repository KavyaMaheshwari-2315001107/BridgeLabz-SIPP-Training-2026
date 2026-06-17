import java.util.Scanner;

public class RockPaperScissors9 {

    public static String computerChoice() {

        int num =
                (int) (Math.random() * 3);

        if (num == 0)
            return "rock";
        if (num == 1)
            return "paper";

        return "scissors";
    }

    public static String winner(
            String user,
            String computer) {

        if (user.equals(computer))
            return "Draw";

        if ((user.equals("rock") &&
             computer.equals("scissors")) ||

            (user.equals("paper") &&
             computer.equals("rock")) ||

            (user.equals("scissors") &&
             computer.equals("paper"))) {

            return "Player";
        }

        return "Computer";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Games: ");
        int games = sc.nextInt();

        int playerWins = 0;
        int computerWins = 0;

        System.out.println("\nGame\tWinner");

        for (int i = 1; i <= games; i++) {

            System.out.print(
                    "Enter rock/paper/scissors: ");

            String user = sc.next();

            String computer =
                    computerChoice();

            String result =
                    winner(user, computer);

            System.out.println(
                    i + "\t" + result);

            if (result.equals("Player"))
                playerWins++;

            else if
            (result.equals("Computer"))
                computerWins++;
        }

        double playerPercent =
                (playerWins * 100.0) / games;

        double computerPercent =
                (computerWins * 100.0) / games;

        System.out.println(
                "\nPlayer Wins = " + playerWins);

        System.out.println(
                "Computer Wins = " + computerWins);

        System.out.println(
                "Player % = " + playerPercent);

        System.out.println(
                "Computer % = " + computerPercent);

        sc.close();
    }
}