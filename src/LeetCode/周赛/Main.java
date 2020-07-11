package LeetCode.周赛;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 196 周赛
 * @create: 2020-07-05-10:52
 * @finish:
 **/
public class Main {
    public static void main(String[] args) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        };
        Integer[] my = {1, 2, 3};
        Arrays.sort(my);

        for (Integer a : my) {
            System.out.println(a);
        }
        Arrays.sort(my,cmp);
         for (Integer a : my) {
            System.out.println(a);
        }
    }
    public boolean canMakeArithmeticProgression(int[] arr) {
        Boolean flag1 = true;
        Boolean flag2 = true;
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2-i1;
            }
        };

        Arrays.sort(arr);
        int width = arr[1] - arr[0];
        for(int i = 1; i< arr.length; i++){
            if(arr[i] - arr[i-1] != width){
                flag1 = false;
            }
        }

        Integer[] integers1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(integers1,cmp);
        int width2 = arr[1] - arr[0];
        for(int i = 1; i< arr.length; i++){
            if(arr[i] - arr[i-1] != width2){
                flag1 = false;
            }
        }

        return flag1 && flag2;
    }

//    /**
//     * TODO
//     */
//    public int getLastMoment(int n, int[] left, int[] right) {
//        // 对于往左爬的蚂蚁，到悬崖的距离是当前的位置
//        // 对于往右爬的蚂蚁，到悬崖的距离是length - 当前的位置
//    }
//
//    /**
//     * TODO
//     */
//    public int numSubmat(int[][] mat) {
//
//    }
//
//    /**
//     * TODO
//     */
//    public String minInteger(String num, int k) {
//
//    }
}
