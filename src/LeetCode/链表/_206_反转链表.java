package LeetCode.链表;

/**
 *https://leetcode-cn.com/problems/reverse-linked-list/
 * @description: 反转链表
 * @create: 2020-06-24 17:39
 **/
public class _206_反转链表 {

    /**
     * TODO 下面的代码有问题
     */
    public ListNode reverseList_diedai(ListNode head) {
        // 一个空链表
        ListNode newHead = null;
        // 将 当前链表的 第一个队友交个新链表接管
        // 只要旧链表还有没交接的成员
//        while (head.next != null){ // todo done
        while (head != null) { // todo done
            // 1 离队之前保存队友信息
            ListNode temp = head.next;
            // 2 接管新队友
            head.next = newHead;
            // 3 和新老板打招呼
            newHead = head;
            // 4 旧老板接管剩余队友
            head = temp;
        }
        // 返回新链表
        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        // 1 递归边界时什么？ 链表没有元素，或者只有一个元素，我走到这里就开始返回了  TODO 这里是返回 什么呢 ？ return  还是 return head?
        // todo done
        if (head == null || head.next == null) return head;
//        if (head == null) return head;

        // 假设我处理完了除了旧链表的第一个节点的所有节点
        ListNode newHead = reverseList(head.next);
        // 2 现在 要处理的逻辑 都是一致的 ，选择最后一级（便于操作的） 进行业务处理
        // 2.1 将旧链表的第一个节点转交 新链表管理
        // TODO 出错了
        head.next.next = head;  // head 当前是 旧链表最后一个节点的指针， head.next.next 是新链表的最后一个节点
        head.next = null;      // 新节点的指针域指向 null

        // 3 我应该给上一级返回什么呢？当然是处理好的新链表
        return newHead;
    }
}


