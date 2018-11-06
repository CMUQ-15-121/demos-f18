import java.util.Scanner;

public class HiLoGame {

    public static void main(String[] args) {
        Scanner userInp = new Scanner(System.in);
        Deck theDeck = new Deck();
        theDeck.shuffle();
        
        int money = 100000;
        
        while(true) {
            System.out.println("Welcome to hi-lo");
            System.out.println("You have $"+money);
            
            System.out.print("What is your bet? ");
            int pot = userInp.nextInt();
            money = money - pot;
            
            Card theCard = theDeck.dealOneCard();
            while(true) {
                System.out.println("Current pot is $"+pot);
                System.out.println("Current card is: " + theCard);
                
                System.out.print("Will the next card be (h)igher or (l)ower or (s)top? ");
                String response = userInp.next();
                
                if (response.equals("s")) {
                    money += pot;
                    pot = 0;
                    break;
                }
                
                Card anotherCard = theDeck.dealOneCard();
                System.out.println("New card is: " + anotherCard);      
                
                if (anotherCard.getNumber() < theCard.getNumber() && response.equals("l")) {
                    System.out.println("You win!");
                    pot *= 2;
                }
                else if (anotherCard.getNumber() > theCard.getNumber() && response.equals("h")) {
                    System.out.println("You win!");
                    pot *= 2;
                }
                else if (anotherCard.getNumber() == theCard.getNumber()) {
                    System.out.println("Tie!");
                }
                else {
                    System.out.println("You lose!");
                    pot = 0;
                    break;
                }
                theCard = anotherCard;
            }
        }
        
        
        

    }

}
