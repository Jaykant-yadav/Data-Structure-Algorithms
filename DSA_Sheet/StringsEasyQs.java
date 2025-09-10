package DSA_Sheet;

import java.util.*;

public class StringsEasyQs {
    // Valid Palindrome
    // Brute Force -> O(n) -> O(1)
    public static boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;

        while (start <= end) {
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }else if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }else{
                start++;
                end--;
            }
        }

        return true;
    }

    // TC- O(n) SC-> O(1)
    public static boolean isPalindrome2(String s){
        String ch = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int i=0; i<ch.length()/2; i++){
            if(ch.charAt(i) != ch.charAt(ch.length()-1-i)){
                return false;
            }
        }

        return true;
    }
    
    // Longest Common Prefix -> O(n ^ 2)
    public static String longestCommonPrefix(String[] strs) {
        for(int i=0; i<strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(i >= strs.length || strs[j].charAt(i) != ch){
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    // Valid Anagram
    public static boolean validAnagram(String s, String t){ //
        if(s.length() != t.length()) return false;
        char [] ch1 = s.toCharArray();
        char [] ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i=0; i<ch1.length; i++){
            if(ch1[i] != ch2[i]){
                return false;
            }
        }

        return true;
    }

    public static boolean validAnagram2(String s, String t){
        if(s.length() != t.length()) return false;
       /*  char arr1[] = new char[26];
        char arr2[] = new char[26];

        for(int i=0; i<s.length(); i++){
            arr1[s.charAt(i) - 'a']++;
            arr2[t.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]) return false;
        }
 */

        int freq[] = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int n : freq){
            if(n != 0) return false;
        }
        return true;
    }

    public static boolean validAnagram3(String s, String t){
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> hms = new HashMap<>();
        HashMap<Character, Integer> hmt = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            hms.put(s.charAt(i), hms.getOrDefault(s.charAt(i), 0) + 1);
            hmt.put(t.charAt(i), hmt.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: hms.entrySet()){
            if(entry.getValue() != hmt.get(entry.getKey())){
                return false;
            }
        }

        return true;
    }

    public static String reverseWords(String str){
        // String s = str.replaceAll("[^A-Za-z0-9]", "");
        StringBuilder sb = new StringBuilder("");
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }

        for(int i=0; i<sb.length(); i++){
            // if(sb.charAt(i) == ' ' )
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s3 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome2(s3));
        String strs[] = {"flower", "flow", "flight"};
        // String strs[] = {"strong", "suroty", "soron"};
        // System.out.println(longestCommonPrefix(strs));

        String s = "anagram";
        String t = "nagaram";
        // System.out.println(validAnagram2(s, t));
        // System.out.println(validAnagram3(s, t));
        // validAnagram2(s, t);

        String s2 = "  hello world  ";
        // System.out.println(reverseWords(s2));

    }
}
