import java.util.Scanner;

public class RPSGame {
    private static final int MAX_GAMES = 2000;
    private Player p1;
    private Player p2;

    public RPSGame(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // Return true if c1 beats c2, return false otherwise
    public boolean whoWon(char c1, char c2) {
        return (c1 == 'p' && c2 == 'r') || (c1 == 's' && c2 == 'p') || (c1 == 'r' && c2 == 's');
    }

    public void play() {
        int rounds = 0;

        while (true) {
            rounds++;
            char c1 = p1.move();
            char c2 = p2.move();
            
            System.out.println("Player 1 chose " + c1);
            System.out.println("Player 2 chose " + c2);

            if (whoWon(c1, c2)) {
                System.out.println("Player 1 wins the round.");
                p1.win();
            } else if (whoWon(c2, c1)) {
                System.out.println("Player 2 wins the round.");
                p2.win();
            }
            else {
                System.out.println("Tie!");
            }
            
            if (p1.getWins() == MAX_GAMES) {
                System.out.println("After " + rounds + " rounds...");
                System.out.println("Player 1 wins the game!");
                break;
            }
            else if (p2.getWins() == MAX_GAMES) {
                System.out.println("After " + rounds + " rounds...");
                System.out.println("Player 2 wins the game!");
                break;
            }

        }
        System.out.println("Player 1 wins: " + p1.getWins());
        System.out.println("Player 2 wins: " + p2.getWins());

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RPSGame game = new RPSGame(new ComputerPlayer(), new ComputerPlayer());
        game.play();
    }
}
