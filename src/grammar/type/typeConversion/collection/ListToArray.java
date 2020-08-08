package grammar.type.typeConversion.collection;

import java.util.*;

/**
 * @description: list——>array
 * @create: 2020-07-27-23:49
 * @finish:
 **/
public class ListToArray {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("3");
        list.add("3");
        Object[] string = list.toArray();
        System.out.println(Arrays.toString(string));
        System.out.println(list instanceof Collection);
    }
//    public int[] test(List list){
////        return list.toArray();
//    }
}
