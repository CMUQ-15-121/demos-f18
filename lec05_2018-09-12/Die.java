import java.util.Random;

public class Die {
    // Instance variables
    private int numSides;
    
    
    // Constructors
    public Die(int numSides) {
        this.numSides = numSides;
    }
    
    // Methods
    public int roll() {
        Random myRand = new Random();
        return myRand.nextInt(this.numSides)+1;
    }
    
    public int getNumSides() {
        return this.numSides;
    }
}
