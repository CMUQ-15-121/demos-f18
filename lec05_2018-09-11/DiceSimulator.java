
public class DiceSimulator {
    
    public DiceSimulator(int numRolls, int numDice, int numSides) {
        int[] stats = new int[numSides*numDice+1];
        Die myDie = new Die(numSides);
        
        for(int i = 0; i < numRolls; i++) {
            int roll = 0;
            for(int j = 0; j < numDice; j++) {
                roll += myDie.roll();
            }
            stats[roll]++;
        }
        
        for(int i = 1; i < stats.length; i++) {
            System.out.println(i + ": " + stats[i] + " " + stats[i] * 100.0/numRolls + "%");
        }
    
    }

    public static void main(String[] args) {
        new DiceSimulator(1000000, 15, 3);
    }

}
