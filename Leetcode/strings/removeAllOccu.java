package strings;
import java.util.*;

public class removeAllOccu {
    public static String removeAllOccurance(String s, String part){
        int l = part.length();
        while (true) {
            int index = s.indexOf(part);
            if(index > -1){
                s = s.substring(0, index) + s.substring(index+l);
            }else{
                break;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeAllOccurance(s, part));
        System.out.println(s.indexOf(part));
        System.out.println(s.substring(0, 2) + s.substring(s.indexOf(part)+part.length()));
        System.out.println(s.substring(s.indexOf(part)+part.length()));
        System.out.println(part.length());

    }
}
