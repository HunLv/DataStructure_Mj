package list.single_list;

import list.AbstractList;

/**
 * @program: DataStructure_Mj
 * @description: 单向链表
 * @author: MH
 * @create: 2020-06-23 11:20
 **/
public class SingleList<E> extends AbstractList<E> {
    private Node first;

    /**
     * 定义结点的数据结构
     */
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public void add(int index, E element) {
        // TODO 3 0 要额外处理，因为 0 的前一个节点的索引 为 -1 不会通过检查
        if (index == 0) {
            first = new Node<>(element, first);// 原来的第一个元素成为新节点的后继，然后将头指针指向新节点
        } else {
            // 完成交接仪式，原来前面拉后面的绳子要先交给新的成员，如何找到上一个主人呢？写一个方法专门用来获取指定某个位置的一个结点
            // 1 找到前一个结点
            Node<E> preNode = node(index - 1);
            // 2 将 index 位置的结点的绳子交给新结点
            Node<E> newNode = new Node<>(element, preNode.next);
            // 3 将新节点的 狗链 交给前一个主人
            preNode.next = newNode;
            // TODO 1 可以简写 第 2 步 和 第 3 步 合并
            // todo done
//        preNode.next = new Node<E>(element,preNode.next);
        }

        // TODO 2 别忘了 size
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
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 我的版本
     *
     * @param index
     * @return
     */
    public E remove1(int index) {
        if (index == 0) {
            Node<E> oldNode = node(index);
            first = oldNode.next;
            return oldNode.element;
        }
        // 删除之前保存数据 —— 他管理的队友
        // 1 将队友转交 他的老板
        Node<E> preNode = node(index - 1);
        Node<E> oldNode = node(index);
        preNode.next = oldNode.next;
        return oldNode.element;
    }

    /**
     * TODO
     *
     * @param index 说明，传入的位置 从 0 开始，如果要 删除最后一个元素，只需将 size 传入
     * @return
     */
    public E remove2(int index) {
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else if (index == size) { // 删除最后一个元素
            // todo 2 找到 最后一个元素 的前一个元素， 不同于 正常的操作， 现在的size 本来就比 正常 索引 多 1 ,因此 要多减一个 1
            Node<E> preNode = node(index - 2); // TODO 有问题 , 如果只有一个元素，不成立
            node = preNode.next;
            // todo 2 最后一个元素是没有下一个节点的 即没有 node.next, 直接 将 前一个结点的 next 设置 为 null
            preNode.next = null;
        } else {
            Node<E> preNode = node(index - 1);
            // TODO 2 如果传入的是size ,取到的节点是 最后一个节点，最后一个节点的 next 为 null,node 为 null ,再对 node  操作 会报错
            node = preNode.next;
            // todo 1 done 能用一个节点完成的事，就不要取两个节点
            preNode.next = node.next;
        }
        size--;
        return node.element;
    }


    /**
     * @param index
     * @return
     */
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
            preNode.next = node.next;
        }
        size--;
        return node.element;
    }


    public int indexOf1(E element) {
        int count = 1;
        Node<E> node = first;
        while (node.element != element) {
//            while( element !=node.element ){
            node = node.next;
            count++;
        }
        return count;
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
        // TODO 不需要使用循环变量的地方，就用 while 进行链表的遍历,对于需要知道索引的，使用 for 循环
        // 添加所有元素
//        for (int i = 0; i < size ; i++) {
//            if(i != 0){
//                string.append(",");
//            }
//            string.append(node.element);
//            node = node.next;
//        }
        while (node != null) {
            if (node != first) {
                string.append(",");
            }
            string.append(node.element);
            node = node.next;
        }

        string.append("]");
        return string.toString();
    }

    /***************************************算法练习区域*************************************************/
    /**
     *  从链表的结尾逆序 遍历 打印链表
     * @param head
     */
    public void reversePrint(Node head) {
        if (head == null) return;

        reversePrint(head.next);
        System.out.println(head.element);
    }
    public void testReversePrint(){
        reversePrint(first);
    }
}
