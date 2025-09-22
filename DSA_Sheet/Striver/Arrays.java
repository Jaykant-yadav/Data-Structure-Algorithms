package DSA_Sheet.Striver;

import java.util.*;

public class Arrays {
    // Largest elemet in a Array
    public static void largestEle(int arr[]) { // O(n)
        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer.MAX_VALUE;
        for (int ele : arr) {
            maxEle = Math.max(maxEle, ele);
            minEle = Math.min(minEle, ele);
        }

        System.out.println("Largest Element : " + maxEle);
        System.out.println("Smallest Element : " + minEle);
    }

    // Check if array sorted or not
    public static boolean isSorted(int arr[], int i) { // O(n)
        /*
         * for(int i=1; i<arr.length; i++){
         * if(arr[i] > arr[i-1]){
         * // return true;
         * }else{
         * return false;
         * }
         * }
         */

        if (i >= arr.length) {
            return true;
        }

        if (arr[i] > arr[i - 1]) {

        } else {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // Check if Array Is Sorted and Rotated
    public static boolean isSortedOrRotated(int arr[]) { // O(n)
        int peek = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                peek++;
            }
        }

        if (arr[arr.length - 1] > arr[0]) {
            peek++;
        }

        return peek <= 1;
    }

    // Remove Duplicates from Sorted Array
    public static int removeDuplicates(int nums[]) { // O(n) & O(1)
        int k = 1; // first element always unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        // If only return k so in case use Hashset
        HashSet<Integer> set = new HashSet<>(); // O(n)
        for (int n : nums) {
            set.add(n);
        }

        // return set.size();
        return k;
    }

    // Rotate Array
    // Left Rotate an array by one place -> O(n) & O(1)
    public static void onePlaceRotated(int nums[]) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = temp;
    }

    // Left Rotate an array by K places
    // Brute Force -> O(n + k)
    public static void kPlacesRotated(int arr[], int k) {
        int n = arr.length;
        k = k % n;
        for (int i = 0; i < k; i++) {
            int temp = arr[0];
            for (int j = 1; j < n; j++) {
                arr[j - 1] = arr[j];
            }
            arr[n - 1] = temp;
        }
    }

    // O(n+k) & O(k)
    public static void kPlacesRotated2(int arr[], int k) {
        int n = arr.length;
        int temp[] = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        int j = 0;
        for (int i = k; i < arr.length; i++) {
            arr[j++] = arr[i];
        }
        for (int i = n - k; i < arr.length; i++) {
            arr[i] = temp[i - (n - k)];
        }
    }

    // Optimal Approach -> O(n) & O(1)
    public static void reverseArr(int arr[], int st, int ei) {
        while (st < ei) {
            int temp = arr[st];
            arr[st] = arr[ei];
            arr[ei] = temp;
            st++;
            ei--;
        }
    }

    public static void kPlacesRotated3(int arr[], int k) {
        int n = arr.length;
        reverseArr(arr, 0, k); // O(k)
        reverseArr(arr, k + 1, n - 1); // O(n-k)
        reverseArr(arr, 0, n - 1); // O(n) -> total -> O(2n) -> O(n)
    }

    // Right Rotate an array by K places
    // Brute Force -> O(n + k)
    public static void rotateArr(int nums[], int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    // Optimal Approach -> O(n)
    public static void rotateArr2(int nums[], int k) {
        int n = nums.length;
        k = k % n; // to handle k > n

        // Step 1: reverse first n-k elements
        reverseArr(nums, 0, n - k - 1);

        // Step 2: reverse last k elements
        reverseArr(nums, n - k, n - 1);

        // Step 3: reverse the whole array
        reverseArr(nums, 0, n - 1);
    }

    // Linear Search -> O(n) -> Using Recursion
    public static int linearSearch(int nums[], int key, int i) {
        // Base Case
        if (i == nums.length) {
            return -1;
        }

        if (nums[i] == key) {
            return i;
        }

        return linearSearch(nums, key, i + 1);
    }

    // Find the Union
    // Using Set and Map
    public static void findUnion(int nums1[], int nums2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int n1 : nums1) {
            set.add(n1);
        }

        for (int n2 : nums2) {
            set.add(n2);
        }

        for (int s : set) {
            System.out.print(s + " ");
        }
    }

    // Two Pointer
    public static void findUnion2(int n1[], int n2[]) {
        int i = n1.length - 1, j = n2.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (i >= 0 && j >= 0) {
            if (n1[i] == n2[j]) {
                list.add(n1[i]);
                i--;
                j--;
            } else if (n1[i] > n2[j]) {
                list.add(n1[i--]);
            } else {
                list.add(n2[j--]);
            }
        }

        while (i >= 0) {
            list.add(n1[i--]);
        }

        while (j >= 0) {
            list.add(n2[j--]);
        }

        for (int k = 0; k < list.size(); k++) {
            System.out.print(list.get(k) + " ");
        }
    }

    // Move Zeroes
    // Brute Force -> O(2n) & sc -> O(n)
    public static void moveZeroes(int nums[]) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { // O(n)
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) { // O(n)
            nums[i] = list.get(i);
        }

        for (int j = list.size(); j < nums.length; j++) { // O(n-x)
            nums[j] = 0;
        }
    }

    // More Optimal Approach -> O(n)
    public static void moveZeroes3(int nums[]) {
        int zero = 0;
        for (int i : nums) {
            if (i != 0) {
                nums[zero++] = i;
            }
        }

        for (int i = zero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // Optimal Approach -> O(n)
    public static void moveZeroes2(int nums[]) {
        if (nums.length == 1) {
            nums[0] = nums[0];
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    // Missing Number
    // Brute Force -> O(n) & O(n)
    public static int missingNumber(int nums[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        for(int i=0; i<=nums.length; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }

    // Better Approach -> O(n)
    public static int missingNumber2(int nums[]){
        int n = nums.length;
        int currValueSum = 0;
        int actualSum = 0;
        for(int m : nums){
            currValueSum += m;
        }

        actualSum = n * (n+1) / 2;
        /* for(int i=0; i<=nums.length; i++){
            actualSum += i;
        } */

        return actualSum - currValueSum;
    }

    // Optimal Approach -> O(n)
    public static int missingNumber3(int nums[]){
        int xor = 0;
        for(int i=0; i<=nums.length; i++){
            xor ^= i;
        }
        System.out.println(xor);
        for(int num : nums){
            xor ^= num;
        }

        return xor;
    }

    // Sliglty Change -> O(n)
    public static int missingNumbers3(int nums[]){
        int xor1 = 0, xor2 = 0;
        int n = nums.length-1;
        for(int i=0; i<n; i++){
            xor2 = xor2 ^ nums[i];
            xor1 = xor1 ^ (i+1);
        }

        xor1 = xor1 ^ n;
        return xor1 ^ xor2;
    }

    // Max Consecutive Ones -> O(n)
    public static int maxConsecutiveOnes(int nums[]){
        int max = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(max, count);
            }else{
                count = 0;
            }
        }

        return max;
    }

    // Single Number
    // Brute force
    public static int singleNumber(int nums[]){
        java.util.Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }

        return -1;        
    }

    // Better Approach -> O(n) & sc -> O(n)
    public static int singleNumber2(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key) <= 1){
                return key;
            }
        }

        return -1;
    }

    // Optimal Approach -> O(n)
    public static int singleNumber3(int nums[]){
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 1};
        System.out.println(singleNumber3(nums));
        // System.out.println(6^2);
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
