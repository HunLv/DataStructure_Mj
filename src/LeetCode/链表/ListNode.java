package LeetCode.链表;

/**
 * @program: DataStructure_Mj
 * @description: 链表的节点类型
 * @author: MH
 * @create: 2020-06-24 17:46
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str = "元素是"+val;
        return str;
    }
}
