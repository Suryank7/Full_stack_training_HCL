package day4_collections;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class collections {
    static   List <Integer> Queue = new LinkedList<>();
    static  List <Integer> anotherQueue = new LinkedList<>();
    public static void main(String[] args) {
        Queue.add(10);
        Queue.add(20);
        Queue.add(30);

        anotherQueue.add(10);
        anotherQueue.add(20);
        anotherQueue.add(30);

        System.out.println("Queue: " + Queue);

        Queue.remove(0);
        System.out.println("After remove: " + Queue);

        System.out.println("First element: " + Queue.get(0));
        System.out.println("Last element: " + Queue.get(Queue.size() - 1));
        System.out.println("Size: " + Queue.size());
        System.out.println("Is empty: " + Queue.isEmpty());
        System.out.println("Contains 30: " + Queue.contains(30));

        Queue.set(0, 50);
        System.out.println("After set: " + Queue);

        System.out.println("Are queues equal: " + Queue.equals(anotherQueue));
    }
//    public static void main(String[] args) {
//        Queue.add(10);
//        Queue.add(20);
//        Queue.add(30);
//
//        anotherQueue.add(10);
//        anotherQueue.add(20);
//        anotherQueue.add(30);
//
//        System.out.println("Queue: " + Queue);
//
//        Queue.remove(0);
//        System.out.println("After remove: " + Queue);
//
//        System.out.println("First element: " + Queue.get(0));
//        System.out.println("Last element: " + Queue.get(Queue.size() - 1));
//        System.out.println("Size: " + Queue.size());
//        System.out.println("Is empty: " + Queue.isEmpty());
//        System.out.println("Contains 30: " + Queue.contains(30));
//
//        Queue.set(0, 50);
//        System.out.println("After set: " + Queue);
//
//        System.out.println("Are queues equal: " + Queue.equals(anotherQueue));
//    }
}
