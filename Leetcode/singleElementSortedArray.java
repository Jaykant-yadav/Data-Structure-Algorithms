public class singleElementSortedArray {
    public static int singleElement(int nums[]) {
        /*
         * int n = arr.length;
         * 
         * if(n == 1) {
         * return arr[0];
         * }
         * 
         * int st = 0, end = n-1;
         * while (st <= end) {
         * int mid = st +  (end - st) / 2;
         * if(mid == 0 && arr[0] != arr[1]) {
         * return arr[mid];
         * }
         * 
         * if(mid == n-1 && arr[n-1] != arr[n-2]) {
         * return arr[mid];
         * }
         * 
         * if(arr[mid-1] != arr[mid] && arr[mid] != arr[mid+1]) {
         * return arr[mid];
         * }
         * 
         * if(mid % 2 == 0) { //even
         * if(arr[mid - 1] == arr[mid]){ //left
         * end = mid - 1;
         * } else { //right
         * st = mid + 1;
         * }
         * } else { //odd
         * if(arr[mid - 1] == arr[mid]){ //right
         * st = mid + 1;
         * } else { //left
         * end = mid + 1;
         * }
         * }
         * }
         * return -1;
         */

        int n = nums.length;

        int st = 0, end = n - 1;
        while (st < end) {
            int mid = st + (end - st) / 2;

            // Ensure mid is always even for easier handling
            if (mid % 2 == 1) {
                mid--; // Ensure mid is even to always compare mid and mid+1
            }

            if (nums[mid] == nums[mid + 1]) {
                // If mid and mid+1 are the same, the single element is on the right half
                st = mid + 2;
            } else {
                // If mid and mid+1 are different, the single element is on the left half
                end = mid;
            }
        }

        // When the loop terminates, st will equal end, pointing to the unique element
        return nums[st];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 2, 3, 3, 4, 4 };
        System.out.println(singleElement(nums));
    }
}
