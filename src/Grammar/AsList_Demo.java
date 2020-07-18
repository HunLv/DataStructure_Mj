package Grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: test Arrays.asList()
 * @create: 2020-07-15-11:07
 **/
public class AsList_Demo {
    /**
     * wrong code
     * Analyze: Arrays.asList() only accept parameter whose type is Object
     * Analyze: Arrays.asList() return a ArrayList whose value cannot be modify (use final)
     */
    public static void main_wrong(String[] args) {
        if (false){
            int[] array = {1, 2, 3};
            List list = Arrays.asList(array);// NOTE:  passing a primitive array to Arrays.asList() will not work.
            System.out.println(list.size()); //  the result is 1
            list.add(3); // NOTE: The returned list by the asList method is fixed sized and it can not accommodate more items.
        }
    }

    /**
     * solution
     * use Java 8  Stream
     */
    public static void solution() {
        int[] array = {1, 2, 3};
        List list = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(list.size());
        list.add(4);
        System.out.println(list.size());
    }

    /**
     *  参考：如果数组的类型是 Object ，
     *  那么可以 将 数组通过 Arrays.asList 转成的 长度固定的集合 传入到 ArrayList 的构造方法中，
     */
    public static void reference() {
        String[] arrayOfObject = {"zhang san", "lisi", "wang wu"};
        List list = new ArrayList(Arrays.asList(arrayOfObject)); //since it is our code that created the ArrayList, there is no restriction in adding or removing items.
        System.out.println(list.size());
        list.add(3);
        System.out.println(list.size());
    }
}
