package data_structure.queue;

import data_structure.queue.list.LinkedList;
import data_structure.queue.list.List;

/**
 * @description: queue
 * @create: 2020-07-16-07:59
 **/
public class MyQueue<E> {
    
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    /**
     *  获取队头 元素
     * @return
     */
    public E front() {
        return list.get(0);
    }
}
