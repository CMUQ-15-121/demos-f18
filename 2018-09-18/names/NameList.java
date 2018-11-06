import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NameList {
    Name[] names;
    int numNames;
    
    
    public NameList(String filename) {
        numNames = 0;
        names = new Name[numLines(filename)];
        Scanner inpFile = getFileScanner(filename);
        
        while(inpFile.hasNextLine()) {
            String line = inpFile.nextLine();
            String[] items = line.split("\t");
            if (items.length == 3) {
                Name tmpName = new Name(items[0], items[1], items[2]);
                names[numNames++] = tmpName;
            }
        }
        
        inpFile.close();
    }
    
    private int numLines(String filename) {
        Scanner inp = getFileScanner(filename);
        int howm = 0;
        
        while(inp.hasNextLine()) {
            String line = inp.nextLine();
            howm++;
        }
        
        inp.close();
        
        return howm;
    }
    
    public Name getRandName() {
        Random r = new Random();
        int num = r.nextInt(numNames);
        return names[num];
    }
    
    public Name getRandName(String origin) {
        /*
         * Things to think through:
         *  What if the origin doesn't exist in the list?
         *  What about names with multiple origins?
         */
        return null;
    }
    
    /*
     * Helper method to open files for reading.
     * It returns a Scanner object that you can use.
     * Be sure to call .close() on that object when you are done.
     */
    public static Scanner getFileScanner(String filename)
    {
        Scanner myFile;
        try { 
            myFile = new Scanner(new FileReader(filename)); 
        } catch (Exception e) {
            System.out.println("File not found: " + filename);
            return null;
        }
        return myFile;
    }
    
    public String toString() {
        String ret="";
        for(int i = 0; i < numNames; i++) {
            ret += names[i] + "\n";
        }
        return ret;
    }
    
    public static void main(String args[]) {
        NameList nl = new NameList("GirlName.txt");
        System.out.println(nl.getRandName());
    }
}
