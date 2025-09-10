package DSA_Sheet;

import java.util.*;

public class ArraysEasyQS {
    // Majority Element 
    // Approach - I using sorting - O(n logn)
    public static int majorityElements(int nums[]){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Broute Force Approach - O(n ^ 2)
    public static int majorityElement2(int nums[]){
        int n = nums.length;
        for(int num : nums){
            int freq = 0;
            for(int val : nums){
                if(num == val){
                    freq++;
                }
            }

            if(freq > n/2){
                return num;
            }
        }

        return -1;
    }

    public static int majorityElement3(int nums[]){
        int n = nums.length;

        int freq = 0;
        for(int val : nums){
            for(int el : nums){
                if(el == val){
                    freq++;
                }
            }

            if(freq > n/2){
                return val;
            }
        }

        return -1;
    }

    // Better Approach - II 
    public static int majorityElement4(int nums[]){
        Arrays.sort(nums);
        int n = nums.length;
        int freq = 1, ans = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                freq++;
            }else {
                freq = 1;
                ans = nums[i];
            }
        }

        if(freq > n/2){
            return ans;
        }
        return ans;

    }

    // Moore's voting algorithm
    public static int majorityElement5(int nums[]){
        int freq = 0, ans = nums[0];
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(freq == 0){
                ans = nums[i];
            }

            if(ans == nums[i]){
                freq++;
            }else{
                freq--;
            }

            if(freq > n/2){
                return ans;
            }
        }

        return ans;
    }


    public static int majorityElement(int nums[]) { // O(n)
        if (nums.length == 0 || nums.length == 1)
            return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Set<Integer> keySet = map.keySet();
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }

        return -1;
    }



    // Passcal Tringle - I
    public static List<List<Integer>> PascalTringle(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ans.add(1);
                } else {
                    int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    ans.add(val);
                }
            }
            res.add(ans);
        }

        return res;
    }

    // Passcal Tringle - II
    public static List<Integer> PascalTringle2(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    curr.add(1);
                } else {
                    curr.add(res.get(j - 1) + res.get(j));
                }
            }

            res = curr;
        }

        return res;
    }

    // Repeat & missing number - (n ^ 2)
    // Using Hashet
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashSet<Integer> hs = new HashSet<>();
        int a = 0, b;
        int expSum = 0, actualSum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                actualSum += grid[i][j]; // actual sum Calculate
                if(hs.contains(grid[i][j])){
                    a = grid[i][j]; // find Repetation Value
                }else{
                    hs.add(grid[i][j]); // insert in Unique value
                }
            }
        }

        expSum = (n * n) * (n * n + 1) / 2; // expected Sum
        b = expSum + a - actualSum;// missing Value

        return new int[]{a, b};
    }

    // Frequency of Array - O(n)
    public static int[] findMissingAndRepeatedValues2(int [][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int totalElements = n * m;
        int arr[] = new int[totalElements + 1]; // n * m size of array
        int expectedsum = totalElements * (totalElements + 1) / 2; //expected Sum
        int a = 0, b = 0, actualSum= 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int t = grid[i][j];
                actualSum += t;
                if(arr[t] < 2){
                    arr[t]++;
                }
                if(arr[t] == 2){
                    a = t;
                }
            }
        }

        actualSum = actualSum - a;
        b = expectedsum - actualSum;
        return new int[]{a, b};
    }

    // Merge Sorted Array -> O(m+n)
    // Approach - I
    public static void mergeSortedArrays(int nums1[], int nums2[]){
        int m = nums1.length;
        int n = nums2.length;
        int merge[] = new int[m+n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if(nums1[i] > nums2[j]){
                merge[k++] = nums2[j++];
            }else{
                merge[k++] = nums1[i++];
            }
        }

        while (i < m) {
            merge[k++] = nums1[i++];
        }

        while (j < n) {
            merge[k++] = nums2[j++];
        }

        for(int p=0; p<m+n; p++){
            nums1[p] = merge[p];
        }
    }

    // According to leetcode Approach -> O(m+n), O(1)
    public static void mergeSortedArrays2(int nums1[], int nums2[], int n, int m){
        int i = m-1;
        int j = n-1;
        int x = m + n - 1;

        while (i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]){
                nums1[x--] = nums2[j--];
            }else {
                nums1[x--] = nums1[i--];
            }
        }

        while (i >= 0) {
            nums1[x--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[x--] = nums2[j--];
        }
    }

    // Single Element
    // Approach - I -> Freq Stored -> Brute Force -> this approach doesn't appear for negative numbers
    public static int singleEle(int nums[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int freq[] = new int[max+1];
        for(int i=0; i<nums.length; i++){
            freq[nums[i]]++;
        }

        for(int j=0; j<freq.length; j++){
            if(freq[j] == 1){
                return j;
            }
        }

        return -1;
    }

    public static int singleEle3(int nums[]){ // O(n log n) -> O(1)
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i+=2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }

        return nums[nums.length-1];
    }

    // Approach - II -> Hash Table -> O(n) + O(n) -> (n) & sc -> O(n)
    public static int singleEle2(int nums[]){
        HashMap<Integer, Integer> Hs = new HashMap<>();
        for(int i=0; i<nums.length; i++){ // O(n)
            Hs.put(nums[i], Hs.getOrDefault(nums[i], 0) + 1);
        }

        for(int num : Hs.keySet()){ //O(n)
            if(Hs.get(num) == 1){
                return num;
            }
        }

        return -1;
    }

    // Approach - III -> Using XOR -> O(n), O(1) -> Optimal Approach
    public static int singleEle4(int num[]){
        int ans = 0;
        for(int i=0; i<num.length; i++){
            ans = ans ^ num[i];
        }

        return ans;
    }

    // Contains Duplicate II
    public static boolean DuplicateII(int nums[], int k){        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j] && j-i <= k){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int nums[] = {4,1,2,1,2};
        int nums[] = {2, 2, 1};
        // int nums[] = {2, 3, 2, 3, 5};
        // System.out.println(singleEle3(nums));
        // System.out.println(singleEle2(nums));
        System.out.println(singleEle4(nums));
        // int nums[] = {3, 2, 3};
        // int nums[] = {};
        // int nums[] = {7, 7, 7, 7, 7};
        // int nums[] = {1, 2, 2, 3, 4, 5};
        // int nums[] = {2,2,1,1,1,2,2};
        // System.out.println(majorityElement(nums));
    /*     System.out.println(majorityElement2(nums));
        System.out.println(majorityElement3(nums));
        System.out.println(majorityElement4(nums));
        System.out.println(majorityElement5(nums)); */

        // int grid[][] = {{1, 3}, {2, 2}};
        int grid[][] = {{9,1,7},{8,9,2},{3,4,6}};
        // printArr(findMissingAndRepeatedValues(grid));
        // printArr(findMissingAndRepeatedValues2(grid));

        // System.out.println(PascalTringle(0));
        // System.out.println(PascalTringle2(3));
/* 
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        mergeSortedArrays2(nums1, nums2, 3, 3); */
        // printArr(mergeSortedArrays2(nums1, nums2, 3, 3));
        // printArr(nums1);

        int nums1[] = {1, 2, 3, 1};
        int k = 3;
        System.out.println(DuplicateII(nums1, k));
    }

    public static void printArr(int arr[]){
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
