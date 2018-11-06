import java.util.Iterator;

public class RosterTester {

    public static void main(String[] args) {
        Roster r = new Roster();
        
        r.addPerson(new Person("Bob"));
        r.addPerson(new Person("Fred"));
        r.addPerson(new Person("John"));
        
        /*
        for(int i = 0; i < r.size(); i++) {
            System.out.println(r.getPerson(i));
        }
        */
       
        Iterator<Person> it = r.iterator();
        while(it.hasNext()) {
            Person p = it.next();
            System.out.println(p);
        }
        
        /*
        for(Person p: r) {
            System.out.println(p);
        }
        */
    }
    
}
