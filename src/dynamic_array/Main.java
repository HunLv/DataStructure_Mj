package dynamic_array;

import tools.Asserts;

/**
 * @program: DataStructure_Mj
 * @description: 测试类
 * @author: MH
 * @create: 2020-06-20 20:54
 **/
public class Main {
    public static void main(String[] args) {
        ArrayList_Generic<Person> persons = new ArrayList_Generic<>();
        persons.add(new Person(22,"mh"));
        persons.add(new Person(32,"ah"));
        persons.add(new Person(32,"bh"));
        persons.add(new Person(32,"ch"));
        persons.add(new Person(32,"dhaaaaaak"));
        // TODO 添加的元素是否可以为 空？ 如果可以，要注意什么？
        // todo done 要注意 null.equals() 错误
        persons.indexOf(null);
        System.out.println(persons);
        persons.remove(2);
//        persons.set(3,new Person(10,"wanpihuan"));
        persons.clear();

        /*提醒 JVM 进行回收—— 如果相关对象实现了  finalize 方法，在回收的时候会调用*/
        System.gc();

//        System.out.println(persons);
//        ArrayList list = new ArrayList();
//        list.add(33);
//        list.add(3);
//        list.add(333);
//        list.add(334444);
//        list.add(334444);
//
//        list.add(list.size(),2222);
//        Asserts.test(list.size() == 6);
//        System.out.println(list.toString());
    }
}
