package DSA.Hashing;
import java.util.*;;
public class LinkedHashMaps {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 180);
        lhm.put("UK", 190);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 180);
        hm.put("UK", 190);

        System.out.println(hm); //{China=150, UK=190, US=180, India=100}
        System.out.println(lhm); //{India=100, China=150, US=180, UK=190}

    }
}
