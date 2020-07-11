package LeetCode.链表;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @description: 83. 删除排序链表中的重复元素
 * @finish: 15:00
 **/
public class _83_删除排序链表中的重复元素 {// TODO

    //    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    public Set<Integer> deleteDuplicates_1(ListNode head) {
        Set<Integer> set = new LinkedHashSet<>();
        ListNode temp = head;
        while (temp != null) {
            set.add(temp.val);
            temp = temp.next;
        }
        return set;
    }// 可以返回 所有元素，但是不符合题目要求，题目要求返回只出现一次的数组

    public ListNode deleteDuplicates_AC(ListNode head) {
        ListNode temp = head;
        Set<Integer> set = new LinkedHashSet<>();
        // 增加虚拟头节点 统一操作
        ListNode virtuNode = new ListNode(-1);
        virtuNode.next = temp;
        temp = virtuNode;

        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                // 删除
                temp.next = temp.next.next;

            } else {
                set.add(temp.next.val);
                temp = temp.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates_AC2(ListNode head) {
        // 6 完善逻辑
        if (head == null || head.next == null) return head;
        // 2 实现需要的数据结构
        // 前一个结点
        ListNode pre = head;
        // 当前处理的结点
        ListNode cur = head.next;

//        // 1 处理的逻辑
//        while(node != null){              // 从第二个开始遍历每一个元素
//            if (node.var == pre.var) 删除;//如果和前面的元素相同，就删除
//            else  更新为下一个节点        // 处理下一个节点
//        }
//        // 3 关键实现语句
//        while (cur != null) {
//            if (cur.val == pre.val) pre.next = cur.next;
//            else  cur = cur.next;
//        }
        // 4 完整实现语句
        while (cur != null) {
            if (cur.val == pre.val) { // pre 指针的后面一个元素 更新
                pre.next = cur.next;
                cur = cur.next; // 迭代
            }
            else {                    // 迭代
                cur = cur.next;
                pre = pre.next;
            }
        }

        return head;
    }
}
