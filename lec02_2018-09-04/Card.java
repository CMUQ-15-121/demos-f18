
public class Card {
    int number;
    int suit;
    
    String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    
    public Card(int cardNum) {
        this.suit = cardNum/13;
        this.number = cardNum%13;
    }
    
    public String toString() {
        return faces[this.number] + " of " + suits[this.suit];
    }

}
