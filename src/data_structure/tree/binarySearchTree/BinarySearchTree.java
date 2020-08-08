package data_structure.tree.binarySearchTree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import data_structure.tree.binarySearchTree.printer.BinaryTreeInfo;

/**
 * @description: 二叉搜索树
 * @create: 2020-07-18-11:50
 **/
public class BinarySearchTree<E> implements BinaryTreeInfo {
    /**/
    private Comparator<E> comparator;
    private int size;
    private Node<E> root;

    private static class Node<E> {
        E element;
        Node parent;
        Node leftChild;
        Node rightChild;

        public Node(E element, Node parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuffer sb, String suffice) {
        if (node == null) return;

//        System.out.println(node.element);
        sb.append(suffice).append(node.element).append("\n");
        toString(node.leftChild, sb, suffice + "L");
        toString(node.rightChild, sb, suffice + "R");
    }

    /****************************核心***********************************/
    public void add(E element) {
        elementNotNullCheck(element);
        // 处理第一个结点
        if (size == 0) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 处理其他节点
        // 1 遍历 找到 他所属的父节点 以及 确定 左右方向
        Node<E> parent = root;
        Node<E> iterator = root;
        int cmp = 0;
        while (iterator != null) {
            cmp = compare(element, iterator.element);
            parent = iterator;
            if (cmp > 0) {
                iterator = iterator.rightChild;
            } else if (cmp < 0) {
                iterator = iterator.leftChild;
            } else { // 值相等  什么也不做
                iterator.element = element;
                return;
            }
        }// 出来的时候 iterator 已经 为 null 了，所以提前用 一个 parent 进行 记录

        // 2 创建 新节点
        Node node = new Node(element, parent);

        // 3 和父节点 建立 联系
        if (cmp > 0) { // 值比父节点大
            parent.rightChild = node;
        } else {      // 值比父节点大
            parent.leftChild = node;
        }

        size++;
    }

    public void remove(E element) {
        remove(node(element));
    }
    private void remove(Node node){
    }
    /* 获取元素对应的结点 */
    private Node node(E element){
        Node<E> node = root;
        while (node != null){
            // 遍历到指定结点，注意 bst 元素的有序性, 不同于普通二叉树
            int cmp = compare(element,node.element);
            if (cmp == 0){
                return node;
            }else if (cmp > 0){
                node = node.rightChild;
            }else {
                node = node.leftChild;
            }
        }
        return null;
    }

    public boolean contains(E element) {
        return false;
    }

    /***4 种遍历方法 前中后 使用递归， 层序使用 队列**/
    /*前序 根 左 右*/
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node<E> node) {
        if (node == null) return;
        System.out.print("_" + node.element + "_");
        preorderTraversal(node.leftChild);
        preorderTraversal(node.rightChild);
    }

