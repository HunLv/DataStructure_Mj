package data_structure.list.circle_linked_list;

import data_structure.list.AbstractList;

/**
 * @description: 双向链表
 * @create: 2020-07-11 16:48
 **/
public class CircleLinkedList<E> extends AbstractList<E> {
    private Node first;
    private Node last;

    private static class Node<E> {
        E element;
        Node<E> pre;
        Node<E> next;

        public Node(Node<E> pre, E element, Node<E> next) {
            this.pre = pre;
            this.element = element;
            this.next = next;
        }

        /**
         * 打印 前后以及自身信息/
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (pre != null) {
                sb.append(pre.element);
            } else {
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }
            return sb.toString();
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            Node oldLast = last;
            last = new Node(last, element, first);

            if (oldLast == null) { // 链表为空
                first = last;
                first.pre = first;
                first.next = first;
            } else { // 常规的往后面添加元素
                oldLast.next = last;
                first.pre = last;
            }
        } else {
            Node next = node(index);
            Node pre = next.pre;
            Node node = new Node<>(pre, element, next);
            next.pre = node;
            pre.next = node;

            if (index == 0) {
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = node(index);
        Node<E> preNode = node.pre;
        Node<E> nextNode = node.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;


        if (node == first) {
            first = nextNode;
        }
        if (node == last) {
            last = preNode;
        }

        size--;
        return node.element;
    }

    Node<E> node(int index) {
        rangeCheck(index);

        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }


    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> oldNode = node(index);
        E oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    /**
     * 打印 CircleLinkedList
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(",  [");
        Node<E> node = first;

//        while (node != null) {
//            if (node != first) {
//                string.append(",");
//            }
//            string.append(node);
//            node = node.next;
//        }



        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(",");
            }
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
