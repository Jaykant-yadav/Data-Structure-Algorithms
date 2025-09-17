package DSA.Strings;

import java.util.*;

public class Assignment {
    // Count Vowel - O(n)
    public static int countLowerCaseVowel(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        return count;
    }

    // Check 2 Strings are Anagram or not
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int n : freq) {
            if (n != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String userStr = sc.nextLine();
        // System.out.println(countLowerCaseVowel(userStr));

        // What will be the output of the following code
        String str = "Jaykant";
        String str2 = "TITCollege";
        String str3 = "Jaykant";
        // System.out.println(str.equals(str2) + " " + str.equals(str3));
    }
}
