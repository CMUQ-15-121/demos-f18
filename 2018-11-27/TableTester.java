import java.util.ArrayList;
import java.util.Random;

public class TableTester {

    public static void main(String[] args) {
        MyHashTable<Integer> myHT = new MyHashTable<Integer>();
        ArrayList<Integer> myList = new ArrayList<Integer>();
        BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();
        
        Random r = new Random();
        
        System.out.println("Building the data structures");
        // Put random numbers into hash table
        for(int i = 0; i < 1000000; i++) {
            int rand = r.nextInt();
            myHT.add(rand);
            myList.add(rand);
            myTree.add(rand);
        }
        System.out.println("Finished building, now moving to testing");
        
        // Generate 10,000 random numbers for testing later
        int[] testing = new int[10000];
        for(int i = 0; i < testing.length; i++) {
            testing[i] = r.nextInt();
        }
        
        // Time contains
        MyTimer timer = new MyTimer();
        timer.startTiming();
        for(int i: testing) {
            myHT.contains(i);
        }
        timer.stopTiming();        
        System.out.println("Hash table took " + timer.elapsedTime() + " ms");
        
        timer.startTiming();
        for(int i: testing) {
            myTree.contains(i);
        }
        timer.stopTiming();        
        System.out.println("Tree took " + timer.elapsedTime() + " ms");
        
        timer.startTiming();
        for(int i: testing) {
            myList.contains(i);
        }
        timer.stopTiming();        
        System.out.println("ArrayList took " + timer.elapsedTime() + " ms");
       
    }
}
