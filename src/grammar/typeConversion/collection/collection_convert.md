# 概览

模板

```
### a  —>  b
#### Java 1.6
​```java

​```
#### Java 1.8
​```java

​```
```

## List  Integer[]  Int[]

### Int[ ] |Integer[ ] —> List 

#### Java 1.6   逐个遍历填充

```java
int[] array = {1, 2, 3};
//Integer[] array = {1, 2, 3};

List<Integer> list = new ArrayList<Integer>();
for (int i : array) {
    list.add(i);
}
```
#### Java 1.8  使用 Stream （Int[ ] |Integer[ ]  通吃）

```java
// int[]
int[] array = {1, 2, 3};

List list = Arrays
    .stream(array)
    .boxed()   // 装箱
    .collect(Collectors.toList());

// Integer[]
Integer[] array = {1, 2, 3};
List<Integer> list = Arrays
    .stream(array)
    .collect(Collectors.toList());
```

### List —>Integer [ ]

#### Java 1.6  使用 List 的 toArray(T[ ] a)
```java
List<Integer> list = new ArrayList(Arrays.asList(1,2,33));

// 使用 toArray(T[] a) 方法
Integer[] ans = list.toArray(new Integer[0]);
```
### List —>Int [ ] |Integer [ ]

#### Java 1.8
```java

```



# 介绍

# List 和 Int 数组的转换

## Int[ ]  —> List   目的：利用 list 工具的灵活处理数据

### Java 1.8—— Stream

Note:

> * Arrays.asList() only accept parameter whose type is Object
> *  Arrays.asList() return a ArrayList whose value cannot be modify (返回值使用 final 修饰的)

eg:

```java
int[] array = {1, 2, 3};

List list = Arrays
    .stream(array)
    .boxed()
    .collect(Collectors.toList());
```

### Java 1.6 ——将Arrays.asList(array) 返回的不可修改的arrayList作为 ArrayList() 的构造函数的参数传递。

Note:必须要求 array 的元素类型是引用类型，如何处理呢？

思路

创建一个 list ,将元素逐个添加进去，添加的时候自动转型。

```java
int[] array = {1, 2, 3};

List<Integer> list = new ArrayList<Integer>();
for (int i : array) {
    list.add(i);
}
```

## List —>Int []  目的：处理数据之后，返回数据原来的形式

### List —>Integer []

注：可一步转成  Integer[] 但是不能一步转 Int []

```java
List<Integer> list = new ArrayList(Arrays.asList(1,2,33));

// 使用 toArray(T[] a) 方法
Integer[] ans = list.toArray(new Integer[0]);
```



# List 和 String 的转换



##  List —> String 目的：处理数据之后，返回数据原来的形式

```java
// Java 1.6

```



```java
// Java 1.8
ArrayList<String> list = new ArrayList<>(Arrays.asList("huan","bbb","ccc"));

/* 利用 String 的 join() 拼接 list 列表中字符串*/
String listString = String.join("", list);
```

```java
// Java 1.8 
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,4));

/* 用 stream  处理 ,可以处理 ArrayList 的各种类型 */
String listString = list
    .stream()
    .map(Object::toString)
    .collect(Collectors.joining(""));
System.out.println(listString);
```

## String ——>List



# 关于语法知识的解释

## toArray(T[] a)