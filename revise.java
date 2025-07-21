import java.util.*;


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

    public static void maxSubArrSum(int nums[]) { // brute force -> O(n^3)
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum = currSum + nums[k];
                }
                System.out.println(currSum);
                max = Math.max(max, currSum);
                min = Math.min(min, currSum);
            }
        }
        System.out.println("Max of SubArray sum : " + max);
        System.out.println("Min of SubArray sum : " + min);
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
        for (int i = 0; i < price.length; i++) {
            if (buyPrice < price[i]) {
                int profit = price[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = price[i];
            }
        }
        return maxProfit;
    }

    // Twice value Appears in Array - O(n)
    public static boolean duplicateElement(int nums[]) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static void maxSubArrSum3(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }

                System.out.println(currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maxsum = " + maxSum);
    }

    public static int prefixSum(int nums[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        int prefix[] = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            System.out.println(prefix[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static int kadansAlgorithm(int arr[]) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            max = Math.max(currSum, max);
        }

        return max;
    }

    public static int trappedRainWater2(int height[]) {
        int n = height.length;
        // left max boundry
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // right max boundry
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trappedRainWater = 0;
        // loop
        for (int j = 0; j < height.length; j++) {
            int waterLevel = Math.min(leftMax[j], rightMax[j]);
            trappedRainWater += waterLevel - height[j];
        }

        return trappedRainWater;
    }

    public static int trappedRainWater3(int height[]) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int Water = 0;

        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    Water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    Water += rightMax - height[right];
                }
                right--;
            }
        }

        return Water;
    }

    public static int buyAndSellStocks2(int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < price.length; i++) {
            int sellPrice = price[i];
            if (buyPrice < sellPrice) {
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {
                buyPrice = sellPrice;
            }
        }

        return maxProfit;
    }

    public static boolean twitchEle(int arr[]) { // O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean twitchEle2(int arr[]) { // O(n)
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                return true;
            }
        }
        return false;
    }

    // Sorting -> BUbble, Selection, Insertion, Counting Sort
    public static void bubbleSort(int arr[]) {
        int swap = 0;
        // outer loop -> turn
        for (int turn = 0; turn < arr.length; turn++) {
            // inner loop -> arr.length-1-turn
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                // swap
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
        }

        System.out.println("Swap :" + swap);
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // Insertion
            arr[prev + 1] = curr;
        }
    }

    // Counting sort
    public static void countSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static int findMinDifference(int[] arr, int m) {
        if (arr.length < m)
            return -1; // Not enough packets to distribute

        Arrays.sort(arr); // Step 1: Sort the packet array

        int minDiff = Integer.MAX_VALUE;

        // Step 2: Slide window of size m and calculate difference
        for (int i = 0; i <= arr.length - m; i++) {
            int currentDiff = arr[i + m - 1] - arr[i]; // last - first in the window
            minDiff = Math.min(minDiff, currentDiff); // update minimum
        }

        return minDiff;
    }

    // Majority Element
    public static int majorityElement(int num[]) {
        Arrays.sort(num);
        int n = num.length;
        int freq = 1, ans = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] == num[i - 1]) {
                freq++;
            } else {
                freq = 1;
                ans = num[i];
            }

            if (freq > n / 2) {
                return ans;

            }
        }
        return -1;

    }

    public static int majorityElement2(int num[]) {
        int n = num.length;
        for (int val : num) {
            int freq = 0;
            for (int el : num) {
                if (el == val) {
                    freq++;
                }
            }

            if (freq > n / 2) {
                return val;
            }
        }

        return -1;
    }

    public static int majorityElement3(int num[]) {
        int freq = 0, ans = 0;
        for (int i = 0; i < num.length; i++) {
            if (freq == 0) {
                ans = num[i];
            }

            if (ans == num[i]) {
                freq++;
            } else {
                freq--;
            }
        }

        return ans;
    }

    // Diagonal Sum
    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                } else if (i + j == matrix.length - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static int diagonalSum2(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            // pd
            sum += matrix[i][i];
            // sd
            if (i != matrix.length - i - 1) {
                sum += matrix[i][matrix.length - i - 1];
            }
        }

        return sum;
    }

    // Search in Sorted Matrix
    public static boolean searchinSortedMat(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1; // col length

        while (row == matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static boolean palindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(String s) {

        String lowerString = s.toLowerCase();
        String finalString = lowerString.replaceAll("[^a-zA-Z0-9]", "");

        int size = finalString.length();
        int left = 0;
        int right = size - 1;

        while (left < right) {
            if (finalString.charAt(left) != finalString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static double getShortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == 'N') { // North
                y++;
            } else if (ch == 'E') { // East
                x++;
            } else if (ch == 'W') { // West
                x--;
            } else { // South
                y--;
            }
        }

        int x2 = x * x;
        int y2 = y * y;

        return Math.sqrt(x2 + y2);
    }

    public static String subString(String str, int si, int ed) {
        String subStr = "";
        for (int i = si; i < ed; i++) {
            subStr += str.charAt(i);
        }

        return subStr;
    }

    public static String convertFirstLatterUpper(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String stringCompression(String str) {
        StringBuilder sb = new StringBuilder("");
        Integer count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count);
            }
        }

        return sb.toString();
    }

    public static int stringCompression2(char chars[]) {
        int index = 0;
        int i = 0;
        while (i < chars.length) {
            char currChar = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == currChar) {
                count++;
                i++;
            }

            chars[index++] = currChar;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }

    public static int luckyNum(int nums[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int freq[] = new int[max + 1];
        for (int num : nums) {
            freq[num]++;
        }

        int ans = 0;
        int minFreq = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > minFreq) {
                minFreq = freq[i];
                ans = i;
            }
        }

        return ans;
    }

    public static boolean validAnagram(String str, String str2) {
        char ch[] = str.toCharArray();
        char ch2[] = str2.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch2);
        if (Arrays.equals(ch, ch2)) {
            return true;
        } else {
            return false;
        }
    }

    public static int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static int threeSumClosets(int num[], int target) {
        Arrays.sort(num);
        int closetSum = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; i++) {
            int low = i + 1, high = num.length - 1;

            while (low < high) {
                int currSum = num[i] + num[low] + num[high];

                if (target == currSum) {
                    return currSum;
                }

                if (Math.abs(currSum - target) < Math.abs(closetSum - target)) {
                    closetSum = currSum;
                }

                if (currSum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return closetSum;
    }

    public static String contest(String s) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                result.append(ch);
            } else if (ch == '*' && result.length() != 0) {
                result.deleteCharAt(result.length() - 1);
            } else if (ch == '#' && result.length() != 0) {
                result.append(result);
            } else if (ch == '%' && result.length() != 0) {
                result.reverse();
            }
        }

        return result.toString();
    }

    public static char contest2(String s, long k) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                result.append(ch);
            } else if (ch == '*' && result.length() != 0) {
                result.deleteCharAt(result.length() - 1);
            } else if (ch == '#' && result.length() != 0) {
                result.append(result);
            } else if (ch == '%' && result.length() != 0) {
                result.reverse();
            }
        }

        char dot = '.';

        if (result.length() > k) {
            return result.charAt((int) k);
        } else {
            return dot;
        }

    }

    public static char contest3(String s, long k) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                result.append(ch);
            } else if (ch == '*' && result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            } else if (ch == '#' && result.length() > 0) {
                String temp = result.toString(); // convert to string once
                if (result.length() * 2 > k + 1) {
                    // Only add up to k+1 characters to avoid unnecessary growth
                    for (int j = 0; j < temp.length() && result.length() <= k; j++) {
                        result.append(temp.charAt(j));
                    }
                } else {
                    result.append(temp); // safe to double if still small
                }
            } else if (ch == '%' && result.length() > 0) {
                result.reverse();
            }
        }

        return k < result.length() ? result.charAt((int) k) : '.';
    }

    public static void sortColor(int arr[]) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else if (arr[i] == 2) {
                count2++;
            }
        }

        int j = 0;
        while (count0-- > 0) {
            arr[j++] = 0;
        }
        while (count1-- > 0) {
            arr[j++] = 1;
        }
        while (count2-- > 0) {
            arr[j++] = 2;
        }
    }

    // Dutch National Flag Algorithm
    public static void sortColor2(int arr[]) {
        int mid = 0, low = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    // Median Of Two Sorted Arrays of Different Sizes
        private static int[] merge(int nums1[], int nums2[]) {
        int n = nums1.length;
        int m = nums2.length;
        int ans[] = new int[n+m];

        int i=0, j=0, k=0;
        while (i<n && j<m) {
            if(nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        while (n > i) {
            ans[k++] = nums1[i++];
        }

        while (m > j) {
            ans[k++] = nums2[j++];
        }

        return ans;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int res[] =  merge(nums1, nums2);
       int n = res.length;
       if(n % 2 == 0) {
        return ((res[n/2-1] + res[n/2]) / 2.0);
       } else {
        return res[n/2];
       } 
    }

    public static double findMedianSortedArrays2(int nums1[], int nums2[]){
        int n = nums1.length;
        int m = nums2.length;

        int i = 0, j = 0, merge1 = 0, merge2 = 0;
        for(int count = 0; count<=(n+m)/2; count++) {
            merge2 = merge1;
            if(i<n && (j>=m || nums1[i] <= nums2[j])) {
                merge1 = nums1[i++];
            }else {
                merge1 = nums2[j++];
            }
        }
        int Total = n + m;
        if(Total % 2 == 1) {
            return (double) merge1;
        }else {
            return (double) (merge1 + merge2) / 2;
        }
    }

    // Single Element in Sorted Array
    public static int singleNumber2(int nums[]){
        if(nums.length == 1) return nums[0];

        for(int i=0; i<nums.length; i++) {
            if(i == 0){
                if(nums[i] != nums[i+1]) return nums[i];
            }else if(i == nums.length-1){
                if(nums[i] != nums[i-1]) return nums[i];
            }else{
                if(nums[i] != nums[i+1] && nums[i] != nums[i-1]) return nums[i];
            }
        }

        return -1;
    }

    public static int singleNumber3(int nums[]){
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        int low = 1, high = n-2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) return nums[mid];

            // we are in left
            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) || (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                low = mid + 1;
            }

            // we are on right
            else{
                high = mid - 1;
            }
        }

        return -1;
    }

    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder("");
        sb.append(s.charAt(0));
        int count = 1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else {
                count = 1;
            }

            if(count < 3){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "leeetcode";
        System.out.println(makeFancyString(s));
    }

    public static boolean checkPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPrimeFrequency(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

        }
        return false;
    }

    public static List<List<Integer>> threesum(int nums[]) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> list = new ArrayList<>();
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if (!lists.contains(list)) {
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }

                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }

                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return lists;
    }

    public static void spiralMatrix(int matrix[][]) {
        int startCol = 0, endCol = matrix[0].length - 1;
        int startRow = 0, endRow = matrix.length - 1;

        while (startCol <= endCol && startRow <= endRow) {
            // Top
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][i] + " ");
            }

            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }
    }

    public static void largestndSmallest(int matrix[][]) {
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxNum = Math.max(maxNum, matrix[i][j]);
                minNum = Math.min(minNum, matrix[i][j]);
            }
        }

        System.out.println("largest number: " + maxNum);
        System.out.println("smallest number: " + minNum);
    }

    public static void searchINMatrix(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("(" + i + ", " + j + ")");
                }
            }
        }
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
