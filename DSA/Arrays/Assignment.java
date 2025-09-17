package DSA.Arrays;
import java.util.*;
public class Assignment {
    public static List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new  ArrayList<>();
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] == nums[i]){
                list.add(nums[i]);
            }
        }

        return list;
    }
    public static void main(String[] args) {
        int nums[] = {4, 5, 7, 9, 5, 3, 8, 7};
        System.out.println(findDuplicates(nums));
    }
}
