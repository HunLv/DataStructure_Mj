package leetcode.算法.处理数据;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @create: 2020-07-28-16:07
 * @finish:
 **/
public class _7_整数反转 {
    public static void main(String[] args) {
        System.out.println(reverse(146503774));
    }

    public static int reverse(int x) {
        int ans = 0;
        int iterator = x;
        while (iterator != 0) {
            int last = iterator % 10; // 取个位
            ans = ans * 10 + last;    // 原来的数进位，加上个位
            iterator = iterator / 10; // 原来的数舍掉个位
        }
        return ans;
    }
    //https://www.bilibili.com/video/BV1654y1D7u1  越界处理 参考


}
