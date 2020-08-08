package leetcode.算法.处理数据;

/**
 * @description:
 * https://leetcode-cn.com/problems/reverse-bits/
 * @create: 2020-07-26-23:42
 * @finish:
 **/
public class _190_颠倒二进制位 {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
//        System.out.println(reverseBits(4294967293));
    }
    // you need treat n as an unsigned value
    public static String myReverseBits(int n) {
//        String temp = String.format("%32s",Integer.toBinaryString(n));
//        temp = temp.replace(" ","0");
        String binary =String.format("%32s",Integer.toBinaryString(n)).replace(" ","0");
        StringBuffer stringBuffer = new StringBuffer(binary).reverse();// 使用 StringBuffer 的 反转功能

        return stringBuffer.toString();

    }

    public static int reverseBits(int n) {
        String binary =String.format("%32s",Integer.toBinaryString(n)).replace(" ","0");
        StringBuffer stringBuffer = new StringBuffer(binary).reverse();// 使用 StringBuffer 的 反转功能
        System.out.println(stringBuffer.toString());
        return Integer.parseUnsignedInt(stringBuffer.toString(),2);// 将二进制字符串，转为 10 进制
    }
}
