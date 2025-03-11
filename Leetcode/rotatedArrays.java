//Leetcode link -> https://l+eetcode.com/problems/search-in-rotated-sorted-array/submissions/1496457291/
//Yt link -> https://www.youtube.com/watch?v=6WNZQBHWQJs
public class rotatedArrays {
    //Time Complexity - O(log n)
    public static int searchRotatedArr(int arr[], int target){
        int start = 0, end = arr.length-1;
        while (start<=end) {
            //calculate mid
            int mid = start+(end-start)/2;
            //mid == target -> mid
            if(arr[mid] == target){
                return mid;
            }
            //start -> Mid
            if(arr[start] <= arr[mid]){ // check left side sorted
                //start -> target <- mid
                if(arr[start] <= target && target <= arr[mid]){
                    end = mid-1;
                } else{
                    start = mid+1;
                }
            } else{ //mid -> end -> check right side sorted
                //mid -> target <- end
                if(arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(searchRotatedArr(arr, target));
    }
}
