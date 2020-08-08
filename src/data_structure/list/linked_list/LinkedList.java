package data_structure.list.linked_list;

import data_structure.list.AbstractList;

/**
 * @program: DataStructure_Mj
 * @description: 双向链表
 * @create: 2020-07-08 18:00
 **/
public class LinkedList<E> extends AbstractList<E> {
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
            }else {
                sb.append("null");
            }
            return sb.toString();
        }
    }

    /**
     * 关于内存问题：gc root 对象的概念 —— 被局部变量指向的对象
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public void add(int index, E element) {
        /**
         * 第三步，处理 往最后面插入元素的情况
         */
        if (index == size) {
            // 3 提前保存一下原来的 last 指针
            Node oldLast = last;
            // 1 链表的 last 指针要指向 新创建的节点, 新节点的 前一个节点是 原来 的last ,后一个节点为 空
            last = new Node(last, element, null);

            // 5 处理 oldLast 为 null —— 空表的情况
            if (oldLast == null) { // 此时，新创建的节点前后都为 null ， 链表 last 指针已经指向了新创建的元素,只需将 链表的 first 指针和last 同步
                first = last;
            } else {
                // 2 将原来 链表的 last 的下一个节点更新 为当前，节点，但是，上一步已经覆盖了，因此需要 提前保存 一下原来的last
                oldLast.next = last; // 4 既然是访问 oldLast, 那么，他可能为 空 吗？—— 可能，空表 的时候
            }
        } else {
            /**
             * 第一步,讨论一般情况——往中间插入节点
             */
            // 取出的节点最终会是 当前节点的下一个节点
            Node next = node(index);
            Node pre = next.pre;
            // 将前后两个节点分别传给新节点
            Node node = new Node<>(pre, element, next);
            // 将前后两个节点和新创建的节点关联
            /*
            pre.next = node;// TODO 1 处理特殊情况，往 0 位置插入元素,0 位置的上一个元素是 null,对 null 访问成员会出异常
            */
            next.pre = node;

            /**
             * 第二步，处理特殊情况—— TODO 1 done
             */
            if (pre == null) { // index = 0
                first = node;
            } else { // 正常情况
                pre.next = node;
            }
        }

        size++;
    }

    /**
     * 获取 index 位置对应的节点
     *
     * @param index
     * @return
     */
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


    /**
     * @param index 说明，传入的位置 从 0 开始，如果要 删除最后一个元素，只需将 size 传入
     * @return
     */
    @Override
    public E remove(int index) {
        /**
         * 第一步 :考虑正常情况
         */
        // 取出删除位置的节点
        Node<E> node = node(index);
        // 取出 pre 和 next
        Node<E> preNode = node.pre;
        Node<E> nextNode = node.next;
        // pre 和 next 建立联系
        /*
        preNode.next = nextNode;
        nextNode.pre = preNode;
         */
        /**
         * 第二步 :考虑特殊情况  涉及到 first 和 last 指针维护的问题
         */
        // 1 在 0 位置 remove 元素
        if (preNode == null) { // 对链表的头指针进行维护
            first = nextNode;
        } else {
            preNode.next = nextNode;
        }

        // 2 在 末尾size - 1 位置 remove 元素
        if (nextNode == null) {// 对链表的尾指针进行维护
            last = preNode;
        } else {
            nextNode.pre = preNode;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) { // 为空，找第一个 为 null 的元素
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else { // 不为空，找相同的元素
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
     * 打印 LinkedList
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        // 格式为：size=3, [22,333,444]
        string.append("size=").append(size).append(",  [");
        Node<E> node = first;
        while (node != null) {
            if (node != first) {
                string.append(",");
            }
            // TODO 1 拼接 node (在 node 中实现 toString,打印前后以及自身信息/)
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
