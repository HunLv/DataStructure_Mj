# Stack

## 编辑说明
第一步,将 txt 的 接口复制过来

第二步, 由于很多操作可以直接复用之前的，
将 list 包 下的 List 和 AbstractList 以及  ArrayList 和 LinkedList 复制过来, 放到 stack.list 包下

第三步，分别复用之前的 ArrayList  或 LinkedList 实现 Stack,思考如何复用之前的代码( 是使用 继承 还是 组合 ?)
——

添加元素的时候只能往结尾加 push

删除元素的时候只能从结尾删 pop

取元素的时候只能从 结尾 取 top

使用组合，因为如果使用了继承，子类将额外获得父类的一些方法，而有些设计上不是 这个数据结构需要的,因此选择
组合，根据需要自由选择要复用的数据和方法。

## 组合ArrayList 


