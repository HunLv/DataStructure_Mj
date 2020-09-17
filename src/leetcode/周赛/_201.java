package leetcode.周赛;

import data_structure.stack.Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 201 单周赛
 * @create: 2020-08-09-10:11
 * @finish:
 **/
public class _201 {
    public static void main(String[] args) {
        System.out.println(makeGood("mc"));
    }

    /****/
    public static String makeGood(String s) {
        List<Character> stack = new LinkedList<>();
        stack.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
                continue;
            }
            boolean flag1 = Character.isUpperCase(stack.get(stack.size() - 1).charValue()) ? true : false;
            boolean flag2 = Character.isUpperCase(s.charAt(i)) ? true : false;
            boolean flag3 = stack.get(stack.size() - 1).charValue() == s.charAt(i) ? true : false;

            if (flag1 != flag2 && !flag3) {
                if (!stack.isEmpty()) stack.remove(stack.size() - 1);
            } else {
                stack.add(s.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
    /****/
    /****/
    /****/
}
