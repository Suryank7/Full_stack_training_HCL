package day4_collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class priority_queue {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> anotherQueue = new PriorityQueue<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        anotherQueue.add(10);
        anotherQueue.add(20);
        anotherQueue.add(30);

        System.out.println("Queue: " + queue);

        System.out.println("Highest priority element: " + queue.peek());

        System.out.println("Remove 20: " + queue.remove(Integer.valueOf(20)));
        System.out.println("After remove: " + queue);

        System.out.println("Size: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Contains 30: " + queue.contains(30));

        System.out.println("Removed highest priority element: " + queue.poll());
        System.out.println("After poll: " + queue);

        System.out.println("Are queues equal: " +
                (queue.size() == anotherQueue.size()
                        && queue.containsAll(anotherQueue)
                        && anotherQueue.containsAll(queue)));
    }
}