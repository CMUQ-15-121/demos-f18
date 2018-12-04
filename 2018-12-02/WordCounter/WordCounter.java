import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WordCounter {
    HashMap<String, Integer> wordFreq;

    public WordCounter(String filename) {
        wordFreq = new HashMap<String, Integer>();
        HashSet<String> bad = new HashSet<String>();
        bad.add(",");
        bad.add("'");
        bad.add(";");
        bad.add(".");
        bad.add("?");
        bad.add("\"");
        bad.add("!");
        bad.add("(");
        bad.add(")");
        bad.add("-");
        bad.add(":");
        bad.add("*");

        Scanner theFile = getFileScanner(filename);
        if (theFile == null) {
            System.err.println("Could not open " + filename);
            return;
        }

        while (theFile.hasNextLine()) {
            String theLine = theFile.nextLine().toLowerCase();
            for (String w : bad) {
                theLine = theLine.replace(w, "");
            }

            String[] words = theLine.split(" ");
            // System.out.println(Arrays.toString(words));

            for (String w : words) {
                if (!w.equals("")) {
                    if (wordFreq.containsKey(w)) {
                        int num = wordFreq.get(w);
                        wordFreq.put(w, num + 1);
                    } else {
                        wordFreq.put(w, 1);
                    }
                }
            }
        }

        ArrayList<String> wordList = new ArrayList<String>(wordFreq.keySet());
        wordList.sort(new MyComparator());
        for(int i = 0; i < 10; i++) {
            String word = wordList.get(i);
            int numTimes = wordFreq.get(word);
            System.out.println(word + " = " + numTimes);
        }
    }
    
    private class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            // Return < 0 if o1 occurs less frequently than o2
            // Return > 0 is o1 occurs more frequently than o2
            // Return 0 if they occur the same number of times
            
            int o1Times = wordFreq.get(o1);
            int o2Times = wordFreq.get(o2);
            
            return o2Times - o1Times;
        }
        
    }

    /*
     * Helper method to open files for reading. It returns a Scanner object that you
     * can use. Be sure to call .close() on that object when you are done.
     */
    public static Scanner getFileScanner(String filename) {
        Scanner myFile;
        try {
            myFile = new Scanner(new FileReader(filename));
        } catch (Exception e) {
            System.out.println("File not found: " + filename);
            return null;
        }
        return myFile;
    }

    public static void main(String[] args) {
        WordCounter w = new WordCounter("46.txt");
    }
}
