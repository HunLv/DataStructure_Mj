# queue

## 编辑说明
1. 将未实现的接口从txt 复制过来
2. 由于也是线性结构，可以复用之前的代码，是选择 ArrayList 还是选择 LinkedList ?
   > 选择 LinkedList 
   > 原因：如果选用 ArrayList ,第一，头元素出去后，后面的元素要往前移动，第二，没有 尾指针，需要额外找队尾
   > 选择 LinkedList 的好处：1 不需要移动元素 2 有尾指针
3. 将接口 List ,抽象类 AbstractList，LinkedList 复制过来，放到 statc.list 的包下（注意:检查一下无用或者错误的import 语句） 
4. 使用 组合 的方式复用代码

##  代码实现
1. 使用组合方式 复用 LinkedList
```java
public class queue<E> {
    private List<Integer> list = new LinkedList();
}
```
2. 简单思考一下队列 特有成员方法的实现
对于  enQueue()  直接使用原来的add ,只需在 size - 1 （队尾）添加即可 
对于  deQueue()  直接使用原来的remove ,只需在 0 （队头）添加即可 
对于  front() 直接使用原来的 get ,只需 取 first 指针指向的元素即可

3. 关于官方的 queue
* 为什么不 像 Stack 设计那样，要将 queue 设计成一个 接口？那接口使用的时候又是如何取决定选择哪一个实现？

# 双端队列

