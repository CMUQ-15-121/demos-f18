import java.util.Random;

public class BSTTester {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        
        tree.add(10);
        tree.add(7);
        tree.add(15);
        tree.add(5);
        tree.add(9);
        tree.add(14);
        tree.add(17);
        tree.add(6);
        
        
        /*
        Random r = new Random();
        for(int i = 0; i < 100; i++) {
            tree.add(r.nextInt(1000));
        }
        */
        
        
        tree.printInOrder();
        System.out.println(tree);
        
        System.out.println(tree.contains(6));
        System.out.println(tree.contains(16));
    }
}
