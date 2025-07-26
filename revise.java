import java.util.Arrays;

public class revise {
    public static int[] binarySearch(int nums[], int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }

    private static int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                high = mid - 1; // keep searching in left half
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                low = mid + 1; // keep searching in right half
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static int kDiffPairs(int arr[], int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 0, high = 1;
        int countPaire = 0;
        while (low < n && high < n) {
            if (low == high || arr[high] - arr[low] < k) {
                high++;
            } else if (arr[high] - arr[low] > k) {
                low++;
            } else {
                countPaire++;
                int currLeft = arr[low];
                int currRight = arr[high];
                
                // skip duplicates
                while (low < n && arr[low] == currLeft) {
                    low++;
                }

                while (high < n && arr[high] == currRight) {
                    high++;
                }
            }

        }

        return countPaire;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 1, 5 };
        int k = 2;
        System.out.println(kDiffPairs(arr, k));
        // int nums[] = binarySearch(arr, k);
        // printArr(nums);

    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}