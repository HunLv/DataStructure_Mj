package data_structure.tree.binarySearchTree.data;

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
        return "age=" + age;
    }
}
