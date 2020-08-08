package leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @create: 2020-08-07-19:26
 **/

public class _94_二叉树的中序遍历 {
    ArrayList arrayList = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return arrayList;

        inorderTraversal(root.left);
        arrayList.add(root.val);
        inorderTraversal(root.right);
        return arrayList;
    }

    // 迭代 _ 通过 栈实现
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList arrayList = new ArrayList<Integer>();
        Stack stack = new Stack();

        if (root == null) return arrayList;

        TreeNode iterator = root;
        while (iterator != null) {
            stack.push(iterator);
            iterator = iterator.left;
        }

        while (!stack.isEmpty()) {
            TreeNode stackNode= (TreeNode) stack.pop();
            arrayList.add(stackNode.val);

            if (stackNode.right != null) {
                TreeNode iterator2 =stackNode.right;
                while (iterator2 != null) {
                    stack.push(iterator2);
                    iterator2 = iterator2.left;
                }
            }
        }
        return arrayList;
    }
}
