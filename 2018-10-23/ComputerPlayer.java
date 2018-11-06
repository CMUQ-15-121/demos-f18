import java.util.Random;

public class ComputerPlayer implements Player {

    private int wins = 0;
    private Random r = new Random();
    
    @Override
    public char move() {
        char[] choices = {'r', 'p', 's' };        
        int choice = r.nextInt(3);
        return choices[choice];
    }

    @Override
    public int getWins() {
        return this.wins;
    }

    @Override
    public void win() {
        this.wins++;
    }

}
