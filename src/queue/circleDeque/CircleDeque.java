package queue.circleDeque;

/**
 * @description: 循环双端队列
 * @create: 2020-07-17-11:16
 **/
public class CircleDeque<E> {
    /* 和  CircleQueue 的类似，用数组实现循环 */
    private int size;
    private E[] elements;
    private int front; // 逻辑上头元素的指针        说明：尾指针由计算得出

    private static final int DEFAULT_CAPCITY = 10;   // 默认容量

    public CircleDeque() {
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
     * 取出头元素
     *
     * @return
     */
    public E front() {
        return elements[front];
    }

    /**
     * 取出尾元素
     *
     * @return
     */
    public E rear() {
//        return elements[front + size - 1];
        return elements[indexMap(size - 1)];
    }

    /**
     * 从尾部入队
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        // 定位到最后一个空位置
        elements[indexMap(size)] = element;
        size++;
    }

    /**
     * 从尾部出队
     *
     * @return
     */
    public E deQueueRear() {
        E oldElement = elements[indexMap(size - 1)];
        elements[indexMap(size - 1)] = null;
        size--;
        return oldElement;
    }

    /**
     * 从头部入队
     * 头往前移动
     *
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        // front -1  算出前一个位置，加一个 length 保证长度 大于 0（因为最后要取模，加 length 不影响）
        // 改进，对于负数的处理逻辑同样放到 indexMap 中处理，统一接口参数，不必额外计算
//        elements[indexMap(elements.length - 1)] = element;
        front = indexMap(-1);
        elements[front] = element;
        size++;
    }

    /**
     * 从头部出队
     *
     * @return
     */
    public E deQueueFront() {
        E oldElement = elements[front];
        elements[front] = null;
        // 定位到逻辑上的第二个位置
        front = indexMap(1);
        size--;
        return oldElement;
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

    /**
     * 扩容  使用的时候一般传入 size + 1 ,也就是每次添加元素前先检查一下
     *
     * @param needCapicity 需要的容量 大小
     */
    private void ensureCapacity(int needCapicity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= needCapicity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[indexMap(i)];
        }
        elements = newElements;
        front = 0;
        System.out.println("队列的原来内存由  " + oldCapacity + "  变为  " + newCapacity);
    }

    /**
     * @param index 偏移量
     * @return 映射后的逻辑地址
     */
    int indexMap(int index) {
        // 先相加，目的是为了下面判断是否小于 0
        index += front;
        if(index < 0){// 如果小于 0，就直接加上数组长度就得到 逻辑位置
            return index + elements.length;
        }

//        return index % elements.length; // 如果 >= 0 就做 模运算
        /* 优化 上面的模运算代码  (原因，双端队列的计算中，数值不回超过 数组 长度的 2 倍)
        *  思想：如果 index 小于等于 length ,直接返回 index ,如果大于，就做减法(index - length)
        * */
        return index >= elements.length ? (index - elements.length): index;
    }
}
