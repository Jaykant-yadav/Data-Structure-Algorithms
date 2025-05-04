import java.util.*;

import DSA.Strings.string;

public class revise {
    public static int linearSearch(int nums[], int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int nums[], int key) {
        int st = 0;
        int end = nums.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == key) {
                return mid;
            }
            if (nums[mid] < key) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void reverseNum(int nums[]) {
        int st = 0, end = nums.length - 1;

        while (st < end) {
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }

    public static int[] largestndSmallest(int nums[]) {
        int lr = Integer.MIN_VALUE;
        int sm = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            lr = Math.max(lr, nums[i]);
            sm = Math.min(sm, nums[i]);
        }

        // System.out.println("Largest number : " + lr);
        // System.out.println("Smallest number : " + sm);
        int res[] = new int[2];
        res[0] = lr;
        res[1] = sm;

        return res;
    }

    public static void printSubArray(int nums[]) {
        int Ts = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(nums[k] + " ");
                }
                Ts++;
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Total subArray : " + Ts);
    }

    public static void pairOfArray(int nums[]) {
        int tp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.print("[" + nums[i] + ", " + nums[j] + "]" + " ");
                tp++;
            }
            System.out.println();
        }
        System.out.println(tp);
    }

    public static int maxSubArrSum(int nums[]) { // brute force -> O(n^3)
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += nums[k];
                }
                System.out.println(currSum);
                max = Math.max(max, currSum);
                min = Math.min(min, currSum);
            }
        }
        System.out.println("Min of SubArray sum : " + min);
        return max;
    }

    // Optimized solution -> O(n^2) -> Prefix sum
    public static int maxSubArrSum2(int nums[]) {
        int currSum = 0;
        int max = Integer.MIN_VALUE;

        // Prefix calculate
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // calculate prefix sum
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                currSum = i == 0 ? prefix[j] : prefix[j] - nums[i - 1];
                System.out.println(currSum);
                max = Math.max(max, currSum);
            }
        }

        return max;
    }

    // Kadan's Algorithm -> O(n)
    public static int KadansAlgo(int nums[]) {
        int currSum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            max = Math.max(max, currSum);
            if (currSum < 0) {
                currSum = 0;
            }

        }
        return max;
    }

    // Trapping Rain Water
    public static int trappedRainWater(int height[]) {
        int n = height.length;

        // left max boundries
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Right max boundries
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        int TrappedWater = 0;
        for (int k = 0; k < height.length; k++) {

            // WaterLevel = Math.min(Left max, right max)
            int WaterLevel = Math.min(rightMax[k], leftMax[k]);

            // TrappedWater = (waterLevel - height[i]) * width
            TrappedWater += WaterLevel - height[k];

        }

        return TrappedWater;
    }

    // Buy & Sell Stocks -> O(n)
    public static int buyAndSellStocks(int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<price.length; i++) {
            if(buyPrice < price[i]) {
                int profit = price[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else {
                buyPrice = price[i];
            }
        }
        return maxProfit;
    }

    // Twice value Appears in Array - O(n)
    public static boolean duplicateElement(int nums[]) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr1[] = { -2, -3, -1 };
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int price[] = {7, 1, 5, 3, 6, 4};
        int nums[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        // int index = linearSearch(arr1, 30);
        // System.out.println(binarySearch(arr1, 3));
        // printArr(arr1);
        // reverseNum(arr1);
        // System.out.println();
        // printArr(arr1);
        // int nums[] = largestndSmallest(arr1);
        // printArr(nums);
        // printSubArray(arr1);
        // pairOfArray(arr1);
        // System.out.println("max of subArray sum : " + maxSubArrSum(arr1));
        // System.out.println("max of subArray sum : " + maxSubArrSum2(arr1));
        // System.out.println(KadansAlgo(arr1));
        // System.out.println(trappedRainWater(height));
        // System.out.println(buyAndSellStocks(price));
        System.out.println(duplicateElement(nums));

        // int nums[] = {-1};
        // singleNumber(nums);
    }

    public static void singleNumber(int nums[]) {
        int max = Integer.MIN_VALUE;
        if (nums.length == 1) {
            System.out.println(nums[0]);
        }
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // [2, 2, 3, 5, 3] -> {[], [], [2], [2], [], [1]}
        int prefix[] = new int[max + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[nums[i]]++;
        }

        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] == 1) {
                System.out.println(i);
            }
        }
    }

    public static void rotateArr(int arr[], int k) {
        for (int i = 0; i <= k; i++) {
            leftSwap(arr);
        }
    }

    static void leftSwap(int arr[]) {
        int n = arr.length;
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class Student {
    public int roll_no;
    public String name;

    Student(int roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }
}
