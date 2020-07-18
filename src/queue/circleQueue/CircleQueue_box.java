package queue.circleQueue;

/**
 * @description: 封装循环队列 中地址映射代码   indexMap() 方法
 **/
public class CircleQueue_box<E> {
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPCITY = 10;   // 默认容量
    private int front; // 逻辑上头元素的指针

    /**
     * @param index 偏移量
     * @return 映射后的逻辑地址
     */
    int indexMap(int index) {
        return (front + index) % elements.length;
    }


    public CircleQueue_box() {
        elements = (E[]) new Object[DEFAULT_CAPCITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        elements = null;
    }

    /**
     * 头元素
     *
     * @return
     */
    public E front() {
        return elements[front];
    }

    public void enQueue(E element) {
        // 添加动态扩容的能力
        ensureCapacity(size + 1);
        // 逻辑上的队列的最后位置 如果下标从 0 开始，直接使用 size
        // TODO box 3
        elements[indexMap(size)] = element;
        size++;
    }

    public E deQueue() {
        E frontElement = elements[front];
        // 可以不用清空原来的数据吧，这里就不写了, 逻辑上可以不写，但是为了学习观察方便还是写上直观
        elements[front] = null;
        // 逻辑上队列的第 2 个位置
        // TODO box 2
        front = indexMap(1);
        size--;
        return frontElement;
    }


    private void ensureCapacity(int needCapicity) {
        //  计算原来的容量——数组的长度
        int oldCapacity = elements.length;
        if (oldCapacity >= needCapicity) return;
        // 新容量是旧容量 的 1.5 倍数，右移一位缩小一半
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 新开辟一块内存
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            // front + i 算出的是 对应 原来队列 逻辑位置的元素
            // TODO box 1
            newElements[i] = elements[indexMap(i)];
        }
        elements = newElements;
        // 新内存头指针从 0 开始
        front = 0;
        System.out.println("队列的原来内存由  " + oldCapacity + "  变为  " + newCapacity);
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("capacity=").append(elements.length)
                .append(" size =").append(size)
                .append(" front=").append(front)
                .append(",  [");

        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(",");
            }
            string.append(elements[i]);
        }

        string.append("]");

        return string.toString();
    }
}
