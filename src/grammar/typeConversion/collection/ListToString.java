package grammar.typeConversion.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ListToString {
    public static void main(String[] args) {
        System.out.println("java6");
        solution_java_6();
        System.out.println("java8");
        solution_java_8();
        System.out.println("java8_lamda");
        solution_java_8_stream();
    }

    public static void solution_java_6() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("huan", "bbb", "ccc"));
        /* 直接利用 list 自带*/
    }

    public static void solution_java_8() {
//        ArrayList<String> list = new ArrayList<>(Arrays.asList("huan", "bbb", "ccc"));
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('a','b','c'));

        /* 利用 String 的 join 拼接 list 列表中字符串*/
        String listString = String.join("", (CharSequence) list);
        System.out.println(listString);
    }

    public static void solution_java_8_stream() {
//        ArrayList<String> list = new ArrayList<>(Arrays.asList("huan", "bbb", "ccc"));
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,4));
        ArrayList<Double> list = new ArrayList<>(Arrays.asList(2.9,3.4));

        /* 用 stream  处理 ,可以处理 ArrayList 的各种类型 */
        String listString = list
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
        System.out.println(listString);
    }
}
