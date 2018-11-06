import java.util.Iterator;
import java.util.NoSuchElementException;

public class Roster implements Iterable<Person> {
    private static final int MAX_STUDENTS = 5;
    private Person[] theStudents;
    private int end;

    public Roster() {
        theStudents = new Person[MAX_STUDENTS];
        end = 0;
    }

    public int size() {
        return end;
    }

    public void addPerson(Person p) {
        if (end < MAX_STUDENTS) {
            theStudents[end++] = p;
        }
    }

    public Person getPerson(int idx) {
        if (idx < MAX_STUDENTS) {
            return theStudents[idx];
        } else {
            return null;
        }
    }

    public Iterator<Person> iterator() {
        return new RosterIterator();
    }

    public class RosterIterator implements Iterator<Person> {
        private int cur = 0;

        public boolean hasNext() {
            return (cur < end);
        }

        public Person next() {
            if (hasNext()) {
                return theStudents[cur++];
            }
            else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
