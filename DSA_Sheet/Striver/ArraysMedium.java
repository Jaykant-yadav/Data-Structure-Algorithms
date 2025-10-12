package DSA_Sheet.Striver;

import java.util.HashMap;

public class ArraysMedium {
    // Longest Subarray with given Sum K(Positives)
    // Brute Force -> O(n^3)
    public static int longestSubArrSum(int nums[], int k){
        int n = nums.length;
        int maxLen = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                long sum = 0;
                for(int p=i; p<=j; p++){
                    sum += nums[p];
                }

                if(sum == k){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        return maxLen;
    }

    // Brute force -> O(n^2)
    public static int longestSubArrSum2(int nums[], int k){
        int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            int count = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                count ++;
                if(sum == k){
                    maxLen = Math.max(maxLen, count);
                }
            }
        }

        return maxLen;
    }

    // Optimal approach for negative or positive element -> O(n)
    public static int longestSubArrSum3(int nums[], int k){
        int sum = 0;
        // Declare map for store sum and index
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum += nums[i];
            // if sum equal then calculate maxLength, idx+1 because array iterate zero index
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }

            int rem = sum - k; // sum in substract remaining for find in map inside
            if(map.containsKey(rem)){ // if yes then 
                int len = i - map.get(rem); // curr index - rem in idx
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)){ // put on map every sum
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    // Optimal Solution -> O(2n)
    public static int longestSubArrSum4(int nums[], int k){
        int left = 0, right = 0;
        int sum = nums[0];
        int maxLen = 0;
        int n = nums.length;

        while (right < n) {
            // if less then of k means substract left ele with curr sum and leff increase;
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            // if sum equal to valid k than calculate max length
            if(sum == k){
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++; // increase
            if(right < n){
                sum += nums[right]; // calculate sum with right element
            }
        }

        return maxLen;
    }
    

    public static void main(String[] args) {
        // int nums[] = {2, 3, 5};
        // int nums[] = {1, 2, 5, 9, 7};
        int nums[] = {2,3,5,1,9};
        System.out.println(longestSubArrSum3(nums, 10));
    }
}
