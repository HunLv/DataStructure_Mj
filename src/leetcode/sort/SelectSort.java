package leetcode.sort;

import java.util.Arrays;

/**
 * @description: 重写 选择排序
 * 数组元素存储下标         array [0,length)
 * 趟数下标                i [0,length - 1)
 * 每趟比较的元素下标 [i)   j [i+1,length)
 * @create: 2020-10-04-16:13
 * @finish:
 **/
public class SelectSort {
//    用于交换数据的方法
    public static void swap(int array[],int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // 选择排序
    public static void selectSort(int[] array){
        int n = array.length;
        // 确定趟数
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            // 确定要比较的范围
            for (int j = i + 1; j < n; j++) {
                // 找到最小元素所在的下标
                if (array[j] < array[min]){
                    min = j;
                }
            }
            // TODO 如果没有比当前小的，其实是不用比较的
            swap(array,min,i);
        }
    }

    public static void main(String[] args) {
        int[] test = {99,33,5343,44,99999,1,33,66};
        selectSort(test);
        System.out.println(Arrays.toString(test));
    }
}
