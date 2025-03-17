import java.util.Comparator;

public class ComparatorImpl implements Comparator<Person> {

    @Override
    public int compare(Person person, Person t1) {
        return person.age - t1.age;
    }
}
