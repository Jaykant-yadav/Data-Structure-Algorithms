
import java.util.*;

public class ArraysEasy {
    // Single Element ->
    // Brute force -> TC -> O(n)+O(m) -> O(n+m) , SC -> O(n)
    public static int singleEle(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map);

        for (int n : map.keySet()) {
            if (map.get(n) == 1) {
                return n;
            }
        }

        return -1;
    }

    // Using Frequency -> O(n^2)
    public static int singleEle2(int nums[]) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i < n; i++) {
            int freq = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                }
            }

            if (freq == 1) {
                return nums[i];
            }
        }

        return -1;
    }

    // Using XOR -> O(n)
    public static int singleEle3(int nums[]) {
        int XOR = 0;
        for (int i = 0; i < nums.length; i++) {
            XOR ^= nums[i];
        }

        return XOR;
    }

    // Majority Element
    // Using Hashmap -> TC - O(n) && SC -> O(n)
    public static int majorityEle(int nums[]) {
        HashMap<Integer, Integer> Hs = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            Hs.put(nums[i], Hs.getOrDefault(nums[i], 0) + 1);
            if (Hs.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    // Using Freq -> O(n^2)
    public static int majorityEle2(int nums[]) {
        int n = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int freq = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                }
            }

            if (freq > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    // Using sorting -> O(n log n)
    public static int majorityEle3(int nums[]) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }

    // Using Freq
    public static int majorityEle4(int nums[]) {
        Arrays.sort(nums);
        int freq = 1, ans = nums[0];
        int n = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                freq++;
            } else {
                freq = 1;
                ans = nums[i];
            }

            if (freq > n / 2) {
                return ans;
            }
        }
        return ans;
    }

    // Moore's voting Algorithms -> O(n) & O(1)
    public static int majorityEle5(int nums[]) {
        int freq = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (freq == 0) {
                ans = nums[i];
            }

            if (ans == nums[i]) {
                freq++;
            } else {
                freq--;
            }
        }
        return ans;
    }

    // Missing Number
    public static int missingNum(int nums[]) {
        int n_xor = nums.length; // total array length
        for (int i = 0; i < nums.length; i++) { // traverse array
            n_xor = n_xor ^ i;
            n_xor = n_xor ^ nums[i];
        }

        return n_xor;
    }

    // Find Missing And Repeated Values
    // Better approach
    public static int[] missingAndRepeatValues(int nums[][]) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length;
        int a = 0, b = 0;
        int actualSum = 0, expectedSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += nums[i][j]; // calculate actual Sum
                if (hs.contains(nums[i][j])) { // if already present value so repeated value
                    a = nums[i][j];
                }
                hs.add(nums[i][j]); // add in Hs unique value
            }
        }

        expectedSum = (n * n) * (n * n + 1) / 2; // math formula -> (n^2) * (n^2+1) / 2
        b = expectedSum + a - actualSum; // missing value

        return new int[] { a, b };
    }

    // Optimize Approach
    public static int[] missingAndRepeatValues2(int grid[][]) {
        int n = grid.length;
        int a = -1, b = -1;
        int res[] = new int[(n * n) + 1]; // new array size n^2
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res[grid[i][j]]++; // freq store
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == 2) { // repeated value
                a = i;
            }

            if (res[i] == 0) {// missing value
                b = i;
            }
        }

        return new int[] { a, b };
    }

    // Merge Sorted Arrays
    // using
    public static void merge(int nums1[], int nums2[], int n, int m) {
        int res[] = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        while (i < n) {
            res[k++] = nums1[i++];
        }

        while (j < m) {
            res[k++] = nums2[j++];
        }

        for(int x=0; x<res.length; x++){
            nums1[x] = res[x];
        }
    }

    public static void merge2(int nums1[], int m, int nums2[], int n){
        int i = m-1, j = n-1;
        int k = n+m-1;

        while (i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            k--; j--;
        }
    }

    // Best Time to Buy and Sell Stock
    public static int buyAndSell(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i<prices.length; i++){
            int sellPrice = prices[i];
            if(sellPrice > buyPrice){
                profit = Math.max(profit, sellPrice - buyPrice);
            }else{
                buyPrice = Math.min(prices[i], buyPrice);
            }
        }

        return profit;
    }

    public static int buyAndSell2(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i<prices.length; i++){
            buyPrice = Math.min(prices[i], buyPrice);
            profit = Math.max(profit, prices[i] - buyPrice);
        }
        return profit;
    }

    // Kadan's Algorithms (Maximum SumSubArray) - O(n)
    public static int maxSumOfSubArrays(int nums[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0){
                currSum = 0;
            }

        }

        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {5,4,-1,7,8};
        System.out.println(maxSumOfSubArrays(nums));
    }

    public static void printFun(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
