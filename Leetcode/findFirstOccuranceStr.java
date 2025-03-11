public class findFirstOccuranceStr {
    static boolean compare(String haystack, String needle, int idx) {
        int n1 = haystack.length(), n2 = needle.length();
        for(int i=0; i<n2; i++) {
            if(idx >= n1) {
                return false;
            }
            if(haystack.charAt(idx++) != needle.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        for(int i=0; i<n; i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                //Use helping function
                if(compare(haystack, needle, i) == true){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }
}