    /*中序  左 根 右*/
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<E> node) {
        if (node == null) return;
        inorderTraversal(node.leftChild);
        System.out.print("_" + node.element + "_");
        inorderTraversal(node.rightChild);
    }

    /*后序  左 右 根*/
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node<E> node) {
        if (node == null) return;
        postorderTraversal(node.leftChild);
        postorderTraversal(node.rightChild);
        System.out.print("_" + node.element + "_");
    }

    /* 层序遍历 */
    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(Node<E> node) {
        if (node == null) return;
        Queue<Node<E>> queue = new LinkedList<>();

//        1 将根 root节点放到 队列
        queue.offer(node);
        while (!queue.isEmpty()) {
//        2 取出 队首元素
            Node<E> iterator = queue.poll();
            System.out.print("_" + iterator.element + "_");

//        3 将 根的 left 和 right 分别放入队列
            if (iterator.leftChild != null) {
                queue.offer(iterator.leftChild);
            }
            if (iterator.rightChild != null) {
                queue.offer(iterator.rightChild);
            }
//        4 重复 2 -3 步骤 while 实现
        }
    }


    /****************************抛出传入的 数据 为 null 的异常 ***********************************/
    /**
     * 判断元素是否为 NULL
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 用于遍历元素的时候进行比较大小, 主要用到 了 Comparator 接口 和 Comparable 接口
     * 比较 a 和 b 的 大小
     *
     * @param a
     * @param b
     * @return a = b 返回  0;
     * a > b 返回  1;
     * a < b 返回 -1;
     */
    private int compare(E a, E b) {
        if (comparator != null) {
            return comparator.compare(a, b); // 使用用户指定的比较策略
        } else {
            return ((Comparable<E>) a).compareTo(b);// 使用数据 默认的比较策略
        }
    }


    /****************************增强遍历接口,用户可以自定义遍历节点时的操作(仅用层序演示)***********************************/
    /**
     * 定义 遍历元素时 对元素的操作 接口
     */
    public static interface Vistor<E> {
//        boolean stop = false; // 接口默认修饰符 **public static final**  不可行

        /**
         * 2
         * levelOrder_enhance() 遍历使用的接口，用户既可以定制节点处理逻辑，也可指定遍历到哪个节点停止
         */
        boolean visit(E element);

        /**
         * 1
         * levelOrder_flexible() 遍历使用的接口 ，用于自定义用户处理逻辑
         void visit(E element);
         */
    }

    /* 为了存放一个可以给递归公用的数据 stop, 设计如下 抽象类 */
    public static abstract class Abstract_Vistor<E> {
        boolean stop = false;

        abstract boolean visit(E element);
    }

    /**
     * 代码和之前的preorderTraversal()一致，
     * 唯一的不同就是——在遍历每个节点的时候，处理逻辑 独立出来了
     * 这里，仅实现层序遍历，其余 3 个遍历类似, 只需要在 原来的 写死的打印的地方 换为 调用接口方法 即可
     */
    public void levelOrder_flexible(Vistor<E> vistor) {
        if (vistor == null) return;
        levelOrder_flexible(root, vistor);
    }

    private void levelOrder_flexible(Node<E> node, Vistor<E> vistor) {
        if (node == null) return;
        Queue<Node<E>> queue = new LinkedList<>();

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> iterator = queue.poll();
//            System.out.print("_" + node.element + "_");  // 原来的代码
            vistor.visit(iterator.element); // 核心代码  对上面注释掉的代码进行 重构 ,将数据交给接口的方法处理，让用户通过接口自定义处理逻辑
            if (iterator.leftChild != null) {
                queue.offer(iterator.leftChild);
            }
            if (iterator.rightChild != null) {
                queue.offer(iterator.rightChild);
            }
        }
    }


    /*****************************实现遍历到指定节点便终止遍历的红能(4 中遍历方式都有)***************************************************************************************/

    /**
     * 层序
     **/
    public void levelOrder_enhance(Vistor<E> vistor) {
        if (vistor == null) return;
        levelOrder_enhance(root, vistor);
    }

    private void levelOrder_enhance(Node<E> node, Vistor<E> vistor) {
        if (node == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> iterator = queue.poll();
            if (vistor.visit(iterator.element)) return;// 核心代码 在这里处理逻辑 , 实现 到指定节点终止遍历的功能
            if (iterator.leftChild != null) {
                queue.offer(iterator.leftChild);
            }
            if (iterator.rightChild != null) {
                queue.offer(iterator.rightChild);
            }
        }
    }

    /**
     * 前序
     **/
    public void preorder_enhance(Abstract_Vistor<E> vistor) {
        if (vistor == null) return;
        preorder_enhance(root, vistor);
    }

    private void preorder_enhance(Node<E> node, Abstract_Vistor<E> vistor) {
        if (node == null || vistor.stop) return; // 核心代码

        if (vistor.stop) return; // 核心代码
        vistor.stop = vistor.visit(node.element); // 核心代码，将用户设置的 布尔值 保存到一个递归都可以访问的共享数据中
        preorder_enhance(node.leftChild, vistor);
        preorder_enhance(node.rightChild, vistor);
    }

    /**
     * 中序
     **/
    public void inorder_enhance(Abstract_Vistor<E> vistor) {
        if (vistor == null) return;
        inorder_enhance(root, vistor);
    }

    private void inorder_enhance(Node<E> node, Abstract_Vistor<E> vistor) {
        if (node == null || vistor.stop) return;

        inorder_enhance(node.leftChild, vistor);
        if (vistor.stop) return;
        vistor.stop = vistor.visit(node.element);
        inorder_enhance(node.rightChild, vistor);
    }

    /**
     * 后序
     **/
    public void postorder_enhance(Abstract_Vistor<E> vistor) {
        if (vistor == null) return;
        postorder_enhance(root, vistor);
    }

    private void postorder_enhance(Node<E> node, Abstract_Vistor<E> vistor) {
        if (node == null || vistor.stop) return;

        postorder_enhance(node.leftChild, vistor);
        postorder_enhance(node.rightChild, vistor);
        if (vistor.stop) return;
        vistor.stop = vistor.visit(node.element);
    }


    /****************************用户打印二叉树（可视化）主要使用了 printer 包下的工具，主要是实现 BinaryTreeInfo 接口***********************************/
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).leftChild;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).rightChild;
    }

    @Override
    public Object string(Object node) {
        Node<E> iterator = (Node<E>) node;
        String parentString = "null";
        if (iterator.parent != null) {
            // 记录 父节点的信息
            parentString = iterator.parent.element.toString();
        }
        return iterator.element + "_p(" + parentString + ")";
    }

    /********** 遍历的应用 ****************************************************/
    public int levelOrderTraversal_calcu() {
        return levelOrderTraversal_calcu(root);
    }

    /* 利用层序遍历计算 二叉树的 高度（层数）*/
    private int levelOrderTraversal_calcu(Node<E> node) {
        if (node == null) return 0;
        int height = 0; // 树的高度—— 总共有几层
        int levelSize = 1; // 每一层的元素数目
        Queue<Node<E>> queue = new LinkedList<>();

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> iterator = queue.poll();
            levelSize--;

            if (iterator.leftChild != null) {
                queue.offer(iterator.leftChild);
            }
            if (iterator.rightChild != null) {
                queue.offer(iterator.rightChild);
            }

            if (levelSize == 0) {// 遍历完 1 层
                height++; // 统计层数
                /*
                 统计下一层元素的数目 利用了队列的一个特点——
                 每层遍历完了之后，下一层的数目刚好是队列中元素的数目。
                 */
                levelSize = queue.size();
            }
        }
        return height;
    }

    /* 判断树是否是完全二叉树 */
    public boolean isLeaf(Node<E> node) {
        return node.leftChild == null && node.rightChild == null ? true : false;
    }


    public boolean levelOrderTraversal_isCompleteTree() {
        return levelOrderTraversal_isCompleteTree(root);
    }

    private boolean levelOrderTraversal_isCompleteTree(Node<E> node) {
        if (node == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        boolean isLeaf = false;

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> iterator = queue.poll();
            /*自定义层序遍历处理元素的逻辑*/
            if (isLeaf && !isLeaf(iterator)) return false;

            if (iterator.leftChild != null) {
                queue.offer(iterator.leftChild);
            } else if (iterator.rightChild != null) { // 01
                return false;
            }

            if (iterator.rightChild != null) {
                queue.offer(iterator.rightChild);
            } else { // 10 00 要求后续节点是 叶子节点
                isLeaf = true;
            }
        }
        return true; // 队列已经遍历完毕，没有有问题的节点
    }

    /**
     * 找前驱节点——中序遍历(左 根 右)的前一个节点
     **/
    /* 根据值找节点 */
