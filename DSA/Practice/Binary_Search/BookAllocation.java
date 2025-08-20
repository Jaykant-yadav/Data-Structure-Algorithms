package DSA.Practice.Binary_Search;

public class BookAllocation {
    private static boolean isValid(int arr[], int n, int m, int maxAllowedPages){ //O(n)
        // mid is called maxAllowedPages 
        int students = 1, pages = 0;

        for(int i=0; i<n; i++){
            if(arr[i] > maxAllowedPages) {
                return false;
            }

            if(pages + arr[i] <= maxAllowedPages){
                pages += arr[i];
            }else {
                students++;// assign new student
                pages = arr[i];
            }
        }

        return students > m ? false : true;
    }

    public static int findPages(int[] arr, int n, int m) {//O(logN * n)
        if(m > n){ // student > book
            return -1;
        }

        int sum = 0;
        for(int i=0; i<n; i++){ //O(n)
            sum += arr[i];
        }

        int ans = -1;
        int st = 0, end = sum; //range of possible ans

        while (st <= end) { //O(logN * n) // mid is feasible
            int mid = st + (end - st) / 2;

            if(isValid(arr, n, m, mid)){ //left
                ans = mid; // store as possible answer
                end = mid - 1;// try to find smaller max (minimize it)
            }else{ //right  // mid is too small
                st = mid + 1;// need bigger max, move right
            }
        }

        return ans;
        
    }
    public static void main(String[] args) {
        // int arr[] = {2, 1, 3, 4};
        int arr[] = {15, 17, 20};
        int n = 3; int m = 1;
        System.out.println(findPages(arr, n, m));
    }
}
