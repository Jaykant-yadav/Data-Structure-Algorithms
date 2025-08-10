package LeetCode150;

import java.util.HashSet;
import java.util.Set;

public class Array {
    
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static int removeDuplicates2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int k = 0;
        for (Integer s : set) {
            nums[k] = s;
            k++;
        }

        return k;
    }

 
    public static int removeDuplicatesII(int nums[]) {
        /*
         * int i = 0;
         * for(int n : nums){
         * if(i < 2 || n != nums[i-2]){
         * nums[i++] = n;
         * }
         * }
         * 
         * return i;
         */

        if (nums.length <= 2)
            return nums.length;

        int k = 2; // Start from index 2 because we can always keep first two elements1

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    //  Container With Most Water
    public static int mostWater(int height[]){
        if(height.length == 0 || height.length == 1) return 0;
        int left = 0, right = height.length-1;
        int MostWater = 0;

        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            int Water = minHeight * (right - left);
            MostWater = Math.max(Water, MostWater);

            while (left < right && height[left] <= minHeight) {
                left++;
            }

            while (left < right && height[right] <= minHeight) {
                right--;
            }
        }

        return MostWater;
    }

    public static void main(String[] args) {
        // int height[] = {4,2,0,3,2,5};
        // int height[] = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        // int height[] = {1,1,2};
        // System.out.println("d : " + removeDuplicatesII(height));
        // printArr(height);
        // System.out.println(height[height.length-1]);
        // System.out.println("trapped water : " + trappingWater2(height));

        // int nums[] = {2,3,1,1,4};
        int nums[] = {1, 2, 4, 3, 100, 3, 4, 2, 1};
        System.out.println(mostWater(nums));

    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
