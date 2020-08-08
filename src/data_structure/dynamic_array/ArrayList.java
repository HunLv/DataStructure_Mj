package data_structure.dynamic_array;
/**
 * @program: DataStructure_Mj
 * @description: 动态数组
 * @author: MH
 * @create: 2020-06-20 20:43
 **/
public class ArrayList {
    private int size;          // 当前数目
    private int[] elements;    // 所有元素
    private static final int DEFAULT_CAPCITY = 2;   // 默认容量
    private static final int ELEMENT_NOT_FOUND = -1; // 元素找不到

    public ArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPCITY) ? DEFAULT_CAPCITY:capaticy;
        elements = new int[capaticy];
    }
    public ArrayList() {
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
        if (size == 0) return true;
        return false;
    }
    /**
     * 2 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element)  return i;
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 3 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(int element) {
        // 可以复用之前的 劳动
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 4 获取index位置的元素
     * @param index
     * @return
     */
    public int get(int index) {
        rangeCheck(index);
        return elements[index];
    }
    /**
     *  4 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public int set(int index, int element) {
        rangeCheck(index);
        int old = elements[index];
        elements[index] = element;
        return old;
    }
    /**
     * 5 清除所有元素
     */
    public void clear() {
        // 不一定要按照用户预期的那样进行设计，我们只需简单的设置为 0，用于便失去了访问和设置的权限
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
     * 7 添加元素到尾部 TODO
     * @param element
     */
    public void add(int element) {
//        elements[size] = element;
        // TODO done 直接调用 在某个索引地方添加元素
        add(size,element);
    }

    /**
     *  8 删除index位置的元素
     * @param index
     * @return 返回被删除元素的值
     */
    public int remove(int index) {
        rangeCheck(index);
        for (int i = index + 1; i <= size - 1; i++) {
            elements[i-1] = elements[i];
        }
        int old = elements[index];
        size--;
        return old;
    }
    /**
     *  9 在index位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        /* TODO 有问题: 不同于获取和删除，最大索引的值 为 size-1 ； Because: 插入可以在 索引值 等于 size 即没有元素的的地方进行 */
//        if(index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException("Index " + index +",Size:"+size);
//        }
        /* TODO done 纠正*/
//        if(index < 0 || index > size) {
//            throw new IndexOutOfBoundsException("Index " + index +",Size:"+size);
//        }
        rangeCheckForAdd(index);
        // 动态扩容
        ensureCapacity(size + 1);
        /* 改正*/
        for (int i = size - 1; i >= index; i--) {
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
        int[] newElements = new int[newCapacity];
        // 复制
        // TODO 错误写法
//        for (int i = 0; i < newCapacity; i++) {
        // TODO done 纠正, 拷贝的仅仅是原来有的个数
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("原来内存由  "+oldCapacity+"  变为  "+ newCapacity);
    }
}

