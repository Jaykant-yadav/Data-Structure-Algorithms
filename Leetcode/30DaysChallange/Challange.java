import java.util.*;

public class Challange {
    // #1day 3Sum
    public static List<List<Integer>> threeSum(int nums[]) { // Fixed the return type to ArrayList<Integer>
        Arrays.sort(nums);
        List<List<Integer>> tripletsNum = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (!tripletsNum.contains(triplet)) {
                            tripletsNum.add(triplet);
                        }
                    }
                }
            }
        }
        return tripletsNum;
    }

    // #2day Length of Last Word
    public static int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0)
            return 0;
        int length = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }

    // #3 day Single Number
    public static int single(int num[]) {
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i == num.length - 1 || num[i] != num[i + 1]) {
                return num[i];
            }
            i++;
        }
        return -1; // Should never reach here
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR each number
        }
        return result;
    }

    // #4 day Find Missing and Repeating Number
    public static int[] findMissingAndRepeating(int[][] nums) {
        int[] result = new int[2];
        for (int[] arr : nums) {
            for (int num : arr) {
                if (num < 1 || num > arr.length) {
                    result[0] = num; // Repeating number
                }
            }
        }
        return result;
    }

    // #5 day Check Anagram
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        // Method 1
        /*
         * for(int i=0; i<chars1.length; i++) {
         * if(chars1[i] != chars2[i]) {
         * return false;
         * }
         * }
         */

        // method 2
        int idx1 = 0, idx2 = 0;
        while (idx1 < chars1.length && idx2 < chars2.length) {
            if (chars1[idx1] != chars2[idx2]) {
                return false;
            }
            idx1++;
            idx2++;
        }

        return true;
        // method 3
        // return Arrays.equals(chars1, chars2);
    }

    // #6 day Two Sum
    public static int[] twoSum(int[] nums, int target) {
        // Brute force
        /*
         * int ans[] = new int[2];
         * for (int i = 0; i < nums.length; i++) {
         * for (int j = i + 1; j < nums.length; j++) {
         * int sum = nums[i] + nums[j];
         * if (sum == target) {
         * System.out.println(i + "," + j);
         * }
         * }
         * }
         */

        // Optimized Solution
        // Create a copy of the array with indices
        int[][] numbersWithIndices = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numbersWithIndices[i] = new int[] { nums[i], i };
        }

        // Sort the array based on values
        Arrays.sort(numbersWithIndices, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = numbersWithIndices[left][0] + numbersWithIndices[right][0];
            if (sum == target) {
                return new int[] { numbersWithIndices[left][1], numbersWithIndices[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0]; // Return empty array if no solution found
    }

    // #6 Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // #7 day Majority Element
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // #7 day Remove Element
    public int removeElement(int[] nums, int val) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }

    // #8 Valid Palindrome
    // 1 method - O(n)
    public static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }

    // 2 method - tc - O(n) sc-O(1)
    public static boolean isPalindrome2(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

    // 3 method - tc - O(n) sc-O(n)
    public static boolean isPalindrome3(String s) {
        String ch = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = ch.length();
        for (int i = 0; i < n / 2; i++) {
            if (ch.charAt(i) != ch.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // #9 Valid Palindrome - II
    // with recursion
    public static boolean validPalindrome(String s) {
        return isValid(s, 0, s.length() - 1, false);
    }

    private static boolean isValid(String s, int left, int right, boolean deleted) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (deleted)
                    return false; // Already deleted once
                // Try skipping one character (either left or right)
                return isValid(s, left + 1, right, true) || isValid(s, left, right - 1, true);
            }
            left++;
            right--;
        }
        return true;
    }

    // without recursion
    public static boolean validPalindrome2(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

    // Binary search normal and using recursion
    public static int binarySearch(int nums[], int key, int st, int end) {
        /*
         * int st = 0, end = nums.length-1;
         * while (st <= end) {
         * int mid = (st + end) / 2;
         * 
         * if(nums[mid] == key) {
         * return mid;
         * }
         * 
         * if(nums[mid] > key) {
         * end = mid - 1;
         * } else {
         * st = mid + 1;
         * }
         * }
         * 
         * return -1;
         */

        if (st > end) {
            return -1;
        }

        int mid = (st + end) / 2;

        if (nums[mid] == key) {
            return mid;
        }

        if (nums[mid] > key) {
            return binarySearch(nums, key, st, mid - 1);
        } else {
            return binarySearch(nums, key, mid + 1, end);
        }
    }

    // Search insert position
    public static int insertPosition(int nums[], int target) {
        int st = 0, end = nums.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return st;
    }

    // Reverse String
    public static void reverseString(char[] s) {
        int st = 0, end = s.length - 1;

        while (st <= end) {
            char temp = s[end];
            s[end] = s[st];
            s[st] = temp;
            st++;
            end--;
        }
    }

    // Merge Sorted Array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ans[] = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        while (i < m) {
            ans[k++] = nums1[i++];
        }

        while (j < n) {
            ans[k++] = nums2[j++];
        }

        for (int p = 0; p < m + n; p++) {
            nums1[p] = ans[p];
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int x = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[x] = nums1[i];
                i--;
            } else {
                nums1[x] = nums2[j];
                j--;
            }
            x--;
        }

        while (j >= 0) {
            nums1[x] = nums2[j];
            j--;
            x--;
        }
    }

    public static void main(String[] args) {
        // int arr[] = {-1, 0, 1, 2, -1, -4};
        /*
         * int arr[] = { 0, 0, 0 };
         * List<List<Integer>> result = threeSum(arr);
         * System.out.println(result);
         */

        // String s = "Hello world";
        // System.out.println(lengthOfLastWord(s));

        /*
         * int arr[] = {4,1,2,1,2};
         * System.out.println(single(arr));
         */

        /*
         * String s = "racecar", t = "carrace";
         * System.out.println(isAnagram(s, t));
         */

        // #6 day Two Sum
        int arr[] = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));

    }
}
