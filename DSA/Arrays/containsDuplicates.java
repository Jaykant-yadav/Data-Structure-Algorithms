package DSA.Arrays;

import java.util.*;

public class containsDuplicates {
    //Time Complexity -> O(n)
    public static boolean twichElement(int num[]){
        //sort arrays
        Arrays.sort(num);
        for(int i=1; i<num.length; i++) {
            //compairs
            if(num[i] == num[i-1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int num[] = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(twichElement(num));
    }    
}