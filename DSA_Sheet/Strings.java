package DSA_Sheet;
import java.util.*;
public class Strings {
    public static void reverseString(char s[]) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap s[left] and s[right]
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        char ch[] = {'h', 'e', 'l', 'l', 'o'};
        
        reverseString(ch);
        for(int i=0; i<ch.length; i++) {
            System.out.print(ch[i] + " ");
        }
        // System.out.println(ch.length);
    }
}
