package grammar.lambda.stream.map_demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 使用 map 方法批量处理数据 —— 求平方
 * @create: 2020-08-10-13:55
 **/
public class Numbers_Square {
    public static void main(String[] args) {
        List<Integer> words = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squareOfwords = words.stream()
                .map((x) -> {
                    System.out.println("map 方法里必须要有返回值,默认只有运算时，不需要写返回值，如果有多行，则必须写 return");
                    return x * x;
                })
                .collect(Collectors.toList());
        System.out.println(squareOfwords.toString());
    }
}
