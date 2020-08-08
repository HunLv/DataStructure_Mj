package grammar.type.typeConversion.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: test Arrays.asList()
 * @create: 2020-07-15-11:07
 **/
public class ArrayToList {
    public static void main(String[] args) {
        int[] array = {22, 1, 2, 3, 4, 4};
        solution_java_6(array);
    }

    /**
     * wrong code
     * Analyze: Arrays.asList() only accept parameter whose type is Object
     * Analyze: Arrays.asList() return a ArrayList whose value cannot be modify (use final)
     */
    public static void main_wrong(String[] args) {
        int[] array = {1, 2, 3};
        List list = Arrays.asList(array);// NOTE:  passing a primitive array to Arrays.asList() will not work.
        System.out.println(list.size()); //  the result is 1
        list.add(3); // NOTE: The returned list by the asList method is fixed sized and it can not accommodate more items.
    }

    /**
     * solution
     * 注意：蓝桥杯 是 Java  1.6, 不支持..
     * use Java 8  Stream
     */
    public static void solution_java_8() {
        int[] array = {1, 2, 3};
        List<Integer> list = Arrays
                .stream(array)
                .boxed()
                .collect(Collectors.toList());

        list.add(4);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    /**
     * solution 先创建一个 List ,然后将元素逐个添加进去
     * Java 1.6
     */
    public static void solution_java_6(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }

        for (Integer value : list) {
            System.out.println(value);
        }
    }

    /**
     * 参考：如果数组的类型是 Object ，
     * 那么可以 将 数组通过 Arrays.asList 转成的 长度固定的集合 传入到 ArrayList 的构造方法中，
     */
    public static void reference() {
        String[] arrayOfObject = {"zhang san", "lisi", "wang wu"};
        List list = new ArrayList(Arrays.asList(arrayOfObject)); //since it is our code that created the ArrayList, there is no restriction in adding or removing items.
        System.out.println(list.size());
        list.add(3);
        System.out.println(list.size());
    }
}
