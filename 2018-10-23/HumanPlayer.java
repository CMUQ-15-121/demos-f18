import java.util.Scanner;

public class HumanPlayer implements Player {
    private int wins;
    private Scanner s;
    
    public HumanPlayer(Scanner s) {
        this.wins = 0;
        this.s = s;
    }
    
    public char move() {
        System.out.print("Choose [r]ock, [p]aper, or [s]cissors: ");
        String line = s.nextLine();
        return line.charAt(0);
    }
    
    public int getWins() {
        return this.wins;
    }
    
    public void win() {
        this.wins++;
    }
}
