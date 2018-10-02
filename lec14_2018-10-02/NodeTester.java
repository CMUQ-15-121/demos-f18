
public class NodeTester {

    public static void printNodes(ListNode n) {
        System.out.print("List Contents: ");
        
        for(ListNode tmp = n; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.data + " --> ");
        }
        
        /*
        ListNode tmp = n;
        while(tmp != null) {
            System.out.print(tmp.data + " --> ");
            tmp = tmp.next;
        }
        */
        System.out.println("<null>");
    }

    public static void main(String[] args) {
        
        // Create a simple, two-node list with A and B
        ListNode<String> startNode = new ListNode<String>("A");
        startNode.next = new ListNode<String>("B");
        printNodes(startNode);
        
        // Put Z onto beginning of list
        ListNode<String> newNode = new ListNode<String>("Z"); 
        newNode.next = startNode;
        startNode = newNode;
        printNodes(startNode);
        
        // Put G after Z, but before A.
        /*
        ListNode<String> t = startNode.next;
        startNode.next = new ListNode<String>("G");
        startNode.next.next = t; 
        */
        ListNode<String> g = new ListNode<String>("G");
        g.next = startNode.next;
        startNode.next = g;
        printNodes(startNode);
        
        // Remove a node from the middle
        
        // Remove the head node
        
        System.out.println(startNode.next.next.next);

    }

}
