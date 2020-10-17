# 队列

## 实战

### 使用 LinkedList 作为实现（普通队列）

例子：

https://leetcode-cn.com/submissions/detail/93094214/

层序遍历

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode iterator = (TreeNode) queue.poll();
            // 交换节点
            TreeNode temp = iterator.left;
            iterator.left = iterator.right;
            iterator.right = temp;

            if (iterator.left != null) {
                queue.offer(iterator.left);
            }
            if (iterator.right != null) {
                queue.offer(iterator.right);
            }
        }
        return root;
    }

}
```



###  使用 ArrayDeque 作为实现(双端队列)

例子:

https://leetcode-cn.com/submissions/detail/94043558/

    public int getWinner_AC(int[] arr, int k) {
        int length = arr.length;
        if (k >= length) return Arrays.stream(arr).max().orElse(0);
    
        Deque<Integer> deque = new ArrayDeque<>(length);
        for (int i:arr){
            deque.addLast(i);
        }
    
        int count = 0;
        while (count < k){
            int first = deque.removeFirst();
            int second = deque.removeFirst(); // TODO
            if (first > second){
                count ++;
                deque.addFirst(first);
                deque.addLast(second);
            }else {
                count = 1;
                deque.addFirst(second);
                deque.addLast(first);
            }
        }
        return deque.peekFirst(); // todo
    }

## 基础知识

### ArrayDeque 

#### 简要介绍

> ArrayDeque 是 Deque 接口的一种具体实现，是依赖于可变数组来实现的。ArrayDeque 没有容量限制，可根据需求自动进行扩容。
> ArrayDeque 可以作为栈来使用，效率要高于 Stack；
> ArrayDeque 也可以作为队列来使用，效率相较于基于双向链表的 LinkedList 也要更好一些。
> 注意，ArrayDeque 不支持为 null 的元素。

#### 常规操作

```java
// 创建
int length = 10;
Deque<Integer> deque = new ArrayDeque<>(length); // 需要指定大小
```

Deque 和 Queue 方法的的对应关系如下：

| Queue Method | Equivalent Deque Method |
| ------------ | ----------------------- |
| add(e)       | addLast(e)              |
| offer(e)     | offerLast(e)            |
| remove()     | removeFirst()           |
| poll()       | pollFirst()             |
| element()    | getFirst()              |
| peek()       | peekFirst()             |

Deque 和 Stack 方法的对应关系如下：

| Stack Method | Equivalent Deque Method |
| ------------ | ----------------------- |
| push(e)      | addFirst(e)             |
| pop()        | removeFirst()           |
| peek()       | peekFirst()             |

#### 参考

https://xxxblank.github.io/2017/08/15/deque/

https://www.jianshu.com/p/2f633feda6fb

[https://blog.jrwang.me/2016/java-collections-deque-arraydeque/#%E5%B0%8F%E7%BB%93](https://blog.jrwang.me/2016/java-collections-deque-arraydeque/#小结)





 

