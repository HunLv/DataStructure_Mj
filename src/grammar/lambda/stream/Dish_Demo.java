package grammar.lambda.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @description: 练习《Java 8 实战》书上的例子
 * @create: 2020-08-09-21:54
 * @finish:
 **/
public class Dish_Demo {
    public enum CaloricLevel {DIET, NORMAL, FAT}

    ;

    static class Dish {
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return name;
        }

        public enum Type {MEAT, FISH, OTHER}
    }

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


        /**
         * 自定义 分类规则
         */
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        System.out.println(dishesByCaloricLevel);
        /**
         *  对数据进行分组 按默认规定的类型分为 3 类
         */
        Map<Dish.Type, List<Dish>> map = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(map);

        /**
         * 使用 summingInt 计算所有菜肴 的卡路里 的总和 和 平均值
         */
        int calories = menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        double average = menu.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
        // 一次计算，得到各种结果
        IntSummaryStatistics intSummaryStatistics = menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));

        System.out.println(calories);
        System.out.println(average);
        System.out.println(intSummaryStatistics);

        /**
         * 连接字符串 所有菜单的名字
         */
        String shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(","));
        System.out.println(shortMenu);

        /**
         *  探索 收集器的本质
         */
        /**
         * 用 reduce 版本 计算 卡路里 总和
         */
        int calories2 = menu.stream()
                .collect(Collectors.reducing(
                        0,
                        Dish::getCalories,
                        (i, j) -> i + j
                ));
        System.out.println(calories2);
//        Optional<Dish> optionalDish= menu.stream()
//                .collect(Collectors.reducing(
//                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
//                ));
        /**
         * 用 reduce 版本 实现 拼接菜单名字
         */
        String menuNames1 = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.reducing((s1, s2) -> s1 + s2))
                .get();
        String menuNames2 = menu.stream()
                .collect(Collectors.reducing(
                        "",
                        Dish::getName,
                        (s1, s2) -> s1 + s2
                ));
        System.out.println(menuNames1);
        System.out.println(menuNames2);
        /**
         这无法编译，因为reducing接受的参数是一个BinaryOperator<t>，也就是一个
         BiFunction<T,T,T>。这就意味着它需要的函数必须能接受两个参数，然后返回一个相同类
         型的值，但这里用的Lambda表达式接受的参数是两个菜，返回的却是一个字符串。
         String menuNames3 = menu.stream()
         .collect(Collectors.reducing(
         (s1,s2)->s1.getName() + s2.getName()
         ))
         .get();
         */


//        list<integer> names = menu.stream()
//                .map(dish::getname)
//                .map(string::length)
//                .collect(collectors.tolist());
//        system.out.println(names.tostring());
//
//
//        optional<integer> calories = menu.stream()
//                .map(dish::getcalories)
//                .filter(x -> x > 5900)
//                .findany();
//
//        system.out.println(calories.ispresent());
//        system.out.println(calories.orelse(9));


//        List<String> names =
//                menu.stream()
//                        .filter(d -> {
//                            System.out.println("filtering " + d.getName());
//                            return d.getCalories() > 300;
//                        })
//                        .map(d -> {
//                            System.out.println("mapping " + d.getName());
//                            return d.getName();
//                        })
//                        .limit(3)
//                        .collect(toList());
//        System.out.println(names);

    }
}



