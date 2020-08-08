package leetcode.链表;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @description: 两两交换链表节点
 * @create: 2020-06-24 20:48
 **/
public class _24_两两交换链表中的节点 { // TODO
    public ListNode swapPairs(ListNode head) {
        // 1 找终止条件，只有一个节点，或者没有节点
        if(head == null || head.next == null) return head;

        // 2 找返回值，返回交换好节点的链表
        return head;
    }
}
