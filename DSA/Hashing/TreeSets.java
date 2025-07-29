package DSA.Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TreeSets {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Bengaluru");

        LinkedHashSet<String> lsh = new LinkedHashSet<>();
        lsh.add("Mumbai");
        lsh.add("Delhi");
        lsh.add("Noida");
        lsh.add("Bengaluru");

        TreeSet<String> tm = new TreeSet<>();
        tm.add("Mumbai");
        tm.add("Delhi");
        tm.add("Noida");
        tm.add("Bengaluru");

        System.out.println(lsh);//[Mumbai, Delhi, Noida, Bengaluru]
        System.out.println(cities);//[Delhi, Bengaluru, Noida, Mumbai]
        System.out.println(tm);//[Bengaluru, Delhi, Mumbai, Noida]
    }
}
