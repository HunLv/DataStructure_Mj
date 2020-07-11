package LeetCode.链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @description: 移除链表元素
 * @create: 2020-06-26 18:03
 **/
public class _203_移除链表元素 { //TODO
//    public ListNode removeElements(ListNode head, int val) {
//
//    }
//
//    public ListNode removeElements_virtualHead(ListNode head, int val) {
//        // 虚拟头节点
//        ListNode virtualHead = new ListNode();
//        virtualHead.next = head;//第一个元素
//        ListNode temp = virtualHead;
//
//        while (temp.next != null) {
//            // 我的想法是——指针覆盖，条件是必须有 值为 val 的元素的指针
//            // 注意先判断是否存在，再比较，但是有一个问题，不能修改第一个元素
//            // 那这样，我自己加一个头节点，统一操作
//
//            if (temp.next.val == val) {
//                temp.next = temp.next.next;
//            }
//            temp = temp.next;
//        }
//        return head;
//    }

    public ListNode removeElements(ListNode head, int val) {
        // 链表含有元素，且第一个元素 为要删除的元素
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        } else { //有元素，且 head 指向的元素不是要删除的元素
            ListNode temp = head;
            while (temp.next != null) {
                // 我的想法是——指针覆盖，条件是必须有 值为 val 的元素的指针
                // 注意先判断是否存在，再比较，但是有一个问题，不能修改第一个元素

                // TODO 注意：案例[1,2,2,1]  2  预期 为[1,1] ，实际 为 [1,2,1]
                if (temp.next.val == val) {
                    temp.next = temp.next.next;
                }else { // TODO 开始把 else 丢了
                    temp = temp.next;
                }
            }
            return head;
        }
    }

    public ListNode removeElements_AC(ListNode head, int val) {
        // 链表含有元素，且第一个元素 为要删除的元素
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode temp = head;
        while (temp!= null) {
            // 我的想法是——指针覆盖，条件是必须有 值为 val 的元素的指针
            // 注意先判断是否存在，再比较，但是有一个问题，不能修改第一个元素
            // 那这样，我自己加一个头节点，统一操作

            if (temp.next!=null && temp.next.val == val) {
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}
