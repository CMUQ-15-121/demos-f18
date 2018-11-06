import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private String word;
    private String guesses;

    public Hangman(int min, int max) {
        String[] theWords = new String[22000];
        int numWords = 0;

        // Open the file
        FileReader fr;
        try {
            fr = new FileReader("words.txt");
        } catch (FileNotFoundException e) {
            System.out.println("I could not open words.txt");
            return;
        }
        Scanner inp = new Scanner(fr);

        // Read in all valid words
        while(inp.hasNextLine()) {
            String tmpWord = inp.nextLine();
            if (tmpWord.length() >= min 
                    && tmpWord.length() <= max) {
                theWords[numWords++] = tmpWord;
            }
        }
        inp.close();

        // Pick a random word
        Random r = new Random();
        this.word = theWords[r.nextInt(numWords)];

        this.guesses = "";

        return;
    }

    /*
     * Return the word with dashes in place of letters
     * except for guessed letters.
     */
    public String getWord() {
        String ret = "";
        for(int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (guesses.indexOf(letter) == -1) {
                ret += "_ ";
            }
            else {
                ret += letter + " ";
            }
        }
        return ret;
    }

    private boolean isGameOver() {
        String output = getWord().replace(" ","");
        if (output.equals(word)) {
            return true;
        }
        else {
            return false;
        }
        /*
        if (output.indexOf("_") == -1) {
            return true;
        }
        else {
            return false;
        }
        */
    }
    
    public void play() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome to hangman!");

        while(true) {
            System.out.println("The Word: " + getWord());
            
            if (isGameOver()) {
                System.out.println("You win!");
                break;
            }
            
            System.out.println("Your guesses: " + this.guesses);
            System.out.print("Enter your guess: ");
            String theGuess = inp.nextLine();
            if (theGuess.length() == 1) {
                this.guesses += theGuess;
            }
        }
    }

    public static void main(String[] args) {
        Hangman h = new Hangman(5,8);
        h.play();
    }

}
