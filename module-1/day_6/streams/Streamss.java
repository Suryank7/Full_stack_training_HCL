package day_6.streams;
import java.util.*;
import java.util.stream.Collectors;

public class Streamss {
    static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> list2 = Arrays.asList(
                "super", "star", "server", "sugar", "silver",
                "sailor", "speaker", "summer"
        );
//        list.stream().filter(a -> a % 2 == 0).map(a -> a * a).forEach(System.out::println);
        List<Integer> list1 =  list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
//        long count = list.stream().filter(a -> a % 2 == 0).count();
//        System.out.println("value of elements "+list1);
//        System.out.println("count of elements "+count);

        list2.stream()
                .filter(a -> a.startsWith("s") && a.endsWith("r"))
                .max(Comparator.comparingInt(String::length))
                .ifPresent(System.out::println);
    }

}