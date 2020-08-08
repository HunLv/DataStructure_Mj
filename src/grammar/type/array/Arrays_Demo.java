package grammar.type.array;

import java.util.Arrays;

/**
 * @create: 2020-07-27-23:27
 * @finish:
 **/
public class Arrays_Demo {
    public static void main(String[] args) {
        int array[] = { 8, 7, 100, 88, 6, 4, 5, 33, 10 };

        // 直接适用 Arrays.toString() 打印数组，避免自己写循环
        System.out.println(Arrays.toString(array));
    }
}
