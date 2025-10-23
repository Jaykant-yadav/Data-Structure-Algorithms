package DSA_Sheet.ApnaCollege;

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
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // String s = "race a car";
        // System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s));
    }
}
