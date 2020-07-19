package Grammar.compare.official;

import java.util.Comparator;

public class Main {

    /**
     *  继承的接口必须指定具体类型
     */
    static class MyCompator_1 implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }
    static class MyCompator_2 implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    public static void main(String[] args) {
        PersonManage<Person> personManage = new PersonManage<>();
        PersonManage<Person> personManage_1 = new PersonManage(new MyCompator_1());
        PersonManage<Person> personManage_2 = new PersonManage(new MyCompator_2());

    }
}
