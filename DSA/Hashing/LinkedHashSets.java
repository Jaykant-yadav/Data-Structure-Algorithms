package DSA.Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSets {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        LinkedHashSet<String> lsh = new LinkedHashSet<>();
        lsh.add("Delhi");
        lsh.add("Mumbai");
        lsh.add("Noida");
        lsh.add("Bengaluru");

        System.out.println(lsh);//[Delhi, Mumbai, Noida, Bengaluru]
        System.out.println(cities);//[Delhi, Bengaluru, Noida, Mumbai]

        lsh.remove("Delhi");
        // All Operations perform like a hashset
    }
}
