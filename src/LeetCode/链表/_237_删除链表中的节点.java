package LeetCode.链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 * @description: 删除链表节点
 * @create: 2020-06-24 17:13
 **/
public class _237_删除链表中的节点 {
    /**
     *  传统思路
     */
    public void deleteNode0(ListNode node) {
        // 找到要删除的节点的位置 ，没有 first ？怎么遍历
        // 找到前一个结点
        // 进行交接仪式
    }

    /**
     *  新思路
     */
    public void deleteNode(ListNode node) {
        // 用下一个节点 覆盖当前节点
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
