package DSA.Hashing;

import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm); // {China=150, US=50, India=100}

        // Get - O(1)
        int population = hm.get("India");
        System.out.println(population); // 100

        System.out.println(hm.get("Indonesia")); // null

        // Contains Key - O(1)
        System.out.println(hm.containsKey("China")); // true
        System.out.println(hm.containsKey("UK")); // false

        // Remove - O(1)
        // System.out.println(hm.remove("China"));// 150
        System.out.println(hm); // {US=50, India=100}
        // System.out.println(hm.remove("UK")); // null
        System.out.println(hm); // {US=50, India=100}

        // Size
        System.out.println(hm.size()); // 3

        // isEmpty
        System.out.println(hm.isEmpty());// false
        // hm.clear(); // clear all data
        System.out.println(hm.isEmpty());// true

        // System.out.println(hm.clone());
        System.out.println("____________________________________");
        // insert more data
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        // Iterate
        // hm.entrySet()
        Set<String> keys = hm.keySet();
        System.out.println(keys); // [China, US, Nepal, India, Indonesia]

        for (String key : keys) {
            System.out.println("key=" + key + ", value=" + hm.get(key));
        }

        /*
         * key=China, value=150
         * key=US, value=50
         * key=Nepal, value=5
         * key=India, value=100
         * key=Indonesia, value=6
         */

        System.out.println("___________________________");

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        /*
         * China => 150
         * US => 50
         * Nepal => 5
         * India => 100
         * Indonesia => 6
         */

    }
}
