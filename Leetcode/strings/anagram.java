package strings;
import java.util.*;
//Valid Anagrams
public class anagram {
    public static boolean anagram(String s1, String s2) {
        if(s1.length() != s2.length()){ //both strings of length not equal to so return false
            return false;
        }
        char[] ch1 = s1.toCharArray(); //Every String to convert charactor of Arrays ['J', 'A', 'Y']
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1); //Sort Arrays
        Arrays.sort(ch2);
        int idx1 = 0, idx2 = 0;
        while (idx1 < ch1.length && idx2 < ch2.length) {
            if(ch1[idx1] != ch2[idx2]){
                return false;
            }
            idx1++;
            idx2++;
        }       
        return true;
    }
    public static void main(String[] args) {
        /* String str = "Jaykant";
        char[] Array = str.toCharArray();
        for(int i=0; i<Array.length; i++) {
            System.out.println(Array[i]);
        } */

        String s1 = "gedks";
        String s2 = "skdeg";
        System.out.println(anagram(s1, s2));
    }
}
