import java.util.ArrayList;
import java.util.Collections;

public class Tester {

    public static void main(String[] args) {
        ArrayList<Person> myList = new ArrayList<Person>();
        
        myList.add(new Person("Fred", "Jones", 40));
        myList.add(new Person("Bob", "Jones", 25));
        myList.add(new Person("Fred", "Jones", 15));
        myList.add(new Person("Tamim", "AlKuwari", 35));

        // Sort by natural ordering.
        Collections.sort(myList);
        for(Person p: myList) {
            System.out.println(p);
        }
        
        System.out.println("----------------");
        
        // Sort by age.
        Collections.sort(myList, new CompareByAge());
        for(Person p: myList) {
            System.out.println(p);
        }
    }

}
