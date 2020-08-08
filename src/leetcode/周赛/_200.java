package leetcode.周赛;

import java.util.*;

/**
 * @description: 第200 场周赛
 * @create: 2020-08-02-10:19
 * @finish:
 **/
public class _200 {
    /*5475. 统计好三元组 */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    /* 5476. 找出数组游戏的赢家
     * 仍有问题
     *
     * 输入：arr = [1,9,8,2,3,7,6,4,5], k = 7
     * 输出：9
     *
     * 输入：arr = [3,2,1], k = 10
     * 输出：3
     * */
    public static int getWinner(int[] arr, int k) {
        if (k >= arr.length){ // 找最大元素
            // 转换为 集合找到最大的元素，  如果是 java 8 以上版本
//            List<Integer> list = Arrays
//                    .stream(arr)
//                    .boxed()
//                    .collect(Collectors.toList());

            // 转换为 集合找到最大的元素，  如果是 java 6
            List<Integer> list = new ArrayList<>();
            for (int i :arr) {
                list.add(i);
            }
            return Collections.max(list);// 使用 Collections 的一个好用的方法
        }
        int count = 0;
        int winter = arr[0];
        /* 先把数据模拟出来

           开始假设第一个元素是 擂主;
           然后将 擂主与下一个元素比较，
                如果比下一个元素大，擂主不变，将数据进行更新：失败者到队尾，其余元素前进;
                如果比下一个元素小，擂主更新为下一个元素新，将数据进行更新：失败者到队尾，其余元素前进。
         */
        while (count < k) {
            System.out.println(Arrays.toString(arr));
            if (winter > arr[1]) {
                // 迭代变量
                count ++;
                // 更新数组
                int temp = arr[1];
                for (int i = 2; i < arr.length; i++) {
                    arr[i-1] = arr[i];
                }
                arr[arr.length - 1] =temp;
            } else {
                // 更新擂主
                winter = arr[1];
                count = 1;

                //更新数组
                int temp = arr[0];
                for (int i = 1; i < arr.length ; i++) {
                    arr[i-1] = arr[i];
                }
                arr[arr.length - 1] =temp;
            }
        }
        return arr[0];
    }

    /** https://www.bilibili.com/video/BV1EK411n7ci **/

    public int getWinner_AC(int[] arr, int k) {
        int length = arr.length;
        if (k >= length) return Arrays.stream(arr).max().orElse(0);

        Deque<Integer> deque = new ArrayDeque<>(length); //todo
        for (int i:arr){
            deque.addLast(i);
        }

        int count = 0;
        while (count < k){
            int first = deque.removeFirst();
            int second = deque.removeFirst(); // TODO
            if (first > second){
                count ++;
                deque.addFirst(first);
                deque.addLast(second);
            }else {
                count = 1;
                deque.addFirst(second);
                deque.addLast(first);
            }
        }
        return deque.peekFirst(); // todo
    }

    public static void main(String[] args) {
//        int []arr = {2,1,3,5,4,6,7};
        int []arr = {1,11,22,33,44,55,66,77,88,99};
//        System.out.println(getWinner(arr,1000000));
    }

    /* */
    /* */
}
