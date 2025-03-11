package strings;
//Valid Palindrome
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int st = 0, end = s.length()-1;
        s = s.toLowerCase();
        while (st < end) {
            char ch1 = s.charAt(st);
            char ch2 = s.charAt(end);
            if(!(ch1 >= 'a' && ch1 <= 'z' || ch1 >= '0' && ch2 <= '9')){
                st++;continue;
            }
            if(!(ch2 >= 'a' && ch2 <= 'z' || ch2 >= '0' && ch2 <= '9')){
                end--;continue;
            }
            if(s.charAt(st) != s.charAt(end)){
                return false;
            }
            st++; end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
}
