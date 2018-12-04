import java.util.ArrayList;

public class MyHashTable<DataType> {
    private static int tableSize = 65536*2*2*2;
    private ArrayList<DataType>[] table;
    
    public MyHashTable() {
        table = new ArrayList[tableSize];
        for(int i = 0; i < tableSize; i++) {
            table[i] = new ArrayList<DataType>();
        }
    }
    
    public void add(DataType item) {
        int hash = Math.abs(item.hashCode()) % tableSize;
        table[hash].add(item);
    }
    
    public boolean contains(DataType item) {
        int hash = Math.abs(item.hashCode()) % tableSize;
        return table[hash].contains(item);
    }
    
    public static void main(String[] args) {
        MyHashTable<Integer> myTable = new MyHashTable<Integer>();
        
        for(int i = 0; i < 10; i++) {
            myTable.add(i);
        }
        
        for(int i = 5; i < 15; i++) {
            System.out.println(myTable.contains(i));
        }
    }

}
