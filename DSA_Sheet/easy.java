package DSA_Sheet;

import java.util.*;

public class easy {
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

    public static void main(String[] args) {
        // int nums[] = {3, 2, 3};
        // int nums[] = {};
        // int nums[] = {7, 7, 7, 7, 7};
        // int nums[] = {1, 2, 2, 3, 4, 5};
        int nums[] = {2,2,1,1,1,2,2};
        // System.out.println(majorityElement(nums));
    /*     System.out.println(majorityElement2(nums));
        System.out.println(majorityElement3(nums));
        System.out.println(majorityElement4(nums));
        System.out.println(majorityElement5(nums)); */

        // int grid[][] = {{1, 3}, {2, 2}};
        int grid[][] = {{9,1,7},{8,9,2},{3,4,6}};
        printArr(findMissingAndRepeatedValues(grid));
        printArr(findMissingAndRepeatedValues2(grid));

        // System.out.println(PascalTringle(0));
        // System.out.println(PascalTringle2(3));
    }

    public static void printArr(int arr[]){
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
