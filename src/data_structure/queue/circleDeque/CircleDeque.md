# CircleDeque(循环 + 双端)
## 编辑说明

## ADT
### 数据类型
由于是循环，所以和 CircleQueue 类似，选择数组

```java
public class CircleDeque<E> {
    private int size;
    private E[] elements;
    
    private int front; // 逻辑上头元素的指针 说明：尾指针由计算得出
}
```



思考：既然是双端队列，是否需要再增设一个 rear 指针？

> 不需要，因为可以直接运算，front + size - 1



### 操作
由于操作的主要是双端，所以和 Deque 双端队列类似 ，

Deque 当时是使用 LinkedList 实现的
在头部 add——直接调用 add(0,element)
在尾部 add——直接调用 add(element)
在头部remove——直接调用 remove(0)
在尾部remove——直接调用 remove(size - 1)

那么，现在使用了 数组作为存储介质的 CircleQueue 如何实现这样的功能呢？
(说明：这里的扩容同样复用了 CircleQueue 的 ensureCapacity() 方法，也就是每次添加元素的时候先要检查是否需要扩容)

> 在尾部 add——不需要维护指针，直接 定位后操作即可
>
> 在尾部 remove——不需要维护指针，直接 定位后操作即可
>
> 在头部 remove—— 直接定位，让后操作，最后维护 front ,定位到 逻辑上的第二个位置    
>
> 在头部 add —— （核心）如何定位到 front 前面的一个位置？直接 - 1？ 不安全，如何保证一定是正数？加一个 length 呗，又不影响，（说明：最好直接在原来 位置映射的地方加，这样代码就有更好的可读性）

## 测试

如何测试呢？简单，分别在头尾添加元素，然后打印整体布局；然后输出 出队的情况，检查是否符合要求

##  模运算的优化

原因：尽量少用 乘除 模

可以使用的范围：加起来后的数值不得大于 数组长度的 2倍

```java
//        return index % elements.length; 
        /* 优化 上面的模运算代码  (原因，双端队列的计算中，数值不回超过 数组 长度的 2 倍)
        *  思想：如果 index 小于等于 length ,直接返回 index ,如果大于，就做减法(index - length)
        * */
return index >= elements.length ? (index -elements.length): index;
```



