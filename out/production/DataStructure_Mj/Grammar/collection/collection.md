# 集合Collection

为什么要用 Collection?(List, Map,Stack,Queue)

多了一个 s 的东东是什么？（Collections ）

## List

### 遍历 list

遍历方式 5  Java 1.8
``` java
list.forEach(iterator->{         // 1.8 引进的forEach() 方法
    System.out.println(iterator);
});
```
遍历方式 4

```java
for (Integer value:list){
    System.out.println(value);
}
```
遍历方式 3

```java
Iterator iterator = list.iterator();
while (iterator.hasNext()){
    System.out.println(iterator.next());
}
```
遍历方式 2

```java
for (Iterator iterator = list.iterator(); iterator.hasNext();){
    System.out.println(iterator.next());
}
```

遍历方式 1

``` java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```





## Collections

