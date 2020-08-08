package grammar.type.bitOperation;

/**
 * @description: 位运算练习
 * @create: 2020-07-28-18:14
 * @finish:
 **/
public class BitOperation {
    public static void main(String[] args) {
        test_判断奇偶数(77);
        test_判断奇偶数(78);
        test_判断某位是0还是1(8);
    }

    public static void test(){}
    public static void test_判断奇偶数(int data){
        if ( (data & 1)== 1 ){
            System.out.println(data + "是奇数");
        }else {
            System.out.println(data + "是偶数");
        }
    }

    public static void test_判断某位是0还是1(int data){
        for (int i = 0; i < Integer.SIZE; i++) {
            System.out.println(data & (1 << i));
        }
    }

}

