package dynamic_array;
/**
 * @program: DataStructure_Mj
 * @description: 动态数组
 * @author: MH
 * @create: 2020-06-20 20:43
 **/
public class ArrayList_Generic_better<E> {
    private int size;          // 当前数目
    private E[] elements;    // 所有元素
    private static final int DEFAULT_CAPCITY = 2;   // 默认容量
    private static final int ELEMENT_NOT_FOUND = -1; // 元素找不到

    public ArrayList_Generic_better(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPCITY) ? DEFAULT_CAPCITY:capaticy;
        elements = (E[]) new Object[capaticy];
    }
    public ArrayList_Generic_better() {
        this(DEFAULT_CAPCITY);
    }

    /**
     * 1 元素的数量
     * @return
     */
    public int size() {
        return size;
    }
    /**
     * 1 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 2 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(E element) {
       if (element == null){ // 为空，找第一个 为 null 的元素
           for (int i = 0; i < size; i++) {
               if (elements[i] == null) return i;
           }
       }else { // 不为空，找相同的元素
           for (int i = 0; i < size; i++) {
               if (elements[i].equals(element))  return i;
           }
       }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 3 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element) {
        // 可以复用之前的 劳动
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 4 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }
    /**
     *  4 设置index位置的元素
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
     * 5 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    /**
     * 6 打印 ArrayList
     */
    @Override
    public String toString() {
        StringBuilder string= new StringBuilder();
        // 格式为：size=3, [22,333,444]
        string.append("size=").append(size).append(",  [");
        // 添加所有元素
        for (int i = 0; i < size ; i++) {
            if(i != 0){
                string.append(",");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }

    /**
     * 7 添加元素到尾部
     * @param element
     */
    public void add(E element) {
       add(size,element);
    }

    /**
     *  8 删除index位置的元素
     * @param index
     * @return 返回被删除元素的值
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];

        // TODO 优化
//        for (int i = index + 1; i <= size - 1; i++) {
        // todo done
        for (int i = index + 1; i < size ; i++) {
            elements[i-1] = elements[i];
        }
        size--;
        elements[size] = null;
        return old;
    }
    /**
     *  9 在index位置插入一个元素
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
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    /* 10 封装 检查范围的代码 */
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index " + index +",Size:"+size);
    }
    private void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            outOfBounds(index);
        }
    }
    private void rangeCheckForAdd(int index) {
        if(index < 0 || index > size) {
            outOfBounds(index);
        }
    }



    /**
     * 11 保证要有capacity的容量, 在添加元素的时候调用
     * @param needCapicity 当前需要的容量
     */
    private void ensureCapacity(int needCapicity) {
        //  计算原来的容量——数组的长度
        int oldCapacity = elements.length;
        if (oldCapacity >= needCapicity) return;
        // 新容量是旧容量 的 1.5 倍数，右移一位缩小一半
        int newCapacity = oldCapacity+ (oldCapacity>>1);
        // 新开辟一块内存
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("原来内存由  "+oldCapacity+"  变为  "+ newCapacity);
    }
}

