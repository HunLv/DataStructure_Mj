package data_structure.queue.list;

/**
 * @program: DataStructure_Mj
 * @description: 抽取和 动态数组 ArrayList 共同的代码 (这个类对于外界是不可见的，这个类的作用就是抽取公共代码)
 **/
public abstract class AbstractList<E> implements List<E> {
    protected int size;

    /* 实现 接口中的通用代码 */
    public int size() {
        return size;
    }
    public boolean isEmpty() { return size == 0;}
    public boolean contains(E element) { return indexOf(element) != ELEMENT_NOT_FOUND;}
    /* 添加元素到尾部*/
    public void add(E element) {
        add(size,element);
    }


    /* 实现 非接口中的通用代码，不给外界使用*/
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index " + index +",Size:"+size);
    }
    protected void rangeCheck(int index) {
        /**
         * 不可以在 size 位置进行操作
         */
        if(index < 0 || index >= size) {
            outOfBounds(index);
        }
    }
    protected void rangeCheckForAdd(int index) {
        if(index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
