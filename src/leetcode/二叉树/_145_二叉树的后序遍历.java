package leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @create: 2020-08-07-19:42
 **/
public class _145_二叉树的后序遍历 {
    class Solution1 {
        ArrayList arrayList = new ArrayList();

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) return arrayList;

            postorderTraversal(root.left);
            postorderTraversal(root.right);
            arrayList.add(root.val);
            return arrayList;
        }
    }


    /**
     * 迭代版本的 后序遍历
     **/
    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> ansList = new ArrayList<>();

            if (root == null) return ansList;
            /** Ⅰ 左面一条巷子走到深 **/
            TreeNode iterator = root;
            while (iterator != null) {
                stack.push(iterator);
                iterator = iterator.left;
            }

            /** Ⅱ 遍历栈中的 数据 **/
            while (!stack.isEmpty()) {
                /* 先 查看一下栈顶元素的右子树（不是 pop 弹出来, 用 peek）
                 * 步骤：
                 * ① 如果 没有右子树了，就 pop ,并访问
                 * ② 如果 有，做两件事： 1 对右子树 重复 步骤 ① ;
                 *                     2 将当前 的栈顶 的右子树标记 为 null(下次再访问的时候表示——之前右子树已经在栈中处理过了)
                 * */
                if (stack.peek().right == null){
                    TreeNode stackNode = stack.pop();
                    ansList.add(stackNode.val);
                }else {
                    // 把 Ⅰ 的代码复制过来
                    TreeNode iterator2 = stack.peek().right;
                    TreeNode temp = stack.peek();
                    while ( iterator2 != null) {
                        stack.push(iterator2);
                        iterator2 = iterator2.left;
                    }
                    // 记得标记 当前栈顶的元素
                    temp.right = null;
                }
            }
            return ansList;
        }
    }
}
