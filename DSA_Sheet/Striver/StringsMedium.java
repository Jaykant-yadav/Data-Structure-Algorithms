package DSA_Sheet.Striver;

public class StringsMedium {
    public static String reveString(String s){
        String rev = "";
        for(int i=s.length()-1; i>=0; i--){
            rev += s.charAt(i);
        }
        return rev;
    }
    public static String reverseWords(String s){
        int n = s.length();
        s = reveString(s);
        String ans = "";
        for(int i=0; i<s.length(); i++){
            String word = "";
            while (i < n && s.charAt(i) != ' ') {
                word += s.charAt(i);
                i++;
            }

            word = reveString(word);
            if(!word.isEmpty()){
                ans += word + " ";
            }
        }
        return ans.trim();
    }
    public static void main(String[] args) {
        String str = "The sky is blue";
        System.out.println(reverseWords(str));
    }
}
