package data_structure.tree.threaded_binary_tree.data;

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

    @Override
    public String toString() {
        return "" + age;
    }
}
