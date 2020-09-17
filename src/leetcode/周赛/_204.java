package leetcode.周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description:
 * @create: 2020-08-30-10:34
 * @finish:
 **/
public class _204 {
    public static void main(String[] args) {
        int[] arr2 = {1, 2, 1, 2, 1, 3};
        String string2 = Arrays.stream(arr2)
                .boxed()
                .map(
                        Objects::toString
////                        (x)->x.toString()
//                        (x)->Integer.toString(x)
                )
                .collect(Collectors.joining(""));
        System.out.println(string2);

        Integer a = 3;
        System.out.println(a.toString());
        System.out.println(a.toString().getClass());

        // 数组中内容是 引用的时候，转换为 list 的元素
        String[] arrayOfObject = {"zhang san", "lisi", "wang wu"};
        List list3 = new ArrayList(Arrays.asList(arrayOfObject)); //since it is our code that created the ArrayList, there is no restriction in adding or removing items.
        System.out.println(list3.size());

        int[] arr = {1, 2, 1, 2, 1, 3};
        //  !! 错误的转换
//        List list = Arrays.asList(arr);
//        System.out.println(list.size());

        // 纠正  1.8
        List list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());


        // !! 纠正  1.6  错误的，因为 arr 中的元素不是 引用类型，如果是引用类型则可以使用
//        ArrayList<Integer> list1 = new ArrayList(Arrays.asList(arr));
//        System.out.println(list1.size());
//        System.out.println(list1.get(0).getClass());

        // 纠正 1.6
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0).getClass());
//        String string = list.stream()
//                .map(Integer::)
    }

    class Solution {
//        public boolean containsPattern(int[] arr, int m, int k) {
//            if (arr.length < m * k) return false;
//
//            // 1.8 将数组转换为 字符串
//            String string2 = Arrays.stream(arr)
//                    .boxed()
//                    .map(Integer::toString)
//                    .collect(Collectors.joining(""));
//
//            if (arr.length == m * k) {
//            }
//
//            String string = Arrays.stream(arr)
//                    .boxed()
//                    .map(Object::toString)
//                    .collect(Collectors.joining(""));
//            return false;
//        }

//        public int getMaxLen(int[] nums) {
//
//        }
    }
}
