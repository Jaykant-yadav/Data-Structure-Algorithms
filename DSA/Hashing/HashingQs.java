package DSA.Hashing;
import java.util.*;
public class HashingQs {
    // Anagram Valid or Invalid -> O(n)
    public static boolean isAnangram(String s, String t){
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else {
                    map.put(ch, map.get(ch) - 1);
                }
            }else {
                return false;
            }
        }

        return map.isEmpty();
    }

    // Count Distinct Elements
    public static void countDistinctEle(int nums[]){ //O(n)
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        System.out.println("ans = " + set.size());
    }

    // Union & Intersection of 2 Arrays
    // Union
    public static int unionofArr(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }

        return set.size();
    }

    // Inter - Section
    public static int interSection(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }

        return count;
    }

    public static void unionAndInterSection(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }

        System.out.println("Union : " + set.size());
        System.out.println(set);

        set.clear();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                System.out.print(arr2[i] + " ");
                set.remove(arr2[i]);
            }
        }

        System.out.println("Intersection : " + count);
    }


    // getStart -> Helper fnx
    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key; //starting point
            }
        }

        return null;
    }

    // Find itinerary for tickets
    public static void itineraryOfTickets(HashMap<String, String> tickets){ // O(n)
        String start = getStart(tickets);
        System.out.print(start);
        for(String key : tickets.keySet()){
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
    }
    
    public static void main(String[] args) {
        String s = "race";
        String t = "care";
        // System.out.println(isAnangram(s, t));

        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};

        // Majority Element - O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            /* if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else {
                map.put(arr[i], 1);
            } */

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Set<Integer> keySet = map.keySet();
        // for(Integer key : keySet){
        for(Integer key : map.keySet()){
            if(map.get(key) > arr.length/3){
                // System.out.println(key);
            }
        }

        // Count Distinct Elements
        int nums[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        // countDistinctEle(nums);

        // Union & Intersection of 2 Arrays
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        System.out.println("union = " + unionofArr(arr1, arr2));
        System.out.println("Intersection = " + interSection(arr1, arr2));
        unionAndInterSection(arr1, arr2);

        // Find itinerary for tickets
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        itineraryOfTickets(tickets);
    }
}
