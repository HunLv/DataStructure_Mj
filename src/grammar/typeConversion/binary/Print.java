package grammar.typeConversion.binary;

/**
 * reference:
 * 输出二进制前面未显示的零  https://stackoverflow.com/questions/4421400/how-to-get-0-padded-binary-representation-of-an-integer-in-java
 * 打印各种进制 https://blog.csdn.net/weixx3/article/details/78560048
 *
 * @description: 打印各种进制
 * @create: 2020-07-27-20:07
 **/
public class Print {
    public static void main(String[] args) {
        /** 2 进制( Java 默认是 有符号整数 ) **/
        System.out.println(Integer.toBinaryString(15));
        System.out.println(String.format("%32s", Integer.toBinaryString(15)).replace(" ", "0"));
        /** 8 进制 **/
        System.out.println(Integer.toOctalString(15));
        /** 16 进制 **/
        System.out.println(Integer.toHexString(15));
    }
}
