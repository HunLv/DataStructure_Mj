package dynamic_array;
/**
 * @program: DataStructure_Mj
 * @description: 动态数组
 * @author: MH
 * @create: 2020-06-20 20:43
 **/
public class ArrayList_Generic<E> {
    private int size;          // 当前数目
    private E[] elements;    // 所有元素
    private static final int DEFAULT_CAPCITY = 2;   // 默认容量
    private static final int ELEMENT_NOT_FOUND = -1; // 元素找不到

    public ArrayList_Generic(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPCITY) ? DEFAULT_CAPCITY:capaticy;
        // TODO 1 错误写法
//        elements = new E[capaticy];
        // TODO  done
        elements = (E[]) new Object[capaticy];
    }
    public ArrayList_Generic() {
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
     *  TODO 5 增加泛型之后，不应该使用 == 来比较对象的——直接用等号比的是内存地址是否相等
     *  TODO done 重写 person 的equals ,自定义比较标准
     *
     *  TODO 6 null 比较的问题
     * 2 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(E element) {
//        for (int i = 0; i < size; i++) {
//        // todo 有问题的代码——比较
//            if (elements[i] == element)  return i;
////            todo 5 done,自定义 equals
//            if (elements[i].equals(element))  return i;
//        }


        // todo 6 done
       if (element == null){ // 为空，找第一个 为 null 的元素
           for (int i = 0; i < size; i++) {
               if (elements[i] == null) return i;
           }
       }else { // 不为空，找相同的元素
           for (int i = 0; i < size; i++) {
               // TODO 强调：这里使用 equals 重点是为用户 提供接口，不仅仅是 == 中简单的比较内存地址，而是可以自定义比较的内容
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
     *  TODO 2 增加泛型支持后 需要 调整： 问什么之前(元素类型为 int )不需要调整？ 为什么现在要调整？ —— 可以利用的，旧重复利用，否则，滚蛋
     * 5 清除所有元素
     */
    public void clear() {
        // TODO 注意区别开始的写法
//        elements = null;
        // TODO done 纠正
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
     *  TODO 3 也需要调整
     *  8 删除index位置的元素
     * @param index
     * @return 返回被删除元素的值
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];

        for (int i = index + 1; i <= size - 1; i++) {
            elements[i-1] = elements[i];
        }
        size--;
        // TODO done  由于最后一个位置保存着原来 堆 空间 对象的 地址引用， 而 clear 清空后，这个引用仍存在，因此，需要清理这条引用线
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
        E[] newElements = (E[]) new Object[newCapacity];
        // 复制
        // TODO 4 错误写法
//        for (int i = 0; i < newCapacity; i++) {
        // TODO done 纠正, 拷贝的仅仅是原来有的个数
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("原来内存由  "+oldCapacity+"  变为  "+ newCapacity);
    }
}

