package grammar.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @create: 2020-08-02-22:12
 * @finish:
 **/
public class Demo {
    // 模板
    public static void test_() {
    }

    public static void main(String[] args) {
        test1_count();
        test2_ArrayToList();
    }

    // 数组 转 List
    public static void test2_ArrayToList() {
        int[] array = {1, 2, 3};

        List<Integer> list = Arrays
                .stream(array)            // 调用 Arrays 的stream() 创建 Stream todo
                .boxed()
                .collect(Collectors.toList());

        list.forEach(iterator -> {
            System.out.println(iterator);
        });
    }

    // 获取空字符串的数量
    public static void test1_count() {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        long count = list
                .stream()
                .filter(string -> string.isEmpty())
                .count();
        System.out.println(count);
    }
}
