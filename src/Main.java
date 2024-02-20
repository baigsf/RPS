import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            char playerAMove = getValidMove("Player A");
            char playerBMove = getValidMove("Player B");

            String result = determineWinner(playerAMove, playerBMove);

            System.out.println(playerAMove + " vs " + playerBMove + ": " + result);

            if (!playAgain(scanner)) {
                break;
            }
        }

        scanner.close();
    }

    private static char getValidMove(String playerName) {
        Scanner scanner = new Scanner(System.in);
        char move;

        while (true) {
            System.out.print(playerName + ", enter your move R/P/S: ");
            move = Character.toLowerCase(scanner.next().charAt(0));

            if (move == 'r' || move == 'p' || move == 's') {
                break;
            } else {
                System.out.println("Invalid key Please enter R, P, or S.");
            }
        }

        return move;
    }

    private static String determineWinner(char playerA, char playerB) {
        if (playerA == playerB) {
            return "It's a Tie!";
        } else if ((playerA == 'r' && playerB == 's') || (playerA == 'p' && playerB == 'r') || (playerA == 's' && playerB == 'p')) {
            return "Player A wins!";
        } else {
            return "Player B wins!";
        }
    }

    private static boolean playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (Y/N): ");
        char choice = Character.toLowerCase(scanner.next().charAt(0));
        return choice == 'y';
    }
}
