package DSA_Sheet.ApnaCollege;

import java.util.Arrays;

import javax.swing.undo.StateEdit;

public class StringsEasy {
    // Valid Palindrome
    // Better approach -> O(n)
    public static boolean isPalindrome(String s){
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int n = str.length();
        System.out.println(str);
        for(int i=0; i<n/2; i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }

    // Optimal Approach Using recursion 
    private static boolean isPalindrome2(String s){
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return checkRec(str, 0, str.length()-1);
    }

    private static boolean checkRec(String str, int left, int right){
        if(left >= right) return true;
        if(str.charAt(left) != str.charAt(right)){
            return false;
        }

        return checkRec(str, left+1, right-1);
    }

    // Longest Common Prefix
    public static String longestCommonPrefix(String[] str) {
        StringBuilder sb = new StringBuilder(""); //create sb for storing LCP
        Arrays.sort(str);//sort complete arrays

        char first[] = str[0].toCharArray(); //string of arrays first element convert char in arrays
        char second[] = str[str.length-1].toCharArray();//string of arrays last element convert char in arrays
        for(int i=0; i<str.length; i++){
            if(first[i] != second[i]){ //if first and second not equal break loop
                break;
            }

            sb.append(first[i]); // LCP append in Sb
        }

        return sb.toString();
    }

    // Valid Anagram
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false; // if string length not equal bot strings are invalid anagram

        int value[] = new int[26];// new array
        for(int i=0; i<s.length(); i++){
            value[s.charAt(i) - 'a']++;// ASCII value of 'a' is 97 and 'z' is 122
            value[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<value.length; i++){
            if(value[i] != 0){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static void printFun(int nums[]){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
