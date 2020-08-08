package data_structure.tools;

/**
 * @program: DataStructure_Mj
 * @description: 断言类
 * @author: MH
 * @create: 2020-06-20 22:06
 **/
public class Asserts {
    public static void test(boolean value) {
        try {
            if (!value) throw new Exception("测试未通过");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
