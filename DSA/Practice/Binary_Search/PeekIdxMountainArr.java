package DSA.Practice.Binary_Search;

public class PeekIdxMountainArr {
    // Brute Force - O(n)
    public static int peekIndex(int arr[]){
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                return arr[i-1];
            }
        }

        return -1;
    }

    // optimize using Binary search - O(log n)
    public static int peekIndex2(int arr[]){
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                return arr[mid];
            }

            if(arr[mid] < arr[mid+1]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Better Solution
    public static int peekIndex3(int arr[]){
        int low = 0, high = arr.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] < arr[mid+1]){
                low = mid + 1;
            }else {
                high = mid;
            }
        }

        return arr[low];
    }
    public static void main(String[] args) {
        int nums[] = {0, 1, 0};
        int nums2[] = {0, 2, 1, 0};
        int nums3[] = {0, 10, 5, 2};
        int nums4[] = {5, 5, 5, 5};
        System.out.println(peekIndex3(nums));
        System.out.println(peekIndex3(nums2));
        System.out.println(peekIndex3(nums3));
        System.out.println(peekIndex3(nums4));
    }
}
