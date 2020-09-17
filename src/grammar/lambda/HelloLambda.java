package grammar.lambda;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @description: 晚上看 lambda 有点激动，不瞌睡
 * @create: 2020-08-10-00:09
 **/
public class HelloLambda<T, R> {


    // 分析—— 遍历 list 是一种 频繁的操作，
    // 如果我在 遍历到元素位置后——根据行为的特征将元素处理的逻辑 抽象出来（分离行为）,
    // 那么，以后我只要指定我想对每个元素干什么就可以了，不需要再写遍历了。

    /* 场景一 ：使用 Consumer 抽象消费行为 accept (我只对数据进行消费，不生产中间结果) */
    public void consume(List<T> list, Consumer<T> consumer) {
        for (T element : list) {
// 原来这么写 ,写死了          System.out.println(element);
            consumer.accept(element);
            /*
             * void accept(T t);
             */
        }
    }

    /* 场景二 ：使用 Function 抽象输入输出变化行为 apply  (输入类型为 T，输出类型为 R) */

    /**
     * 出一道题
     * <p>
     * 统计  List 集合["lambdas","in","action"]中各元素的长度 , 保存到一个 List 中
     */

    public List<R> map(List<T> list, Function<T, R> f) {
        // 类型 R
        List<R> newList = new ArrayList<>();
        // 类型 T
        for (T element : list) {
            // 我想对数据进行处理，得到我想要的信息
            newList.add(f.apply(element));
            /**
             * R apply(T t);
             */
        }
        return newList;
    }

    /* 场景三 使用 Predicate 将数据的判断逻辑 抽象出来*/
    public List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();   // 存储筛选出来的元素
        for (T element : list) {
            // 我想对数据进行处理，得到我想要的信息
            if (predicate.test(element)) {
                /**
                 * boolean test(T t);
                 */

                newList.add(element);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        HelloLambda<String, Integer> helloLambda = new HelloLambda<>();
        /* 筛选数据 */
        List<String> listAfterFilter = helloLambda.filter(
                Arrays.asList("ain", "huan", "huan_huan", "huan", "xin"),
                // 书写
                (String element) -> element.startsWith("a")
                // 由于方法需要参数，不可以用方法引用
        );
        System.out.println(listAfterFilter.toString());
        /* 消费数据（打印）*/
        helloLambda.consume(
                // 进来的数据
                Arrays.asList("huan", "huan_huan", "huan"),
                /*
                1 先写 ()-> ,
                2 照着 Consume.accept() 原型的要求 填充 参数 和 语句
                */
//                (String i) -> System.out.println("λ 的神奇 " + i)
                // 等价写法
                System.out::println
        );

        /* 转换数据*/
        List<Integer> listOfapply = helloLambda.map(
                // 进来的数据
                Arrays.asList("huan", "huan_huan", "hello world"),
                /*
                1 先写 ()-> ,
                2 照着 Fuction.apply() 原型的要求 填充 参数 和 语句
                */
                // 普通写法
//                (String i) -> i.length()
                // 方法引用写法, 由于仅仅是调用数据的方法,可以使用
                String::length
        );
        System.out.println("listOfapply 的值为 " + listOfapply);

    }
}
