package dynamic_array;

/**
 * @program: DataStructure_Mj
 * @description: 测试 ArrayList 的泛型版本
 * @author: MH
 * @create: 2020-06-20 23:07
 **/
public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    // 垃圾回收的时候回被调用
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Person "+name+"  dead");
    }


    // 自定义对象比较的标准， 如果没有实现，默认比较的是内存地址
    // TODO 完善， 如果将一个整数转化为 Person ,会报错
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Person){
            Person person = (Person) obj;
            return this.age == person.age;
        }
        // 不可以比较
        return false;
    }
}
