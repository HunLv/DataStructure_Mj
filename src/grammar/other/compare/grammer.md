## 比较
## 数据(Person) 实现 Comparable  接口

>   先编写 Comparable 接口;
>
>   比较的对象(例如 Person)统一实现 Comparable 接口的比较方法 compareTo;
>
>   比较的时候，直接使用 compareTo 方法，缺点是，用户如果想调整需求，必须改动 Person 的 compareTo 方法，不能个性化



## 使用数据的对象( BinarySearchTree)持有 Comparator 接口,用互自定义数据（Person）比较逻辑，个性化需求

>先编写 Comparator 接口,
>约定比较方法为 compare();
>
>在 BinarySearchTree 将 Comparator  作为成员,
>并且编写一个要求传入 Comparator 类型参数 的构造器;
>
>在 BinarySearchTree 中 用到数据比较的地方， 调用 Comparator 接口的比较方法 compare 完成任务;( 现在 Comparator 还仅仅是一个接口，并未实现，需要用户指定)
>
>Main 使用  BinarySearchTree 的时候，自己实例化不同需求的 Comparator, (现在的 compare 才真正实现了 具体功能)
>将其作为参数传给 BinarySearchTree 的 构造器;



## 3 问题：上述方法2 强制用户传入comparator

思考如果用户不想指定构造器，而是只想使用默认的怎么办，如何做到既能个性化定制需求，又能不强制性用户定义呢？做到良好的兼容性？

Hint:

> 1 设计一个 无参的 构造函数，默认调用有参的构造函数，传入的参数是 null ，也就是默认将 comparator 设置为 null
>
> 2 在 BinarySearchTree 要比较元素的地方，进行决策：
>
> > 如果传入了 comparator ,也就是 comparator  ！= null ,优先使用 comparator 的比较方法；
> >
> > 如果用户没有传入，就**强制**将 比较 的数据 Person 的类型转换  为Comparable<E> 类型，也就是要求 Person 必须是 Comparable 的子类，也就是必须 implements Comparable 接口

## 4 使用官方的 java.lang.Comparable 和java.util.Comprator



## 5 匿名类（代码更紧凑）