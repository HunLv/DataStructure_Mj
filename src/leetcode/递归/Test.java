package leetcode.递归;

import java.util.Scanner;

/**
 * @description:
 * @create: 2020-07-03-20:24
 * @finish:
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        while (true){
//            int n = sc.nextInt();
//            System.out.println(fib(n));
//        }

//        while (true){
//            int i = sc.nextInt();
//            int j = sc.nextInt();
//            print2(i,j);
//        }

        int []tests = {11,22,11,22};
        System.out.println(sumOfArr(tests,tests.length));

    }

    /**
     * 1 返回 n 的阶乘 factorial
     * 数学上的递归定义：
     */
    static int fac(int n) {
        if (n == 1) return n;
        return n * fac(n - 1);
    }

    /**
     * 2 返回 第 n 项的 fib 数 Fibonacci
     * 数学上的递归定义
     */
    static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n-1) + fib(n-2);
    }

    /**
     *  3 打印 i 到 j ( i 小， j 大)
     *  要求： 不使用 for 循环
     *  j 为 迭代变量
     */
    static void print1(int i,int j){
        if (j < i) return;

        // 选 j 为迭代变量
        print1(i,j-1);
//        print(i,--j); // TODO wrong
//        print(i,j--); // TODO wrong
        System.out.println(j);// 到了边界 的时候，开始返回,从栈底执行 输出语句

    }
    /**
     *  写法 2
     *   i 作为 迭代变量
     */
    static void print2(int i,int j){
        if (i > j) return;

        System.out.println(i);
        print2(i + 1,j);
    }

    /**
     *  4 数组求和
     *  i 为起始位置
     *  要求：不使用 for 循环
     *  1 规模为 n 划分 为 1 + ( n -1 ) ：将所有元素求和问题划分为 ，最后一个元素 和 前面一堆元素求和问题
     *  2 寻找变化的量作为参数：数组的长度
     */
    static int sumOfArr(int[] arr,int length){
        // 1 什么时候不能划分呢？ 1 没有元素， 2 只有一个元素
        // 不能划分的时候返回什么？
        if (length == 0) return 0;
//        if (length == 1) return arr[1];  // TODO 这句是多余的

        return arr[length - 1] + sumOfArr(arr,length - 1);
    }



}
