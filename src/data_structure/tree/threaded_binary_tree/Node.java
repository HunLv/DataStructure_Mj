package data_structure.tree.threaded_binary_tree;

public class Node<E> {
    E element;
    Node<E> parent;
    Node<E> leftChild;
    Node<E> rightChild;
    Boolean lFlag = false;
    Boolean rFlag = false;

    public Node(E element, Node<E> parent) {
        this.element = element;
        this.parent = parent;
    }
}