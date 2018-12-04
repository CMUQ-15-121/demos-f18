import java.util.Comparator;

public class BinarySearchTree<DataType extends Comparable<DataType>> {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void add(DataType item) {
        root = add(root, item);
    }

    /**
     * Example of a simple add helper, but not one we would really use.
     * @param root
     * @param item
     */
    public void addHelper(TreeNode root, DataType item) {
        if (item.compareTo(root.data) < 0) {
            if (root.left == null) {
                root.left = new TreeNode(item);
            } else {
                addHelper(root.left, item);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(item);
            } else {
                addHelper(root.right, item);
            }
        }
    }

    /**
     * A proper recursive add helper.
     * @param root
     * @param item
     * @return
     */
    public TreeNode add(TreeNode root, DataType item) {
        if (root == null) {
            return new TreeNode(item);
        }

        if (item.compareTo(root.data) < 0) {
            root.left = add(root.left, item);
        } else {
            root.right = add(root.right, item);
        }

        return root;
    }

    /**
     * Non-recursive method to determine if a given value is in the tree.
     * 
     * @param item The item to search for.
     * @return true if the item is in the tree, false otherwise
     */
    public boolean contains(DataType item) {
        TreeNode tmp = root;
        while (tmp != null) {
            int res = item.compareTo(tmp.data);
            if (res < 0) {
                tmp = tmp.left;
            } else if (res > 0) {
                tmp = tmp.right;
            }
            else {
                return true;
            }
        }
        return false;
    }
    
    public void printInOrder() {
        printInOrder(root);
    }

    // Recursive in-order printer
    public void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, root, 0);
        return sb.toString();
        
    }
    
    public void toString(StringBuilder sb, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        
        toString(sb, root.right, depth+1);
        
        // Put self in string, use sb.append()
        for(int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        sb.append(root.data);
        sb.append("\n");
        
        toString(sb, root.left, depth+1);
    }
    
    public class TreeNode {
        private DataType data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(DataType data) {
            this.data = data;
        }
    }
}
