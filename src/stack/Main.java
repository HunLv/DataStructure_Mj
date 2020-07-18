package stack;


/**
 * @description: 测试 Stack
 * @create: 2020-07-15-23:55
 * @finish:
 **/
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);


        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main_0(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
    }
}
