package leetcode.链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description: 从尾到头遍历链表
 * @create: 2020-07-13-17:49
 * @finish:
 **/
public class _剑指Offer_06_从尾到头打印链表 {
    public int[] reversePrint_AC(ListNode head) {
        ListNode iterator = head;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (iterator != null) {
            stack.push(iterator.val);
            iterator = iterator.next;
        }
        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }
        return arrayList.stream().mapToInt(Integer::valueOf).toArray();
    }

    //    错误写法
//    int ans[10001];
    int ans[] = new int[10001];
    int i = 0;

//    /**
//     * 尝试用递归
//     *
//     * @param head
//     * @return
//     */
//    public int[] reversePrint(ListNode head) {
//        if (head == null) return null;
//
//        reversePrint(head.next);
//        ans[i] = head.val;
//        return ans;
//    }
//
//    /**
//     * 迭代版本
//     *
//     * @param head
//     * @return
//     */
//    public int[] reversePrint(ListNode head) {
//        int count = 0;
//        int ans[] = new int[10001];
//        int reverseAns[] = new int[10001];
//
//        while (head != null && head.next != null) {
//            ans[i++] = head.val;
//            count++;
//        }
//
//        for (int i = 0; i < count; i++) {
//            reverseAns[count - 1 - i] = ans[i];
//        }
//        // 如果这时可以 动态创建一个数组就好了 —— 数组的大小可以指定为一个常数
//        return ans;
//    }
}
