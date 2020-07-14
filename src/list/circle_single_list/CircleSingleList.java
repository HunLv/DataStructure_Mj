package list.circle_single_list;

import list.AbstractList;

/**
 * @description: 循环单向链表
 * @create: 2020-07-10 18:54
 **/
public class CircleSingleList<E> extends AbstractList<E> {
    private Node first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(element);
            sb.append("_").append(next.element); //next 可能为 空吗？不可能，如果只有一个元素也是一个环
            return sb.toString();
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            /* 思路 1 */
//            if (size == 0) {/* 1 如果链表为空，first == null ,新节点 自己 要构成 环 */
//                first = new Node<>(element, null);
//                first.next = first;
//            } else {/* 链表不为空 */
//                first = new Node<>(element, first); // 原来的第一个元素成为新节点的后继，然后将头指针指向新节点
//                // 最后一个元素 此时需要修改吗？ 不需要，因为它引用的 是 全局的 first
//            }

            /* 思路 2
                 有问题的代码 TODO (在下面进行了纠正)
                 和单向链表思考保持一致，
                 然后考虑特殊情况——什么时候需要维护 循环呢？当在头部插入，且链表为空的时候—— 新插入的节点要维护循环

                 感觉考虑的多，因为用到 了 node() ，而 node() 是通过 first 指针遍历链表，
                 因此需要注意在node() 取元素之前，first 是否被修改了

                 算法复杂度也比我的复杂，仅供参考吧，

            */
//            Node<E> newFirst = null;
//            first = new Node<>(element,first); // 1 先串起来
//
//            // 维护循环
//            Node<E> last = null;
//            if (size == 0){
//                last = first;
//            }else {// size = 0 的时候会越界，因此上面多了个判断
//                last = node(size - 1); // 这里要注意，上面第一步修改了first ，会出问题
//            }
//            last.next = first;

            /* 修正后的代码 */
            // 为了 在使用 node 前 不修改 first 额外创建 的变量
            Node<E> newFirst = new Node<>(element,first); // 1 先串起来

            // 维护循环
            Node<E> last = null;
            if (size == 0) {
                last = newFirst;
            } else {// size = 0 的时候会越界，因此上面多了个判断
                last = node(size - 1); // 这里要注意，上面第一步修改了first ，会出问题
            }
            last.next = first;

            first = newFirst; // 最后再更新 first

        } else {
            Node<E> preNode = node(index - 1);
            Node<E> newNode = new Node<>(element, preNode.next);
            preNode.next = newNode;
        }
        size++;
    }

    /**
     * @param index
     * @return
     */
    Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    public E remove(int index) {
        /* 进行两次 检查—— */
        if (size == 0) { /*是否有元素 */
            System.out.println("没有元素可删除");
            return null;
        }
        // 2 下标是否 合理 ( 规定只能传入实际元素的位置，0——size - 1)
        rangeCheck(index);

        /* 存放删除节点的信息,初始设为 第一个节点*/
        Node<E> node = first;
        if (index == 0) {/* 讨论 删除 第一个元素的情况 */
            first = first.next;
        } else {
            Node<E> preNode = node(index - 1);
            node = preNode.next;
            if (node.next == null) { /* 如果删除 最后一个节点，要将上一个节点的 next 更新为 first 而不是 null */
                preNode.next = first;
            } else {
                preNode.next = node.next;
            }
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
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(",  [");
        Node<E> node = first;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                sb.append(node);
            } else {
                sb.append(",").append(node);
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
