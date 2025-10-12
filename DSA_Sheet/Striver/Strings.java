package DSA_Sheet.Striver;

import java.util.*;
import java.util.Arrays;

public class Strings {
    // Largest Odd Number in String
    // Brute force
    public static String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder("");
        long n = Long.parseLong(num);
        while (n >= 0) {
            long m = n % 10;
            if (m % 2 != 0) {
                return sb.append(n).toString();
            }

            n = n / 10;
        }

        return " ";
    }

    // Better Approach
    public static String largestOddNumber2(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return " ";
    }

    // Optimal Approach
    public static String largestOddNumber3(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return " ";
    }

    // Longest Common Prefix
    // Brute force Solution - O(n^2)
    public static String longestCommonPrefix(String str[]) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length; i++) {
            // Select first element and traverse on whole letter one by one
            char ch = str[0].charAt(i);
            for (int j = 0; j < str.length; j++) {
                // compare with all strings of letter one by one
                if (ch != str[j].charAt(i)) {
                    break;
                } else if (j == str.length - 1) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    // Optimize Solution - O(N * log N + M)
    public static String longestCommonPrefix2(String str[]) {
        StringBuilder result = new StringBuilder("");
        // sort string Arrays
        Arrays.sort(str);

        char first[] = str[0].toCharArray(); // select first element
        char last[] = str[str.length - 1].toCharArray();// select last element
        // traverse on first or last element one by one
        for (int i = 0; i < first.length; i++) {
            // compare first and last element if letter common so add on result
            if (first[i] != last[i]) {
                return result.toString();
            }

            result.append(first[i]);
        }

        return result.toString();
    }

    // Isomorphic Strings
    // Brute Force
    public static boolean isomorphicStr(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashSet<Character> ss = new HashSet<>();
        HashSet<Character> tt = new HashSet<>();
        for (int i = 0; i < s.length() && i < t.length(); i++) {
            ss.add(s.charAt(i));
            tt.add(t.charAt(i));
        }
        return ss.size() == tt.size();
    }

    // Optimal Solution
    public static boolean isomorphicStr2(String s, String t) {
        if (s.length() != s.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = s.charAt(i);
            // original key doesn't contain in map And similar to value
            if (!map.containsKey(original)) {
                if (!map.containsValue(replacement)) {
                    map.put(original, replacement);
                } else {
                    return false;
                }
            } else { // compare with all ready map of value with replacement
                char mappedCharacter = map.get(original);
                if (mappedCharacter != replacement) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isomorphicString(String s, String t) {
        // Arrays to track last seen positions of characters in s and t
        int[] m1 = new int[256], m2 = new int[256];

        // Get length of the strings
        int n = s.length();

        // Loop through all characters in the strings
        for (int i = 0; i < n; ++i) {
            // Return false if mapping is inconsistent
            if (m1[s.charAt(i)] != m2[t.charAt(i)])
                return false;

            // Update last seen index for both characters
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }

        // Return true if all character mappings are consistent
        return true;
    }

    // Rotate String
    public static boolean rotatedStr(String s, String goal){
        StringBuilder res = new StringBuilder("");
        if(s.length() == goal.length()){
            res.append(s).append(s);
            for(int i=0; i<s.length(); i++){
                String x = res.substring(i, goal.length()+i);
                if(x.equals(goal)){
                    return true;
                }
            }
        }
        
        return false;
    }

    // Valid Anagram
    // Brute Force - O(n^2)
    public static boolean isValidAnagram(String s, String t){
        char ch[] = s.toCharArray();
        char ch2[] = t.toCharArray();
        if(s.length() != t.length()) return false;
        Arrays.sort(ch);
        Arrays.sort(ch2);
        for(int i=0; i<s.length(); i++){
            if(ch[i] != ch2[i]){
                return false;
            }
        }

        return true;
    }   

    // Better approach
    public static boolean isValidAnagram2(String s, String t){
        if(s.length() != t.length()) return false;

        int value[] = new int[26];
        for(int i=0; i<s.length(); i++){
            value[s.charAt(i) - 'a']++;
            value[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<26; i++){
            if(value[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ggii";
        String t = "eekk";
        
        // System.out.println(isValidAnagram2(s, t));
        System.out.println(isValidAnagram(s, t));
        // System.out.println('r' ^ 't');
        
    }

    public static void strPrint(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }

}
