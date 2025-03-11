package arrays;

public class peakElement {
    //Time Complexity - O(log n)
    public static int peakMountainArr(int arr[]) { 
        int n = arr.length;
        int st = 1, end = n-2;

        while (st <= end) {
            int mid = st+(end-st) / 2;

            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                return arr[mid];
            }
            else if(arr[mid-1] < arr[mid]) { //right
                st = mid + 1;
            } else { // left
                end = mid - 1;
            } 
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {0,2,1,0};
        System.out.println(peakMountainArr(arr));

    }
}
