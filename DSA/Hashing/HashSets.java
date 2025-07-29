package DSA.Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class HashSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(82);
        set.add(12);
        set.add(12);
        set.add(92);
        set.add(22);
        set.add(22);
        set.add(02);

        Iterator its = set.iterator();
        while (its.hasNext()) {
            System.out.println(its.next());
        }
        System.out.println(set.size()); // 5
        System.out.println(set);// [82, 2, 22, 12, 92]
        System.out.println(set.contains(22));// true
        System.out.println(set.contains(23));// false
        System.out.println(set.remove(22)); // 22 remove and print true
        System.out.println(set); // [82, 2, 12, 92]
        set.clear(); // delete all sets
        System.out.println(set.isEmpty()); // true

        System.out.println("__________________________________________");

        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        // Iterate
        Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        /*
         * Delhi
         * Bengaluru
         * Noida
         * Mumbai
         */

        System.out.println("___________________________");

        for (String city : cities) {
            System.out.println(city);
        }

        /*
         * Delhi
         * Bengaluru
         * Noida
         * Mumbai
         */

    }
}
