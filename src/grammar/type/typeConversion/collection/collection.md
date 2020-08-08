# Collection

## 数组-> List

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
List<Integer> list = new ArrayList<>();
for (int i : array) {
    list.add(i);
}
```

