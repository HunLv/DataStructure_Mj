package grammar.other.compare.comparable;

/**
 * @description:
 * @create: 2020-07-19-08:53
 **/
public class Person implements Comparable<Person> {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        return age - person.getAge();
    }
}
