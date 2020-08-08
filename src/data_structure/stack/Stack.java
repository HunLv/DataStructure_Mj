package data_structure.stack;

import data_structure.stack.list.ArrayList;
import data_structure.stack.list.List;

/**
 * @description: 自己实现栈
 * @create: 2020-07-15-23:26
 * @finish:
 **/
public class Stack<E> {
    private List<E> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E top() {
        return list.get(list.size() - 1);
    }
}
