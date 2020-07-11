package LeetCode.链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @description: 给定一个链表，判断链表中是否有环。
 * @create: 2020-06-25 08:43
 **/
public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        // 如果仅有一个节点，或者没有节点，视为无环
        if (head == null || head.next == null) return false;// 下面 至少有 2 个节点

        ListNode slow = head;
        ListNode fast = head.next;

//        // 开始跑步 ,慢的，一次 1 步，快的，一次 2 步，如果快的先到达 null ,无环；如果快慢相遇（slow == fast）,有环
//        slow = slow.next;
//        fast = fast.next.next;

        // 跑多久呢？ 怎么控制呢?
        while (true) {
            // 开始跑步 ,慢的，一次 1 步，快的，一次 2 步，如果快的先到达 null ,无环；如果快慢相遇（slow == fast）,有环
            // TODO  空指针异常
            if (fast.next != null){ // 快的 要先判断能不能走，有没有桥 , fast 起到 探路的作用
                fast = fast.next.next;
            }else { // fast 走不了，中间的桥断了 ，提前 null
                return false;
            }
            slow = slow.next;

            // 这两句有没有先后顺序？ 如果有终点，一定是 fast 先到，所以先判断，是否到了终点
            if (fast == null) return false;
            if (fast == slow) return true;
        }
    }

    // mj 的代码
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        // TODO 判断是有先后顺序的，否则会出现 空指针异常
        while( (fast != null) && (fast.next != null)){
            if(fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
