package DSA_Sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Arrays {
    // Apna College DSA Sheet
    // #1 Min and Max in Array -> GFG
    public static void getMinMax(int[] arr) {
        // Code Here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        
        // return new Pair(min, max);
        System.out.println(min + " " + max);
    }

    //#2 Reverse Array -> GFG
    public void reverseArray(int arr[]) {
        // code here
        int st = 0, ed = arr.length-1;
        while(st < ed) {
            int temp = arr[st];
            arr[st] =arr[ed];
            arr[ed] = temp;
            st++;
            ed--;
        }
    }

    //#3 Maximum subArray -> Leetcode
    public int maxSubArray(int[] nums) {
        // Kadan's Algorithm
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);

            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
    //#4 Chocolate Distribution Problem -> GFG
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int i = 0;
        int j = m - 1;
        int min = Integer.MAX_VALUE;
        while (j != arr.size()) {
            int diff = arr.get(j) - arr.get(i);
            min = Math.min(min, diff);
            i++;
            j++;
        }
        return min;
    }

    //#5 Contain Duplicates
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    // #6 Majority Element
    public static int findMajorityEle(int arr[]) {
        int candidate = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            }
        }

        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }
        return (count > arr.length / 2) ? candidate : -1;
    }

    // #7 Search in rotated Sorted Arrays 
    public static int searchInRotatedArray(int arr[], int target) {
        int st = 0, ed = arr.length-1; //Two pointer start and ending pointer
        // Search start to end
        while (st <= ed) {
            // find mid
            int mid = st + (ed - st) / 2;

            // target found
            if(arr[mid] == target) {
                return mid;
            }
            
            // find left or right sort
            if(arr[st] <= arr[mid]) { // left sorted arr
                if(arr[st] <= target && target <= arr[mid]) { //left
                    ed = mid - 1;
                } else {//right
                    st = mid + 1;
                }
            }
            // right sorted arr
            else {
                if(arr[mid] <= target && target <= arr[ed]) {//right
                    st = mid + 1;
                }else {//left
                    ed = mid - 1;
                }
            }
        }
        return -1;
    }

    // 

    public static void main(String args[]) {
        int arr[] = {3, 2, 3};
        // int target = 1;
        System.out.println(findMajorityEle(arr));
    }
}
