# 循环队列
## 内部设计
实现方式——选用数组存储，含有一个头指针，指向逻辑上的第一个元素,
添加元素时，不进行挪动数组,通过模运算进行

容量预先固定，不需要用户指定，默认 为 10

## ADT 实现
### 数据类型
``` java
public class CircleQueue<E> {
    private int size;
    private E[] elements;
}
```
### 操作
#### enQueue
// 队头指针移动次数为 size - 1 后，到达队尾 ,然后进行取模运算
改进——可以不移动，直接运算 (front + size) % 数组长度

#### deQueue
直接头指针向前移动，size--
front = (front + 1) % elements.length

#### 添加元素的时候，支持动态扩容
复用之前 ArrayList 的代码 ensureCapacity, 在复制的时候进行微调

问题，如何将旧元素的下标和新开的数组对应起来？
几个使用了地址映射的地方：
1. deQueue front = (front + 1) % elements.length;
2. enQueue elements[(front + size) % elements.length] = element;
3. ensureCapacity  newElements[i] = elements[(front + i) % elements.length];

如何封装以上相同的代码？
``` java
/**
 * @param index 偏移量
 * @return 映射后的逻辑地址
 */
int indexMap(int index) {
    return (front + index) % elements.length;
}
```

