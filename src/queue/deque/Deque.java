package queue.deque;

import queue.list.LinkedList;

/**
 * @description: 自己的 双端队列
 * @create: 2020-07-17-08:10
 * @finish:
 **/
public class Deque<E> {
    private LinkedList<E> list = new LinkedList<>();

    /**
     * 从 队尾 入队
     * @param element
     */
    public void enQueueRear(E element) {
        list.add(element);
    }

    public void enQueueFront(E element) {
        list.add(0,element);
    }

    public E deQueueFront() {
        return list.remove(0);
    }

    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public E front() {
        return list.get(0);
    }

    public E rear() {
        return list.get(list.size() - 1);
    }
}
