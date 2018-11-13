
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
    }

    /**
     * -integer if this < p
     * 0 if this == p
     * +integer if this > p
     */
    public int compareTo(Person p) {
        int f = this.firstName.compareTo(p.firstName);
        if (f != 0) {
            return f;
        }
        
        int l = this.lastName.compareTo(p.lastName);
        if (l != 0) {
            return l;
        }
        
        return this.age - p.age;
    }

}
