package data_structure.queue;


/**
 * @description: 测试 自己写的 Queue
 * @create: 2020-07-16-07:53
 **/
public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enQueue(0);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        while (! queue.isEmpty()){
            System.out.println(queue.deQueue());
        }
    }
}
