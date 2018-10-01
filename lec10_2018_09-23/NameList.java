import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NameList {
    // Name[] names;
    // int numNames;
    ArrayList<Name> names;

    public NameList(String filename) {
        // numNames = 0;
        // names = new Name[numLines(filename)];

        names = new ArrayList<Name>();

        Scanner inpFile = getFileScanner(filename);

        while (inpFile.hasNextLine()) {
            String line = inpFile.nextLine();
            String[] items = line.split("\t");
            if (items.length == 3) {
                Name tmpName = new Name(items[0], items[1], items[2]);
                // names[numNames++] = tmpName;
                names.add(tmpName);
            }
        }

        inpFile.close();
    }

    public Name getRandName() {
        Random r = new Random();
        // int num = r.nextInt(numNames);
        int num = r.nextInt(names.size());
        // return names[num];
        return names.get(num);
    }

    public Name getRandName(String origin) {
        /*
         * Things to think through: What if the origin doesn't exist in the list? What
         * about names with multiple origins?
         */
        return null;
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

    public String toString() {
        String ret = "";
        // for(int i = 0; i < numNames; i++) {
        for (Name n : names) {
            ret += n + "\n";
        }
        return ret;
    }

    public static void main(String args[]) {
        NameList nl = new NameList("GirlName.txt");
        System.out.println(nl.getRandName());
    }
}
