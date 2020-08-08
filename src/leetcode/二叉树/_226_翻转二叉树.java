package leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 反转二叉树
 * @create: 2020-07-30-20:30
 * @finish:
 **/

public class _226_翻转二叉树 {
    // 前序遍历  AC
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 遍历到一个节点，就交换节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // 层序遍历
    public TreeNode invertTree_AC(TreeNode root) {
        if (root == null) return null;

        Queue queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode iterator = (TreeNode) queue.poll();
            // 交换节点
            TreeNode temp = iterator.left;
            iterator.left = iterator.right;
            iterator.right = temp;

            if (iterator.left != null) {
                queue.offer(iterator.left);
            }
            if (iterator.right != null) {
                queue.offer(iterator.right);
            }
        }
        return root;
    }

}
