package leetcode.sort;

import java.util.Arrays;

/**
 * @description: 重写 冒泡排序
 * array [0,n)   n 个
 * 趟数  [0,n-1) n - 1 趟
 * 每趟 冒泡范围(后面的和前面的比较) [1,
 * @create: 2020-10-04-16:33
 * @finish:
 **/
public class BublleSort {
    //    用于交换数据的方法
    public static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // 不考虑任何优化
    public static void bubleSort(int[] array) {
        int n = array.length;
        // n - 1 趟接力
        for (int i = 0; i < n - 1; i++) {
            // 后面的兄弟们逐个和自己的前继比较
            // TODO 开始写错了的代码
//            for (int j = i + 1; j < n; j++) {
            // TODO 下标的确定让人恶心
            for (int j = 1; j <= n - 1 - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {99, 33, 5343, 44, 99999, 1, 33, 66};
        System.out.println(Arrays.toString(test));
        bubleSort(test);
        System.out.println(Arrays.toString(test));
    }

}
