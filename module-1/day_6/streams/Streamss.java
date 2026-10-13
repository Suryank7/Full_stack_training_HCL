package day_6.streams;
import java.util.*;

public class Streamss {
    static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        list.stream().filter(a -> a % 2 == 0).map(a -> a * a).forEach(System.out::println);
        long count = list.stream().filter(a -> a % 2 == 0).count();
        System.out.println("count of elements "+count);
    }

}