import java.util.Random;

public class Deck {
    Card[] cards;
    int numCards;
    
    public Deck() {
        cards = new Card[52];
        
        for(int i = 0; i < 52; i++) {
            cards[i] = new Card(i);
        }
        
        numCards = 52;
    }
    
    public String toString() {
        String ret = "";
        for(int i = 0; i < 52; i++) {
            ret += cards[i];
            ret += "\n";
        }
        return ret;
    }
    
    public static void swap(Card[] arr, int idx1, int idx2) {
        Card tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    
    public void shuffle() {
        Random r = new Random();
        
        /*
         * Swap random cards 5000 times.
         * 5000 was used because 500 times looked pretty random
         * and multiplying that by 10 is almost certainly better.
         */
        for(int i = 0; i < 5000; i++) {
            int card1 = r.nextInt(52);
            int card2 = r.nextInt(52);
            
            swap(this.cards, card1, card2);
        }

    }
    
    /*
    public Card dealOneCard() {
        Card theCard = cards[numCards-1];
        numCards = numCards - 1;
        return theCard; 
    }
    */
    public Card dealOneCard() {
        return cards[--numCards];
    }
    
    
    public static void main(String[] args) {
        System.out.println("Hi there");
        Deck myDeck = new Deck();
        myDeck.shuffle();
        System.out.println(myDeck);
    }
    
}
