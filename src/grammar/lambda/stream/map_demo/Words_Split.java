package grammar.lambda.stream.map_demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @description: 切分单词
 * @create: 2020-08-10-12:02
 * @finish:
 **/
public class Words_Split {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Lambdas", "Lambdas", "In", "Action");

        /* 符合要求的做法,
            map 之后 Stream 内容的变化
            String -> String[]

            flapMap 之后 Stream 内容的变化
            String[] -> String
         */
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters.toString());

        /* 不符合要求的做法,
            map 之后 Stream 内容的变化
            String -> String[]
         */
        List<String[]> alpha = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        for (String[] s : alpha) {
            System.out.println(Arrays.toString(s));
        }

        /** 尝试利用 Arrays.stream() 将接收到的数组转化成流，
         但是，最后效果是
         the Stream of String[] 变成了  the Stream of Stream of String[]

         map 之后 Stream 内容的变化
         String -> the Stream of String[]
         **/
        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        String[][][] integers = {{{"hello", "huan"}, {"w"}, {"o"}, {"l"}}};
        List<String[][]> list = Arrays.asList(integers);
        List<String> list1 = list
                .stream()
                .flatMap(Arrays::stream)
                .flatMap(Arrays::stream)
                .map((x) -> x.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list1);

        // TODO  理解不了
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(Collectors.toList());
    }
}
