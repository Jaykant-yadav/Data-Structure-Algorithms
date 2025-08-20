package DSA.Practice.Binary_Search;

public class BinarySearch {
    // Iterative Search
    public static int binarySearch(int nums[], int key) {
        if (nums.length == 0)
            return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == key) {
                return mid;
            }

            if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Recusive Search
    public static int binarySearch2(int nums[], int low, int high, int target) {
        // Base case
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2; // mid calculate
        if (nums[mid] == target) { // target found
            return mid;
        } else if (nums[mid] < target) { // right side search
            return binarySearch2(nums, mid + 1, high, target);
        } else { // left side search
            return binarySearch2(nums, low, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 2, 5, 8, 9, 10, 15 };
        int key = 9;
        System.out.println(binarySearch(nums, key));
        System.out.println(binarySearch2(nums, 0, nums.length-1, 9));
    }
}
