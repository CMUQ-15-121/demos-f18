
public class MyLinkedList<DataType> {

    private class ListNode {
        DataType data;
        ListNode next;

        public String toString() {
            return data.toString();
        }

        public ListNode(DataType data) {
            this.data = data;
            this.next = null;
        }
    }

    private ListNode head;
    private int size;

    // O(1)
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // O(1)
    public void addHead(DataType data) {
        // 1. Create a new node
        ListNode tmp = new ListNode(data);
        // 2&3. Make it the head of the list.
        tmp.next = head;
        head = tmp;
        size++;
    }

    // O(N)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List Contents: ");

        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            sb.append(tmp.data);
            sb.append(" --> ");
        }

        sb.append("<null>");
        return sb.toString();
    }

    // O(1)
    public boolean isEmpty() {
        return head == null;
    }

    // O(1)
    public int size() {
        return this.size;
    }

    // O(N)
    public void clear() {
        // head = null;
        ListNode tmp = head;
        while (tmp != null) {
            ListNode t = tmp.next;
            tmp.next = null;
            tmp = t;
        }

        head = null;
        size = 0;
    }

    // O(N)
    public boolean contains(DataType value) {
        boolean b = false;

        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.data.equals(value)) {
                b = true;
            }
        }
        return b;
    }

    // O(N)
    public DataType get(int index) {
        int cnt = 0;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            if (cnt == index) {
                return tmp.data;
            }
            cnt++;
        }
        String errorMsg = "Index: " + index + ", Size: " + cnt;
        throw new java.lang.IndexOutOfBoundsException(errorMsg);
    }

    // O(N)
    public int indexOf(DataType value) {
        int howMany = 0;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.data.equals(value)) {
                return howMany;
            }
            howMany++;
        }
        return -1;
    }

    // O(N)
    public boolean add(DataType value) {
        if (isEmpty()) {
            addHead(value);
        } else {
            ListNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new ListNode(value);
            size++;
        }
        return true;
    }

    // O(N)
    public boolean remove(DataType value) {

        if (head.data.equals(value)) {
            head = head.next;
            size--;
            return true;
        }

        for (ListNode tmp = head; tmp.next != null; tmp = tmp.next) {
            if (tmp.next.data.equals(value)) {
                // Remove tmp from list
                // Set previous node's next pointer to tmp.next
                tmp.next = tmp.next.next;
                size--;
                return true;
            }
        }
        return false;
    }

    public void printList() {
        printList(head);
        System.out.println("");
    }

    public void printList(ListNode n) {
        if (n == null) {
            System.out.print("<null>");
        } else {
            System.out.print(n.data + " --> ");
            printList(n.next);
        }
    }

    public void printReverseList() {
        printReverseList(head);
        System.out.println("");
    }

    public void printReverseList(ListNode n) {
        if (n == null) {
            System.out.print("<null>");
        } else {
            printReverseList(n.next);
            System.out.print(" --> " + n.data);
        }
    }

    public static void main(String args[]) {
        MyLinkedList<String> ml = new MyLinkedList<String>();
        System.out.println(ml.isEmpty());
        ml.addHead("A");
        ml.addHead("B");
        ml.addHead("C");
        System.out.println(ml);
        System.out.println(ml.isEmpty());
        System.out.println(ml.size());
        System.out.println(ml.contains("C"));
        System.out.println(ml.get(1));
        // System.out.println(ml.get(3));
        ml.clear();
        ml.add("A");
        ml.add("E");
        ml.add("F");
        ml.add("E");
        ml.add("G");
        ml.add("E");
        System.out.println(ml);

        // Don't do the following... it is O(N^2)
        // while(ml.remove("E") == true);

        ml.printList();
        ml.printReverseList();
    }

}
