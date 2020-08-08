package grammar.other.compare.comparable;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person(22);
        Person person2 = new Person(33);
        PersonManage personManage = new PersonManage();

        System.out.println(personManage.compare(person1,person2));
    }
}
