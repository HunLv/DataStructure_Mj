package data_structure.stack.list;

public class ArrayList<E> extends AbstractList<E> {
    private E[] elements;    // 所有元素
    private static final int DEFAULT_CAPCITY = 2;   // 默认容量

    public ArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPCITY) ? DEFAULT_CAPCITY : capaticy;
        elements = (E[]) new Object[capaticy];
    }

    public ArrayList() {
        this(DEFAULT_CAPCITY);
    }

    public int indexOf(E element) {
        if (element == null) { // 为空，找第一个 为 null 的元素
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else { // 不为空，找相同的元素
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return 返回被删除元素的值
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];

        // TODO 优化
//        for (int i = index + 1; i <= size - 1; i++) {
        // todo done
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        elements[size] = null;
        return old;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        // 动态扩容
        ensureCapacity(size + 1);
        /* 改正*/
        // TODO 优化
//        for (int i = size - 1; i >= index; i--) {
        //todo done
        for (int i = size; i > index; i--) {
            // 向后 挪动
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 保证要有capacity的容量, 在添加元素的时候调用
     *
     * @param needCapicity 当前需要的容量
     */
    private void ensureCapacity(int needCapicity) {
        //  计算原来的容量——数组的长度
        int oldCapacity = elements.length;
        if (oldCapacity >= needCapicity) return;
        // 新容量是旧容量 的 1.5 倍数，右移一位缩小一半
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 新开辟一块内存
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("原来内存由  " + oldCapacity + "  变为  " + newCapacity);
    }

    /**
     * 打印 ArrayList
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        // 格式为：size=3, [22,333,444]
        string.append("size=").append(size).append(",  [");
        // 添加所有元素
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(",");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}

