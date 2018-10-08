
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

    // O(1)
    public MyLinkedList() {
        head = null;
    }

    // O(1)
    public void addHead(DataType data) {
        // 1. Create a new node
        ListNode tmp = new ListNode(data);
        // 2&3. Make it the head of the list.
        tmp.next = head;
        head = tmp;
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

    // O(N) -- Hmmm.
    public int size() {
        int howMany = 0;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            howMany++;
        }
        return howMany;
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
        System.out.println(ml.get(3));
        
        // O(N^2)
        for(int i = 0; i < ml.size(); i++) {
            System.out.println(ml.get(i));
        }
    }

}
