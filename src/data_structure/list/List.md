## 模板
### ADT 实现
#### 数据类型
``` java

```
#### 核心操作简要说明 

---

##  list 项目结构说明
### 1 List 
线性表接口规范
### 2 AbstractList 
几种线性表——公共的代码实现

——public 方法是接口的实现

——protectded 方法是专门给子类用的方法，不对外界开放

## 关于 参数 index 规定
add 范围 [0,size]

其余 操作范围 [0,size)

按照内存 下标 从 0 开始计数，到 size - 1 

为什么要有两个下标检查方法？
* rangeCheckForAdd
* rangeCheck

由于在 末尾插入元素的 下标和 size 的值相同，因此，允许添加元素的时候下标 为size

## 关于正确性验证说明
涉及指针操作，尤其要对以下几个边界位置进行检查

1. 0 位置(第一个节点，默认没有头节点) 处 remove 和 add 
2. 用户传入 size ,对最后一个元素进行操作
3. Java 的空指针异常，在访问引用变量的成员之前，先检查是否为空，如果为空，先进行 null 处理

## 关于是否适用哨兵（头节点）的思考
对于想折腾的——不要用头节点，对边界位置独立进行检查思考

如果为了理解方便，统一操作，避免讨论的，就用头节点

本来正常的链表是没有头节点的，人为加上去的

我最后选择不加

对于涉及到 头指针 和 结尾的，仔细思考

## 关于公共接口的使用注意事项

node() 方法 取节点是根据 first 指针对 链表进行遍历，因此，如果要按原来的顺序取出元素，那么要注意留意 修改first 操作。

##  线性表 
### 1 ADT

### 2 操作接口

## 1 ArrayList (动态数组)
### ADT 实现
#### 数据类型
``` java
public class ArrayList<E> extends AbstractList<E> {
    private int size;          // 当前元素数目
    private E[] elements;      // 所有元素信息
}
```
#### 核心操作简要说明 




## 2 SingleList(单链表)
### ADT 实现
#### 数据类型
```java
public class SingleList<E> extends AbstractList<E> {
    private Node first;  // 指向第一个节点的指针
    /**
     * 定义结点的数据结构
     */
    private static class Node<E> {
        E element;   // 数据域
        Node<E> next;// 指针域
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}    
```
#### 操作接口简要说明
注意：

## 3 LinkedList (双向链表)
### ADT 实现
#### 数据类型
``` java
public class LinkedList<E> extends AbstractList<E> {
    private Node first; // 头指针
    private Node last; // 尾巴指针

    private static class Node<E> {
        E element;
        Node<E> pre;
        Node<E> next;

        public Node(Node<E> pre, E element, Node<E> next) {
            this.pre = pre;
            this.element = element;
            this.next = next;
        }
    }
}

```
#### 操作接口简要说明

？为什么添加元素的时候，在第一个位置插入元素可以公用在中间位置插入元素的代码




## 4 CircleSingleList(循环单链表 )
### ADT 实现
思考:

1 循环链表的循环如何实现？需要开始创建的时候进行额外操作吗？

被人用我的接口创建一个  CircleSingleList 后，可以做什么？怎么体现“循环”?
> 这个时候还没有节点，什么都不需要做。 也就是 循环是针对最后一个节点来说的

在单链表的基础上思考，什么时候需要考虑 循环 问题 ?
> 1 操作第一个元素的时候
> > 在 0 位置 add 元素需要考虑吗?
> >> **如果链表为 空表——需要，第一个元素要自己构成环,而不是指向 null。**
> >> 
> >> 如果不是空表——不需要。因为只是更新 first。
> >> 
> > remove 第一个元素需要考虑吗？
> >> 不需要，因为只是更新 first。
>
> 2 操作最后一个元素的时候
> > 在最后一个位置 add 需要 考虑吗？
> > >不需要,之前最后一个节点的下一个队友是 first ，会和操作普通中间节点一样。
> >
> > remove 最后一个元素需要考虑吗？
> >
> > > **需要，最后的指针要指向 first 而不是 null。**



#### 数据类型
和单向链表完全一样,只是操作的时候要考虑最后一个元素的指针要指向第一个元素
``` java
public class CircleSingleList<E> extends AbstractList<E> {
    private Node first;
    
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
```
#### 操作接口简要说明
##### 如何遍历单向循环链表？

> 通过使用 for 循环，避开对指针的操作，[0,size) 区间遍历所有元素

## 5 CircleLinkedList（循环双链表）
### ADT 实现

？ 相对于  LinkedList，有什么变化？



#### 数据类型

链表类型

``` java

```
节点类型

```java

```



#### 核心操作简要说明 
##### 1 在结尾添加元素，思考需要操作哪些指针

1 整个链表的 last 指针



