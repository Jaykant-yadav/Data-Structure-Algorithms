package DSA.Practice.Binary_Search;

public class BinarySearch {
    public static int binarySearch(int nums[], int key){
        if(nums.length == 0) return -1;
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == key){
                return mid;
            }

            if(nums[mid] < key){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {2, 5, 8, 9, 10, 15};
        int key = 9;
        System.out.println(binarySearch(nums, key));
    }
}
