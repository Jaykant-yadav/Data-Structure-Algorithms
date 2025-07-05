import java.util.*;
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

     // Find Minimum in Rotated Sorted Array
    public static int minRotatedArray(int arr[]) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[low] <= arr[high]) {
                min = Math.min(min, arr[low]);
                break;
            }
            if(arr[low] <= arr[mid]){
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    // 3 SUM
    public static List<List<Integer>> threeSum(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = n-1;
            while (j<k) {
                List<Integer> list = new ArrayList<>();
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) {
                    k--;
                }else if(sum < 0) {
                    j++;
                } else {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
            }
        }

        return lists;
    }

    // Search in Rotated Sorted Array
    public static int search(int nums[], int target){
        int n = nums.length-1;
        int st = 0, end = n-1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[st] <= nums[mid]) {
                if(nums[st] <= target && target < nums[mid]){
                    end = mid - 1;
                }else {
                    st = mid + 1;
                }
            }else {
                if(nums[mid] < target && target <= nums[end]) {
                    st = mid + 1;
                }else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int nums[] = {4,5,6,7,0,1,2};
        int ans[] = productArray3(nums);
        System.out.println(search(nums, 0));
        for(int num : ans) {
            // System.out.println(num);
        }
    }
}