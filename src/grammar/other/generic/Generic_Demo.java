package grammar.other.generic;

/**
 * @description: 泛型练习
 * @create: 2020-07-19-09:22
 * @finish:
 **/
public class Generic_Demo {
    static class MyList{
        private Object[] elements=new Object[10];
        private int size;

        public void add(Object item) {
            elements[size++]=item;
        }

        public Object get(int index) {
            return elements[index];
        }
    }

    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.add(2);
        myList.add(2.3);
        myList.add("hello generic");
        System.out.println(myList.get(0));
        System.out.println((String)myList.get(1)); // 编译可以通过，但是运行报错，这就是 向上 转型 为 Object 的缺点
    }
}
