# Stream 流

## 应用案例

### 案例 1 将 Array 转成 List

```java
int[] array = {1, 2, 3};

List<Integer> list =  Arrays
    .stream(array)            // 调用 Arrays 的stream() 创建 Stream todo
    .boxed()
    .collect(Collectors.toList());
```



### 案例 2 对集合的元素进行筛选

```java
List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

// 获取空字符串的数量
long count = list
    .stream()
    .filter(string ->string.isEmpty())   // Stream 的 filter() 方法 todo
    .count();                            // Stream 的 count()  方法 todo
```



### 案例 4 todo





# Lambda

## 应用案例

### 案例 1 遍历集合

```java
List<Integer> list = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
list
    .forEach(iterator->{//集合的forEach() 方法;参数中使用了lambda表达式 todo 
        System.out.println(iterator);
    });
```



# 基础知识补充

## Stream 流

## Lambda 表达式

### 操作符   ->

> 箭头操作符，或者lambda操作符；箭头操作符将lambda分成了两个部分。
>
>  **1.  左侧：lambda表达式的参数列表**
>  **2.  右侧：lambda表达式中所需要执行的功能，即lambda函数体**

