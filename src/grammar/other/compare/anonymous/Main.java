package grammar.other.compare.anonymous;

import java.util.Comparator;

/**
 * 匿名 Comparator
 */
public class Main {

    public static void main(String[] args) {

       PersonManage<Person> personManage = new PersonManage<>(new Comparator<Person>() {
           @Override
           public int compare(Person o1, Person o2) {
               return o1.getAge() - o2.getAge();
           }
       });

        /**
         *   写法
         * PersonManage<Person> personManage = new PersonManage<>((o1, o2) -> o1.getAge() - o2.getAge());
         */
        PersonManage<Person> personManage2 = new PersonManage<>((o1, o2) -> o1.getAge() - o2.getAge());
    }
}
