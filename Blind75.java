import java.util.*;

import DSA.Stacks.stack;

public class Blind75 {
    // Two Sum - O(n^2)
    public static int[] twoSum(int num[], int target) {
        for(int i=0; i<num.length-1; i++) {
            for(int j=i+1; j<num.length; j++) {
                if(num[i] + num[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[]{};
    }

    // Best Time to Buy and Sell Stock - O(n)
    public static int buyAndSellStock(int price[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<price.length; i++) {
            int sellPrice = price[i];
            if(sellPrice > buyPrice) {
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else {
                buyPrice = sellPrice;
            }
        }

        return maxProfit;
    }

    // Product of Array Except Self
    // Brute force Approach - O(n^2)
    public static int[] productArray(int nums[]){ 
        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int prod = 1;
            for(int j=0; j<nums.length; j++) {
                if(i != j) {
                    prod *= nums[j];
                }
            }
            ans[i] = prod;
        }
        return ans;
    }

    // Optimized solution - TC -> O(n) SC -> O(n)
    public static int[] productArray2(int nums[]) {
        int n = nums.length;
        int ans[] = new int[n];
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int j=n-2; j>=0; j--) {
            suffix[j] = suffix[j+1] * nums[j+1];
        }

        for(int i=0; i<n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }

    // space complexity optimized
    public static int[] productArray3(int nums[]) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = 1;
        // prefix => ans
        for(int i=1; i<n; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        int suffix = 1;
        // suffix
        for(int i=n-2; i>=0; i--) {
            suffix *= nums[i+1]; //ith suffix
            ans[i] *= suffix;
        }

        return ans;
    }

    // Kadane's Algorithm, maximum subarray sum
    public static int KadanesAlog(int nums[]) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            if(currSum < 0) {
                currSum = 0;
            }

            max = Math.max(max, currSum);
        }

        return max;
    }

    //  Maximum Product Subarray
    public static int maxProduct(int num[]) { //O(n^3)
        int max = Integer.MIN_VALUE;
        for(int i=0; i<num.length; i++) {
            for(int j=i; j<num.length; j++){
                int currProduct = 1;
                for(int k=i; k<=j; k++) {
                    currProduct *= num[k];
                }
                max = Math.max(max, currProduct);
            }
        }

        return max;
    }

    public static int maxProduct2(int num[]) { //O(n^2)
        int max = Integer.MIN_VALUE;
        int currProduct = 1;
        for(int i=0; i<num.length; i++) {
            for(int j=i; j<num.length; j++){
                currProduct *= num[j];
                max = Math.max(max, currProduct);
            }
        }

        return max;
    }

    // Optimal Solution -> O(n)
    public static int maxProduct3(int num[]) {
        int max = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        int n = num.length;
        for(int i=0; i<n; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix = prefix * num[i];
            suffix = suffix * num[n-i-1];
            max = Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }
    public static void main(String args[]) {
        int nums[] = {0, 2};
        int ans[] = productArray3(nums);
        System.out.println(maxProduct3(nums));
        for(int num : ans) {
            // System.out.println(num);
        }
    }
}