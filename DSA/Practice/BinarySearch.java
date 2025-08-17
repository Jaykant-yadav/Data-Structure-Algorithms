package DSA.Practice;

public class BinarySearch {
    // Brute Force - O(n)
    public static int singleEle(int nums[]){ // O(n)
        int n = nums.length;
        if(n == 1) return nums[0]; // array length == 1 ofcourse return 0 idx element
        for(int i=0; i<nums.length; i++){ // loop iterate to end of length
            if(i == 0){ // start
                if(nums[i] != nums[i+1]) return nums[i];
            } else if(i == n-1){ // end
                if(nums[i] != nums[i-1]) return nums[i];
            }else{ // middle all element
                if(nums[i] != nums[i+1] && nums[i] != nums[i-1]) return nums[i];
            }
        }

        return -1;
    }

    // Optimize using Binary Search - O(log n)
    public static int singleEle2(int nums[]){
        // Logic
        // -> (even, odd) => element is on right half, X left element
        // -> (odd, even) => element is the left half, X right element
        int n = nums.length;
        if(n == 1) return nums[0]; // len - 1
        if(nums[0] != nums[1]) return nums[0]; // start
        if(nums[n-1] != nums[n-2]) return nums[n-1]; // last 

        int low = 1, high = n-2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            // we are left
            if((mid % 2 == 1 && nums[mid-1] == nums[mid]) || (mid % 2 == 0 && nums[mid+1] == nums[mid])){
                low = mid + 1;
            }else { // we are right
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        // int nums[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 7, 7};
        System.out.println(singleEle2(nums));
    }
}
