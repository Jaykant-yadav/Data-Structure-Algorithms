package LeetCode150;

public class Strings {
    // Valid Palindrome
    public static boolean ValidPalindrome(String s){
        String ch = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = ch.length();
        if(ch.length() == 1) return true;
        for(int i=0; i<n/2; i++){
            if(ch.charAt(i) != ch.charAt(n-1-i)){
                return false;
            }
        }

        return true;
    }

    // IS Subsequence
    public static boolean isSubSequence(String s, String t){
        if(s.length() == 0) return true;

        /* int j=0; 
        for(int i=0; i<t.length() && j < s.length(); i++){
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
        }

        if(j == s.length()){
            return true;
        }

        return false; */

        char chs[] = s.toCharArray();
        char cht[] = t.toCharArray();

        int i=0;
        int j=0;

        while (i < chs.length && j < cht.length) {
            if(chs[i] == cht[j]){
                i++;
            }
            j++;
        }

        return i == chs.length;
    }
    public static void main(String[] args) {
        String s = "a";
        String t = "abc";
        System.out.println(isSubSequence(s, t));
    }
}
