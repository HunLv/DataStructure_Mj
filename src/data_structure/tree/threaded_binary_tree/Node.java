package data_structure.tree.threaded_binary_tree;

public class Node<E> {
    E element;
    /**
     *  TODO 如果没有父结点，如何实现？ 2020 10 08 17:32
     */
    Node<E> parent;
    Node<E> leftChild;
    Node<E> rightChild;
    /**
     * 在原来二叉树的基础上添加了 2 个字段 用于标识是否已经线索化
     */
    Boolean lFlag = false;
    Boolean rFlag = false;

    public Node(E element, Node<E> parent) {
        this.element = element;
        this.parent = parent;
    }
}