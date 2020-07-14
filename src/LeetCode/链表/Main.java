package LeetCode.链表;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @description: 测试
 * @create: 2020-07-02-23:41
 * @finish:
 **/
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(44);
        stack.push(33);
        for (int x:stack){
            System.out.println(x);
        }
        while (! stack.empty()){
            System.out.println(stack.pop());
        }
    }
    public static void main1(String[] args) {

//        // 字符串默认是按字母进行排序,元素内部自动处理排序
//        Set<String> set1 = new TreeSet<>();
//        set1.add("bin ");
//        set1.add("aao");
//        set1.add("cihao");
//        System.out.println(set1.toString());

        // 取出顺序和存放顺序一致
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("bin");
        set2.add("aao");
        set2.add("cihao");
        System.out.println(set2.toString());

        // 判断数组中是否含有 容器中的元素
        String []test = {"bin","bbb","bin","ddd","eee","fff"};
        for(String string :test){
            if (set2.contains(string)){
                System.out.println(string+"在容器中");
            }
        }
    }
}
