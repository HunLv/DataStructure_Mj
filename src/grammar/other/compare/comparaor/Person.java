package grammar.other.compare.comparaor;

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
    public int compareTo(Person e1) {
        return age - e1.age;
    }
}
