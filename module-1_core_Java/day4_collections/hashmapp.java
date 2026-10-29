package day4_collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class hashmapp {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(1, "Raman");
        mp.put(2, "Sumit");
        mp.put(3, "Prashant");
        mp.put(4, "Ram");
        mp.put(5, "Sunny");
        mp.put(6, "Amit");
        System.out.println("elements of hashmap:" + mp);

        // linked hashmap using key value and lambda function
        Map<Integer, String> linkedMp = new LinkedHashMap<>(mp);
        System.out.println("elements of linkedhashmap (using lambda):");
        linkedMp.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}

