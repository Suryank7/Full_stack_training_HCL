package com.collections.practise;;
import java.util.ArrayList;
import java.util.List;

public class Collectionss {
    public static void main(String[] args) {
        List <Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.println("size"+numbers.size());
        System.out.println(numbers);
        System.out.println("is_contain"+numbers.contain(20));
        System.out.println("is_contain"+numbers.contain(80));

    numbers.set(2,40);
    numbers.set(3,30);

  numbers.stream().filer(n->n<40).forEach(n-> System.out.println(""+n));
        List <Integer> expected = List.of(
                10, 20, 40, 30, 50, 60, 70, 80, 90, 100
        );
        System.out.println("is same"+numbers.equals(expected));
        System.out.println("is same"+numbers.isEmpty());

        numbers.clear();

        System.out.println("After clear: " + numbers);
        System.out.println("Is empty after clear: " + numbers.isEmpty());
    }
}
