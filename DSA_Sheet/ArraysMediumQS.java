package DSA_Sheet;
import java.util.*;

import DSA.Arrays.linearSearch;
public class ArraysMediumQS {
    // Set Matrix Zeroes
    public static void setZeroes(int matrix[][]) { // O(n*m) * (n + m) + (n * m)
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) { // O(n * m)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) { // find in matrix zero
                    rowZero(i, matrix); // insert -1 in row respectively condition replace 1 .
                    colZero(j, matrix); // insert -1 in col respectively condition replace 1 .
                }
            }
        }

        for (int i = 0; i < m; i++) { // O(n * m)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) { // replace -1 to 0
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void rowZero(int i, int matrix[][]) { // insert in row -1
        for (int j = 0; j < matrix[0].length; j++) { // O(n)
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public static void colZero(int j, int matrix[][]) { // insert in col -1
        for (int i = 0; i < matrix.length; i++) { // O(m)
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    // Approach - II -> Better solution
    public static void setZeroes2(int matrix[][]) {// tc-> O(n ^ 2) sc-> O(n + m)
        int m = matrix.length;
        int n = matrix[0].length;

        int row[] = new int[m]; // create a row array //O(m)
        int col[] = new int[n]; // create a col array //O(n)

        for (int i = 0; i < m; i++) { // O(n)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1; // insert in row 1.
                    col[j] = 1; // insert in col 1
                }
            }
        }

        for (int i = 0; i < m; i++) { // O(n)
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0; // so row || col = 1 then completely row and col insert in metrix 0
                }
            }
        }
    }

    // Approach - III -> Optimized Solution
    public static void setZeroes3(int matrix[][]) {
        boolean firstRow = false, firstCol = false;
        int m = matrix.length;
        int n = matrix[0].length;

        // First Row
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstRow = true;
                break;
            }
        }

        // First Col
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstCol = true;
                break;
            }
        }

        // First row and Col in assign Zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Inner Matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstCol) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    // Kadan's Algorithm's - O(n)
    public static int kadansAlgo(int nums[]) {
        if (nums.length == 0)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }

    // Sort Colors - Sort an array of 0's, 1's and 2's
    // Brute force - > O(n) -> O(1)
    public static int[] sortColor(int nums[]) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == c0) {
                c0++;
            }
            if (nums[i] == c1) {
                c1++;
            }
            if (nums[i] == c2) {
                c2++;
            }
        }
        int i = 0;
        while (c0 != 0) {
            nums[i] = 0;
            c0--;
            i++;
        }

        while (c1 != 0 && c0 != 0) {
            nums[i] = 1;
            c1--;
            i++;
        }

        while (c2 != 0 && c1 != 0) {
            nums[i] = 2;
            c2--;
            i++;
        }

        return nums;
    }

    // Optimize Solution -> DNF Algorithms -> O(n) -> O(1)
    public static int[] sortColor2(int nums[]) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }

        return nums;
    }

    // Best Time to Buy and Sell Stock
    public static int buyAndSellStock(int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < price.length; i++) {
            int sellPrice = price[i];
            if (buyPrice < sellPrice) {
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = sellPrice;
            }
        }

        return maxProfit;
    }

    // Power (X, N)
    public static double powerXn(double x, double n) {
        if (n == 0) {
            return 1;
        }

        double xn1 = powerXn(x, n - 1);
        double xn = xn1 * x;

        return xn;
    }

    public static int powerXn2(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPower = powerXn2(x, n / 2);
        int halfPowerSq = halfPower * halfPower;

        if (n % 2 != 0) {
            halfPowerSq = x * halfPowerSq;
        }

        return halfPowerSq;
    }

    // 3Sum
    // Brute Force approach - O(n ^ 3), O(n)
    public static List<List<Integer>> threeSum(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                List<Integer> ans = new ArrayList<>();
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        if (!result.contains(ans)) {
                            result.add(ans);
                        }
                    }
                }

            }
        }

        return result;
    }

    // Optimal Approach -> O(n)
    public static List<List<Integer>> threeSum2(int nums[]) {
        List<List<Integer>> resuList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    resuList.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                    j++;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return resuList;
    }

    // 4 Sum
    // Optimal Approach - O(n ^ 3) -> O(1)
    public static List<List<Integer>> fourSum(int nums[], int target) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        resList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (k < l && nums[l] == nums[l - 1])
                            l--;

                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return resList;
    }

    // Brute Force - > O(n ^ 4)
    public static List<List<Integer>> fourSum3(int nums[], int target){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                for(int k=j+1; k<n-1; k++){
                    for(int l=k+1; l<n; l++){
                        List<Integer> ans = new ArrayList<>();
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if(sum == target){
                            if(!res.contains(ans)){
                                // ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l])); 
                                ans.add(nums[i]);
                                ans.add(nums[j]);
                                ans.add(nums[k]);
                                ans.add(nums[l]);

                                res.add(ans);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    // Approach - II
    public static List<List<Integer>> fourSum2(int nums[], int target){
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                for(int k=j+1; k<n-1; k++){
                    long newTerget = target;
                    newTerget -= nums[i];
                    newTerget -= nums[j];
                    newTerget -= nums[k];
                    
                    // binary Search
                    int low = k+1;
                    int high = n-1;
                    
                    while (low <= high) {
                        int mid = low + (high - low) / 2;
                        
                        if(nums[mid] == newTerget){
                            List<Integer> ans = new ArrayList<>();
                            ans.add(nums[i]);
                            ans.add(nums[j]);
                            ans.add(nums[k]);
                            ans.add(nums[mid]);
                            
                            set.add(ans);
                            break;
                        }else if(nums[mid] < newTerget){
                            low = mid + 1;
                        }else{
                            high = mid - 1;
                        }
                    }
                }
            }
        }
        List<List<Integer>> reLists = new ArrayList<>(set);

        return reLists;
    }

    //  Longest Consecutive Sequence
    // Brute Force -> O(n ^ 2)
    public static int longestConsecutive(int[] nums) {
        int longest = 1;
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            int count = 1;

            while (linearSearch(nums, x+1)) {
                x = x + 1;
                count++;                
            }

            longest = Math.max(longest, count);
        }
        return longest;
    }

    private static boolean linearSearch(int nums[], int x){
        for(int num : nums){
            if(num == x){
                return true;
            }
        }

        return false;
    }

    // Better Approach -> O(n logn)
    public static int longestConsecutive2(int nums[]){
        Arrays.sort(nums);
        int longest = 1;
        int cnt = 0;
        int lastSmaller = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i]-1 == lastSmaller){
                cnt++;
                lastSmaller = nums[i];
            }else if(lastSmaller != nums[i]){
                cnt = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    // Optimal Approach -> O(n)
    public static int longestConsecutive3(int nums[]){
        int n = nums.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    // Permutation
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void getPermutation(int nums[], int idx, List<List<Integer>> ans) {
        if (idx == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums)
                perm.add(num);
            ans.add(perm);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            getPermutation(nums, idx + 1, ans);
            swap(nums, idx, i);
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        // setZeroes(matrix);
        // setZeroes2(matrix);
        // setZeroes3(matrix);
        /*
         * int arr[] = {1, 2, 3, 4};
         * System.out.println(kadansAlgo(arr));
         */

        /*
         * int arr[] = {2, 0, 2, 1, 1, 0};
         * printArr(sortColor2(arr));
         */

        // int price[] = {-7,6,-4,3,-1};
        // System.out.println(buyAndSellStock(price));

        // System.out.println(powerXn(2.000000, 5));
        // System.out.println(powerXn2(2, 5));

        int nums[] = { 0,3,7,2,5,8,4,6,0,1 };
        // int nums[] = { 2, 2, 2, 2, 2 };
        // System.out.println(fourSum(nums, 0));
        // System.out.println(fourSum2(nums, 0));
        // System.out.println(fourSum3(nums, 0));

        /*
         * List<List<Integer>> ans = new ArrayList<>();
         * int arr[] = {3, 2, 1};
         * getPermutation(arr, 0, ans);
         * System.out.println(ans);
         */

        /*
         * for (int i = 0; i < matrix.length; i++) {
         * for (int j = 0; j < matrix[0].length; j++) {
         * System.out.print(matrix[i][j] + " ");
         * }
         * System.out.println();
         * }
         */

         int n[] = {0,3,7,2,5,8,4,6,0,1};
         int n2[] = {100,4,200,1,3,2};
         int n3[] = {1, 0, 1, 2};
        System.out.println(longestConsecutive2(n));
        System.out.println(longestConsecutive(n2));
        System.out.println(longestConsecutive(n3));
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