//    private Node<E> FindNodeByValue(E e){
//    }
//    public E predecessor(E e) {
//        // 寻找 e 对应的节点  TODO 实现根据元素定位节点的方法
//    }
    private Node<E> predecessor(Node node) {
        Node predecessor = null;

        if (node.leftChild != null) { // 从左子树找，一定存在
//            Node iterator = node.leftChild;
//            predecessor = iterator;
//
//            while (iterator.rightChild != null) {
//                predecessor = iterator.rightChild; // 退出循环前记录下来满足条件的不为 null 的数据
//                iterator = iterator.rightChild;
//            }

            /*  代码优化，没必要考虑循环退出后数据 备忘的工作 */
            Node iterator = node.leftChild;
            while (iterator.rightChild != null) { //
                iterator = iterator.rightChild;
            }
            return iterator;

        } else {
            if (node.parent == null) {
                return null;
            } else {
                Node iterator = node;
                while (iterator.parent != null) {
                    if (iterator.parent.rightChild == iterator) { // 找到 和当前节点是 父右孩子关系的节点
                        predecessor = iterator.parent;
                        break;
                    }
                    iterator = iterator.parent;
                }

//                // 寻找最近的父节点，判断是否位于父节点的右侧
//                while (iterator.parent != null && iterator != iterator.parent.rightChild) {
//                    predecessor = iterator.parent;
//                    iterator = iterator.parent;
//                }
            }
        }

        return predecessor;
    }

    private Node<E> successor(Node node) {
        Node successor= null;

        if (node.leftChild != null) { // 从右子树找，一定存在
            Node iterator = node.leftChild;
            while (iterator.leftChild!= null) { //
                iterator = iterator.leftChild;
            }
            return iterator;
        } else {
            if (node.parent == null) {
                return null;
            } else {
                Node iterator = node;
                while (iterator.parent != null) {
                    if (iterator.parent.leftChild == iterator) { // 找到 和当前节点是 父右孩子关系的节点
                        successor = iterator.parent;
                        break;
                    }
                    iterator = iterator.parent;
                }
            }
        }
        return successor;
    }

}
