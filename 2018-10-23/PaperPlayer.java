
public class PaperPlayer implements Player {
    private int wins = 0;
    
    @Override
    public char move() {
        return 'p';
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
