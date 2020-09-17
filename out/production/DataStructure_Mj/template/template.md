# 常用模板

## 二叉树——层序遍历

思路：使用栈实现

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode iterator = (TreeNode) queue.poll();
            // 自定义节点处理逻辑

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
```

## 二叉树——中序，前序遍历（迭代模板）

思路栈实现

```

```

## 二叉树——后序遍历（迭代模板）

