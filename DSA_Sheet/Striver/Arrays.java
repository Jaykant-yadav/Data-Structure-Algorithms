package DSA_Sheet.Striver;

import java.util.*;
public class Arrays {
    // Largest elemet in a Array
    public static void largestEle(int arr[]){ // O(n)
        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer.MAX_VALUE;
        for(int ele : arr){
            maxEle = Math.max(maxEle, ele);
            minEle = Math.min(minEle, ele);
        }

        System.out.println("Largest Element : " + maxEle);
        System.out.println("Smallest Element : " + minEle);
    }

    // Check if array sorted or not
    public static boolean isSorted(int arr[], int i){ //O(n)
        /* for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[i-1]){
                // return true;
            }else{
                return false;
            }
        } */

        if(i >= arr.length){
            return true;
        }

        if(arr[i] > arr[i-1]){
            
        }else {
            return false;
        }
        return isSorted(arr, i+1);
    }

    // Check if Array Is Sorted and Rotated
    public static boolean isSortedOrRotated(int arr[]){ // O(n)
        int peek = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                peek++;
            }
        }

        if(arr[arr.length-1] > arr[0]){
            peek++;
        }

        return peek <= 1;
    }

    // Remove Duplicates from Sorted Array
    public static int removeDuplicates(int nums[]){ //O(n) & O(1)
        int k = 1; // first element always unique element

        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[k-1]){
                nums[k] = nums[i];
                k++;
            }
        }

        
        // If only return k so in case use Hashset
        HashSet<Integer> set = new HashSet<>(); //O(n)
        for(int n : nums){
            set.add(n);
        }
        
        // return set.size();
        return k;
    }

    // Rotate Array
    // Left Rotate an array by one place -> O(n) & O(1)
    public static void onePlaceRotated(int nums[]){
        int temp = nums[0];
        for(int i=1; i<nums.length; i++){
            nums[i-1] = nums[i];
        }

        nums[nums.length-1] = temp;
    }

    // Left Rotate an array by K places
    // Brute Force -> O(n + k)
    public static void kPlacesRotated(int arr[], int k){
        int n = arr.length;
        k = k % n;
        for(int i=0; i<k; i++){
            int temp = arr[0];
            for(int j=1; j<n; j++){
                arr[j-1] = arr[j];
            }
            arr[n-1] = temp;
        }
    }

    // O(n+k) & O(k)
    public static void kPlacesRotated2(int arr[], int k){
        int n = arr.length;
        int temp[] = new int[k];

        for(int i=0; i<k; i++){
            temp[i] = arr[i];
        }

        int j = 0;
        for(int i=k; i<arr.length; i++){
            arr[j++] = arr[i]; 
        }
        for(int i=n-k; i<arr.length; i++){
            arr[i] = temp[i-(n-k)];
        }
    }

    // Optimal Approach -> O(n) & O(1)
    public static void reverseArr(int arr[], int st, int ei){
        while (st < ei) {
            int temp = arr[st];
            arr[st] = arr[ei];
            arr[ei] = temp;
            st++;
            ei--;
        }
    }
    public static void kPlacesRotated3(int arr[], int k){
        int n = arr.length;
        reverseArr(arr, 0, k); //O(k)
        reverseArr(arr, k+1, n-1); //O(n-k)
        reverseArr(arr, 0, n-1); //O(n) -> total -> O(2n) -> O(n)
    }

    // Right Rotate an array by K places
    // Brute Force -> O(n + k)
    public static void rotateArr(int nums[], int k){
        int n = nums.length;
        for(int i=0; i<k; i++){
            int temp = nums[n-1];
            for(int j=n-1; j>=1; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    // Optimal Approach
    public static void rotateArr2(int nums[], int k){
        int n = nums.length;
        k = k % n;
        reverseArr(nums, 0, n-k-1);
        reverseArr(nums, n-k, n-1);
        reverseArr(nums, 0, n-1);
    }
    public static void main(String[] args) {
        // int arr[] = {1,2,3,4,5,6,7};
        int arr[] = {-1, 99, -100, 3};
        rotateArr2(arr, 2);
        printArr(arr);
    }

    public static void printArr(int nums[]){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}

