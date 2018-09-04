
public class Deck {
    Card[] cards;
    
    public Deck() {
        cards = new Card[52];
        
        for(int i = 0; i < 52; i++) {
            cards[i] = new Card(i);
        }
    }
    
    public String toString() {
        String ret = "";
        for(int i = 0; i < 52; i++) {
            ret += cards[i];
            ret += "\n";
        }
        return ret;
    }
    
    public void shuffle() {
        // To be filled in next class
    }
    
    public static void main(String[] args) {
        System.out.println("Hi there");
        Deck myDeck = new Deck();
        System.out.println(myDeck);
    }
    
}
