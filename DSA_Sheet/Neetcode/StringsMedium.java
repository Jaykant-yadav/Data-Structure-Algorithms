package DSA_Sheet.Neetcode;
import java.util.*;

public class StringsMedium {
    // Brute force - using sorting
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        boolean visited[] = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (visited[i])
                continue;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && sort(strs[i]).equals(sort(strs[j]))) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            list.add(group);
        }

        return list;
    }

    // Better Approach - using sorting
    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String key = sort(s);
            // check duplicate key in map
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private static String sort(String strs) {
        char ch[] = strs.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    // Optimal Approach - using freq
    public static List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<String, List<String>> freqStrMap = new HashMap<>();
        for(String str : strs){
            String freqString = getFreqString(str);

            if(!freqStrMap.containsKey(freqString)){
                freqStrMap.put(freqString, new ArrayList<>());
            }

            freqStrMap.get(freqString).add(str);
        }

        return new ArrayList<>(freqStrMap.values());
    }

    private static String getFreqString(String str){
        int freq[] = new int[26];

        for(char c : str.toCharArray()){
            freq[c - 'a']++;
        }

        StringBuilder freqStr = new StringBuilder("");
        char c = 'a';
        for(int i : freq){
            freqStr.append(c);
            freqStr.append(i);
            c++;
        }
        return freqStr.toString();
    }

    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }
    
}
