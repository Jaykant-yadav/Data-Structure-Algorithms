package DSA.Practice.Binary_Search;

public class SearchInRotatedArr{
    public static int searchInRotatedArr(int nums[], int target){
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){ // if target found
                return mid;
            }
            
            if(nums[low] <= nums[mid]){ // target align low b/w mid
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else { // target align mid b/w high
                if(nums[mid] < target && target >= nums[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int nums1[] = {4,5,6,7,0,1,2};
        System.out.println(searchInRotatedArr(nums, 0));
        System.out.println(searchInRotatedArr(nums1, 3));
    }
}