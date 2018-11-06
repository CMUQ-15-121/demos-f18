
public class ListNode<DataType> {
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
