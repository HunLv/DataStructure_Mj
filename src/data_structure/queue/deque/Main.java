package data_structure.queue.deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque  = new Deque<>();
        // 想要的队列局面  rear ->4 ->3 ->2 ->1 ->5 front
        deque.enQueueRear(1);
        deque.enQueueRear(2);
        deque.enQueueRear(3);
        deque.enQueueRear(4);

        deque.enQueueFront(5);

        while (!deque.isEmpty()){
            System.out.println(deque.deQueueRear());
        }
    }
}
