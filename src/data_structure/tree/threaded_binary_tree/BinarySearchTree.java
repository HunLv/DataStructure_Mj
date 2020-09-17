package data_structure.tree.threaded_binary_tree;

import data_structure.tree.threaded_binary_tree.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @description: 二叉搜索树
 * @create: 2020/08/29 20:33
 **/
public class BinarySearchTree<E> implements BinaryTreeInfo {
    /**/
    private Comparator<E> comparator;
    private int size;
    private Node<E> root;

//    private static class Node<E> {
//        E element;
//        Node parent;
//        Node leftChild;
//        Node rightChild;
//
//        public Node(E element, Node parent) {
//            this.element = element;
//            this.parent = parent;
//        }
//    }

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
        sb.append(suffice).append(node.element).append("\n");
        toString(node.leftChild, sb, suffice + "L");
        toString(node.rightChild, sb, suffice + "R");
    }

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

    /* 获取元素对应的结点 */
    private Node node(E element) {
        Node<E> node = root;
        while (node != null) {
            // 遍历到指定结点，注意 bst 元素的有序性, 不同于普通二叉树
            int cmp = compare(element, node.element);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.rightChild;
            } else {
                node = node.leftChild;
            }
        }
        return null;
    }

    public boolean contains(E element) {
        return false;
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

    /**************************** 增强遍历接口,用户可以自定义遍历节点时的操作 ***********************************/
    /**
     * 定义 遍历元素时 对元素的操作 接口
     */
    public static interface Vistor {
        /**
         * levelOrder_flexible() 遍历使用的接口 ，用于自定义用户处理逻辑
         */
        void visit(Node element);
    }

    /*中序 根 左 右*/
    public void inorderTraversal(Vistor vistor) {
        inorderTraversal(root, vistor);
    }

    private void inorderTraversal(Node<E> node, Vistor vistor) {
        if (node == null) return;
        inorderTraversal(node.leftChild, vistor);
        vistor.visit(node);
        inorderTraversal(node.rightChild, vistor);
    }

    /*前序 根 左 右*/
    public void preorderTraversal(Vistor vistor) {
        preorderTraversal(root, vistor);
    }

    private void preorderTraversal(Node node, Vistor vistor) {
        if (node == null) return;
        vistor.visit(node);
        preorderTraversal(node.leftChild, vistor);
        preorderTraversal(node.rightChild, vistor);
    }


//    /*后序 根 左 右*/
//    public void postorderTraversal(Vistor<E> vistor) {
//        postorderTraversal(root, vistor);
//    }
//
//    private void postorderTraversal(Node<E> node, Vistor<E> vistor) {
//        if (node == null) return;
//        postorderTraversal(node.leftChild, vistor);
//        postorderTraversal(node.rightChild, vistor);
//        vistor.visit(node.element);
//    }
//
//    /*层序遍历 */
//    public void levelOrder_flexible(Vistor<E> vistor) {
//        if (vistor == null) return;
//        levelOrder_flexible(root, vistor);
//    }
//
//    private void levelOrder_flexible(Node<E> node, Vistor<E> vistor) {
//        if (node == null) return;
//        Queue<Node<E>> queue = new LinkedList<>();
//
//        queue.offer(node);
//        while (!queue.isEmpty()) {
//            Node<E> iterator = queue.poll();
//            vistor.visit(iterator.element); // 将数据交给接口的方法处理，让用户通过接口自定义处理逻辑
//            if (iterator.leftChild != null) {
//                queue.offer(iterator.leftChild);
//            }
//            if (iterator.rightChild != null) {
//                queue.offer(iterator.rightChild);
//            }
//        }
//    }

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
        String parentString = "@";// @ 符号代表空
        String leftChild = "@";
        String rightChild = "@";
        if (iterator.parent != null) {
            // 记录 父节点的信息
            parentString = iterator.parent.element.toString();
        }
        if (iterator.leftChild != null) {
            leftChild = iterator.leftChild.element.toString();
        }
        if (iterator.rightChild != null) {
            rightChild = iterator.rightChild.element.toString();
        }
        return leftChild + "*" + iterator.element + "*" + rightChild;
    }


    /*中序 根 左 右*/
    public void inorderTraversal() {
        inorderTraversal(root);
        // 修改最后一个节点的指针
        if (pre.rightChild == null) {
            pre.rFlag = true;
        }
    }

    private void inorderTraversal(Node<E> node) {
        if (node == null) return;
        inorderTraversal(node.leftChild);
        visit(node);
        inorderTraversal(node.rightChild);
    }

    /* 核心代码 线索化*/
    Node pre = null;

    public void visit(Node<E> currentNode) {
//检查当前节点——左指针是否为 NULL，如果是，就设置前继索引，修改左指针为 Pre，并将当前节点的左索引标志位  置为 1，
        if (currentNode.leftChild == null) {
            currentNode.leftChild = pre;
            currentNode.lFlag = true;
        }
//检查前一个节点—— Pre 是否存在,且右指针是否为 NULL，如果是，则设置后继索引，修改右指针为 当前指针，并将 其右索引位置为   1，
        if ((pre != null) && (pre.rightChild == null)) {
            pre.rightChild = currentNode;
            pre.rFlag = true;
        }
//Pre 指向当前遍历的结点，开始遍历下一个结点，
        pre = currentNode;
    }

    /* 找到一棵树最左下方的节点 */
    private Node<E> findFirst(Node<E> node) {
        // 空指针检查 TODO 学习 Optional 后，请对代码重构
        if (node != null) {
            Node<E> iterator = node;
            // 保证传入的数据 不为空，
            while (iterator != null && iterator.lFlag != true) {
                iterator = iterator.leftChild;
            }
            return iterator;
        } else {
            System.out.println("非法数据传入");
            return null;
        }
    }

    /* 遍历中序线索二叉树的后继 */
    public void threadTraversal() {
//        1. 找到中序遍历的第一个节点
        Node node = findFirst(root);
        System.out.print(node.element + "* ");

        Node<E> iterator = node;
        while (iterator.rightChild != null) {
/*        2. 检查 rflag 索引位是否存在，若存在，则后继为 右孩子指向的内容；
        如果不存在，则一定有右子树，选择右子树最左面的元素（第一个访问的元素）作为后继。*/
            iterator = (iterator.rFlag == true ? iterator.rightChild : findFirst(iterator.rightChild));
            System.out.print(iterator.element + " ");
        }
    }
}
