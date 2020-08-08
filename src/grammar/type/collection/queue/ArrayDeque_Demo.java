package grammar.type.collection.queue;

import java.util.Queue;
import java.util.ArrayDeque;

/**
 * @description: ArrayDeque 练习
 * @create: 2020-08-05-17:19
 * @finish:
 **/
public class ArrayDeque_Demo {
    public TreeNode invertTree_AC(TreeNode root) {
        if (root == null) return null;

//        Queue queue = new LinkedList();
        Queue queue = new ArrayDeque<>(10);
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
