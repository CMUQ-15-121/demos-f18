import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JavaSortDemo {

    public static void main(String[] args) {
        int[] arr = { 42, 34, 89, 43, 75, 68, 76, 58, 7 };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        
        ArrayList<Integer> theList = new ArrayList<Integer>();
        theList.add(42);
        theList.add(34);
        theList.add(89);
        theList.add(43);
        theList.add(75);
        theList.add(68);
        theList.add(76);
        theList.add(58);
        theList.add(7);
        Collections.sort(theList);
        System.out.println(theList);
    }

}
