import java.util.*;
public class sortColor {
    //Sort array of 0s, 1s & 2s
    //Brute force - O(nlogn)
    public static void sortArray(int nums[]){
        Arrays.sort(nums);
    }

    //Optimized Solution - O(n)
    public static void sortArray1(int nums[]){ // two pass
        int n = nums.length;
        int count = 0, count1 = 0, count2 = 0;
        //O(n)
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                count++;
            } else if(nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        //O(n)
        int idx = 0;
        for(int i=0; i<count; i++) {
            nums[idx] = 0;
            idx++;
        }

        for(int i=0; i<count1; i++) {
            nums[idx] = 1;
            idx++;
        }

        for(int i=0; i<count2; i++) {
            nums[idx] = 2;
            idx++;
        }

    }

    //Optimal Approach - O(n)
    //DNF Algo - Dutch National Flag Algorithm
    public static void DNF(int nums[]){ // single pass
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;

        while (mid <= high) {
            if(nums[mid] == 0){
                //swap
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            } else if(nums[mid] == 1){
                mid++;

            } else { // 2
                //swap
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        sortArray1(nums); 
        // DNF(nums); 
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }      
    }
}
