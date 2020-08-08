package leetcode.二叉树;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 前序遍历
 * @create: 2020-07-30-21:19
 * @finish:
 **/
public class _144_二叉树的前序遍历 {

//    List list = new ArrayList();
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) return list;
//
//        list.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return list;
//    }

    // 迭代 _ 通过 栈实现
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList arrayList = new ArrayList<Integer>();
        Stack stack = new Stack();

        if (root == null) return arrayList;

        TreeNode iterator = root;
        // I
        while (iterator != null) {
            arrayList.add(iterator.val);
            stack.push(iterator);
            iterator = iterator.left;
        }

        while (!stack.isEmpty()) {
            TreeNode stackNode= (TreeNode) stack.pop();

            if (stackNode.right != null) {
                // 复制 I 的代码
                TreeNode iterator2 =stackNode.right;
                while (iterator2 != null) {
                    arrayList.add(iterator2.val);
                    stack.push(iterator2);
                    iterator2 = iterator2.left;
                }
            }
        }
        return arrayList;
    }
    /* 学习 lgw 的代码 */
    //经典的非递归实现方式   16 行
    public List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null) {
                res.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            //没有左子树了
            cur=stack.pop();
            //切换为右子树
            cur=cur.right;
        }
        return res;
    }
//    教科书上的写法，经典的前序遍历非递归实现方式   有点类似层序遍历的写法,不过层序遍历使用的是队列
    // 参考 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode/
    // 本问题就是用宽度优先搜索遍历来划分层次：[[1], [2, 3], [4, 5]]。 TODO
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top=stack.pop();
            res.add(top.val);
            //注意顺序
            if (top.right!=null) {
                stack.push(top.right);
            }
            if (top.left!=null) {
                stack.push(top.left);
            }
        }
        return res;
    }
}
