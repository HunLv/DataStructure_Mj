package tree.binarySearchTree;

import java.util.Comparator;

import tree.binarySearchTree.printer.BinaryTreeInfo;

/**
 * @description: 二叉搜索树
 * @create: 2020-07-18-11:50
 **/
public class BinarySearchTree<E> implements BinaryTreeInfo {
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

    /****************************核心***********************************/
    public void add(E element) {
        elementNotNullCheck(element);
        // 处理第一个结点
        if (size == 0){
            root = new Node<>(element, null);
            size ++;
            return;
        }
        // 处理其他节点
        // 1 遍历 找到 他所属的父节点 以及 确定 左右方向
        Node<E> parent = root;
        Node<E> iterator= root;
        int cmp = 0;
        while (iterator != null){
            cmp = compare(element,iterator.element);
            parent = iterator;
            if (cmp > 0){
               iterator = iterator.rightChild;
            }else if (cmp < 0){
               iterator = iterator.leftChild;
            }else { // 值相等  什么也不做
                return;
            }
        }// 出来的时候 iterator 已经 为 null 了，所以提前用 一个 parent 进行 记录

        // 2 创建 新节点
        Node node = new Node(element, parent);

        // 3 和父节点 建立 联系
        if (cmp > 0) { // 值比父节点大
            parent.rightChild = node;
        } else  {      // 值比父节点大
            parent.leftChild = node;
        }

        size ++;
    }

    public void remove(E element) {
    }

    public boolean contains(E element) {
        return false;
    }


    /****************************额外***********************************/
    /**
     * 判断元素是否为 NULL
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 用于遍历元素的时候进行比较大小
     * 比较 a 和 b 的 大小
     *
     * @param a
     * @param b
     * @return
     * a = b 返回  0;
     * a > b 返回  1;
     * a < b 返回 -1;
     */
    int compare(E a, E b) {
        if (comparator != null){
            return comparator.compare(a,b); // 使用用户指定的比较策略
        }else {
            return ((Comparable<E>)a).compareTo(b);// 使用数据 默认的比较策略
        }
    }

    /****************************用户打印二叉树（可视化）***********************************/
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E> )node).leftChild;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E> )node).rightChild;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if (myNode.parent != null) {
            // 记录 父节点的信息
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }
}
