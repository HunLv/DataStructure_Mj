package grammar.type.string;

/**
 * @description:
 * @create: 2020-07-28-13:36
 * @finish:
 **/
public class Main {
    public static void main(String[] args) {
        String string = "hello world";
        StringBuffer stringBuffer = new StringBuffer(string).reverse();

        System.out.println(stringBuffer);
    }
}
